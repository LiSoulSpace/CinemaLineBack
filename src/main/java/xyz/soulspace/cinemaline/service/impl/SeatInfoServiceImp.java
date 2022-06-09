package xyz.soulspace.cinemaline.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import xyz.soulspace.cinemaline.dto.BuyTicketDTO;
import xyz.soulspace.cinemaline.dto.SeatDTO;
import xyz.soulspace.cinemaline.entity.Film;
import xyz.soulspace.cinemaline.entity.Order;
import xyz.soulspace.cinemaline.entity.Process;
import xyz.soulspace.cinemaline.entity.SeatInfo;
import xyz.soulspace.cinemaline.mapper.FilmMapper;
import xyz.soulspace.cinemaline.mapper.OrderMapper;
import xyz.soulspace.cinemaline.mapper.ProcessMapper;
import xyz.soulspace.cinemaline.mapper.SeatInfoMapper;
import xyz.soulspace.cinemaline.service.SeatInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
}
