package xyz.soulspace.cinemaline.service.impl;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.BuyTicketDTO;
import xyz.soulspace.cinemaline.dto.SeatDTO;
import xyz.soulspace.cinemaline.entity.Film;
import xyz.soulspace.cinemaline.entity.Order;
import xyz.soulspace.cinemaline.entity.Process;
import xyz.soulspace.cinemaline.entity.SeatInfo;
import xyz.soulspace.cinemaline.kafka.producer.OrderProducer;
import xyz.soulspace.cinemaline.mapper.FilmMapper;
import xyz.soulspace.cinemaline.mapper.OrderMapper;
import xyz.soulspace.cinemaline.mapper.ProcessMapper;
import xyz.soulspace.cinemaline.mapper.SeatInfoMapper;
import xyz.soulspace.cinemaline.redis.RedisService;
import xyz.soulspace.cinemaline.service.SeatInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
@Slf4j
@Service
public class SeatInfoServiceImp extends ServiceImpl<SeatInfoMapper, SeatInfo> implements SeatInfoService {
    @Autowired
    SeatInfoMapper seatInfoMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProcessMapper processMapper;
    @Autowired
    FilmMapper filmMapper;
    @Autowired
    RedisService redisService;
    @Autowired
    OrderProducer orderProducer;

    @Override
    public JSONObject getSeatInfo(Long filmId, Long cinemaId, Long showId) {
        try {
            List<String> strings = seatInfoMapper.selectSeatDTOByFSCID(filmId, cinemaId, showId);
            if (strings.size() <= 0) {
                return null;
            }
            String seatInfo = strings.get(0);
            return JSON.parseObject(seatInfo, Feature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional
    public BuyTicketDTO getTicket(Long userId, Long filmId, Long cinemaId, Long showId, List<Integer> cols, List<Integer> rows) {
        List<SeatInfo> seatInfos = seatInfoMapper.selectSeatArrangementByProcessId(showId);
        String seatArrangement = seatInfos.get(0).getSeatArrangement();
        SeatDTO seatDTO = JSON.parseObject(seatArrangement, SeatDTO.class, Feature.DisableCircularReferenceDetect);
        log.warn(seatDTO.toString());
        log.warn("需要预定的座位{}-{}", Arrays.toString(rows.toArray()), Arrays.toString(cols.toArray()));
        StringBuilder sb = new StringBuilder();
        log.warn(String.valueOf(rows.size()));
        for (int i = 0; i < rows.size(); i++) {
            if (seatDTO.getSeatMsg().get(rows.get(i)).get(cols.get(i)) != 0) {
                log.error("座位({},{})不可用, 为{}", rows.get(i), cols.get(i),
                        seatDTO.getSeatMsg().get(rows.get(i)).get(cols.get(i)));
                return null;
            } else {
                List<List<Integer>> seatMsg = seatDTO.getSeatMsg();
                sb.append('(').append(rows.get(i)).append(',')
                        .append(cols.get(i)).append(')').append(' ');
                Integer set = seatMsg.get(rows.get(i)).set(cols.get(i), 2);
                seatDTO.setSeatMsg(seatMsg);
            }
        }
        String s = seatDTO.seatsToString();
        log.warn("写回的座位信息：{}", s);
        int i = seatInfoMapper.setSeatArrangementByProcessId(s, showId);
        if (i > 0) {
            Order order = new Order();
            order.setTicketNum(rows.size());
            order.setProcessId(showId);
            order.setUserId(userId);
            order.setSeatInfo(sb.toString());
            log.warn(order.toString());
            int insert = orderMapper.insert(order);
            log.warn("写入的订单信息{}", order);
            if (insert > 0) {
                Process process = processMapper.selectById(showId);
                Film film = filmMapper.selectById(process.getFilmId());
                BuyTicketDTO ticketDTO = BuyTicketDTO.builder().col(cols).row(rows).orderId(order.getId())
                        .cost(process.getCost()).room(process.getRoomName())
                        .showTime(process.getStartTime()).duration(film.getDuration())
                        .title(film.getFilmName()).qrcode("test QRCode").build();
                log.warn("返回的票相关数据{}", ticketDTO);
                return ticketDTO;
            }
        }
        return null;
    }

    @Override
    public CommonResult<Map<String, Object>> canIBuy(Long userId, Long filmId, Long cinemaId, Long showId, List<Integer> cols, List<Integer> rows) {
        List<String> luaKeys = new ArrayList<>();
        luaKeys.add(String.valueOf(showId));
        luaKeys.add(String.valueOf(cols.size()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.size(); i++) {
            if (i != 0) sb.append(' ');
            sb.append('(').append(rows.get(i)).append(',').append(cols.get(i)).append(')');
        }
        luaKeys.add(sb.toString());
        log.debug("购票座位为{}", sb.toString());
        Object execute = redisService.execute("getTicket.lua", luaKeys);
        if (execute.toString().equals("0")) {
            Order order = new Order();
            order.setTicketNum(rows.size());
            order.setProcessId(showId);
            order.setUserId(userId);
            order.setSeatInfo(sb.toString());
            boolean sendOrder = orderProducer.sendOrder(order);
            if (!sendOrder) return CommonResult.failed(1, "服务器异常", null);
            boolean sendNewSeatInfo = orderProducer.sendNewSeatInfo(sb.toString(), showId);
            if (!sendNewSeatInfo) return CommonResult.failed(1, "服务器异常", null);
            Map<String, Object> map = new HashMap<>();
            return CommonResult.success(map);
        } else {
            String string = execute.toString();
            return CommonResult.failed(1, "购买" + string + "失败", null);
        }
    }

    @Override
    public BuyTicketDTO getTicketKafka(Long userId, Long filmId, Long cinemaId, Long showId, List<Integer> cols, List<Integer> rows) {
        List<SeatInfo> seatInfos = seatInfoMapper.selectSeatArrangementByProcessId(showId);
        String seatArrangement = seatInfos.get(0).getSeatArrangement();
        SeatDTO seatDTO = JSON.parseObject(seatArrangement, SeatDTO.class, Feature.DisableCircularReferenceDetect);
        log.warn(seatDTO.toString());
        log.warn("需要预定的座位{}-{}", Arrays.toString(rows.toArray()), Arrays.toString(cols.toArray()));
        StringBuilder sb = new StringBuilder();
        log.warn(String.valueOf(rows.size()));
        for (int i = 0; i < rows.size(); i++) {
            if (seatDTO.getSeatMsg().get(rows.get(i)).get(cols.get(i)) != 0) {
                log.error("座位({},{})不可用, 为{}", rows.get(i), cols.get(i),
                        seatDTO.getSeatMsg().get(rows.get(i)).get(cols.get(i)));
                return null;
            } else {
                List<List<Integer>> seatMsg = seatDTO.getSeatMsg();
                sb.append('(').append(rows.get(i)).append(',')
                        .append(cols.get(i)).append(')').append(' ');
                Integer set = seatMsg.get(rows.get(i)).set(cols.get(i), 2);
                seatDTO.setSeatMsg(seatMsg);
            }
        }
        String s = seatDTO.seatsToString();
        log.warn("写回的座位信息：{}", s);
        int i = seatInfoMapper.setSeatArrangementByProcessId(s, showId);
        if (i > 0) {
            Order order = new Order();
            order.setTicketNum(rows.size());
            order.setProcessId(showId);
            order.setUserId(userId);
            order.setSeatInfo(sb.toString());
            log.warn(order.toString());
            int insert = orderMapper.insert(order);
            log.warn("写入的订单信息{}", order);
            if (insert > 0) {
                Process process = processMapper.selectById(showId);
                Film film = filmMapper.selectById(process.getFilmId());
                BuyTicketDTO ticketDTO = BuyTicketDTO.builder().col(cols).row(rows).orderId(order.getId())
                        .cost(process.getCost()).room(process.getRoomName())
                        .showTime(process.getStartTime()).duration(film.getDuration())
                        .title(film.getFilmName()).qrcode("test QRCode").build();
                log.warn("返回的票相关数据{}", ticketDTO);
                return ticketDTO;
            }
        }
        return null;
    }

    @PostConstruct
    private void initRedisData() {
        log.debug("Init redisData started!");
        redisService.flushAll();
        log.debug("flushAll Over");
        List<SeatInfo> list = list();
        list.forEach(seatInfo -> {
            String seatArrangement = seatInfo.getSeatArrangement();
            SeatDTO seatDTO = JSON.parseObject(seatArrangement,
                    SeatDTO.class, Feature.DisableCircularReferenceDetect);
            List<List<Integer>> seatMsg = seatDTO.getSeatMsg();
            long processId = seatInfo.getProcessId();
            int m = seatMsg.size();
            int n = seatMsg.get(0).size();
            String s = "set:seatArrangement:" + processId;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (seatMsg.get(i).get(j) == 0) {
                        String seatI = String.format("(%d,%d)", i, j);
                        redisService.sAdd(s, seatI);
                    }
                }
            }
        });
        log.debug("座位信息添加完成");
    }
}
