package xyz.soulspace.cinemaline.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.BuyTicketDTO;
import xyz.soulspace.cinemaline.service.SeatInfoService;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/buy")
@Tag(name = "座位信息控制器(SeatInfoController)")
public class SeatInfoController {
    @Autowired
    SeatInfoService seatInfoService;

    @Operation(summary = "获取座位信息")
    @RequestMapping(value = "/getSeat", method = RequestMethod.GET)
    public ResponseEntity<?> getSeatInfo(@RequestParam("filmId") Long filmId,
                                         @RequestParam("cinemaId") Long cinemaId,
                                         @RequestParam("showId") Long showId) {
        JSONObject seatInfo = seatInfoService.getSeatInfo(filmId, cinemaId, showId);
        return ResponseEntity.ok(CommonResult.success(seatInfo));
    }

    @Operation(summary = "买票")
    @RequestMapping(value = "/getTicket", method = RequestMethod.GET)
    public ResponseEntity<?> buyTicket(@RequestParam("userId") Long userId,
                                       @RequestParam("filmId") Long filmId,
                                       @RequestParam("cinemaId") Long cinemaId,
                                       @RequestParam("showId") Long showId,
                                       @RequestParam("row") List<Integer> row,
                                       @RequestParam("col") List<Integer> col
    ) {
        BuyTicketDTO ticket = seatInfoService.getTicket(userId, filmId, cinemaId, showId, col, row);
        if (ticket != null)
            return ResponseEntity.ok(CommonResult.success(ticket));
        else return ResponseEntity.ok(CommonResult.failed(1, "", null));
    }
}
