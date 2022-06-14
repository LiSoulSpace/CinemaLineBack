package xyz.soulspace.cinemaline.service;

import com.alibaba.fastjson.JSONObject;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.BuyTicketDTO;
import xyz.soulspace.cinemaline.dto.SeatDTO;
import xyz.soulspace.cinemaline.entity.SeatInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
public interface SeatInfoService extends IService<SeatInfo> {
    JSONObject getSeatInfo(Long filmId, Long cinemaId, Long showId);

    BuyTicketDTO getTicket(Long userId, Long filmId, Long cinemaId, Long showId,
                           List<Integer> cols, List<Integer> rows);

    CommonResult<Map<String, Object>> canIBuy(Long userId, Long filmId, Long cinemaId, Long showId,
                              List<Integer> cols, List<Integer> rows);

    BuyTicketDTO getTicketKafka(Long userId, Long filmId, Long cinemaId, Long showId,
                           List<Integer> cols, List<Integer> rows);
}
