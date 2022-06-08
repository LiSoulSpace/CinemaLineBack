package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.ShowTimeDTO;
import xyz.soulspace.cinemaline.service.ProcessService;
import xyz.soulspace.cinemaline.vo.TimeVO;

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
@Controller
@CrossOrigin
@RequestMapping("/cinemaline/process")
@Tag(name = "电影场次控制器(TimeController)")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @Operation(summary = "获取场次信息 根据电影号和影院号")
    @RequestMapping(value = "/getTimeList", method = RequestMethod.GET)
    public ResponseEntity<?> getTimeList(@RequestParam("filmId") Long filmId,
                                         @RequestParam("cinemaId") Long cinemaId) {
        List<ShowTimeDTO> timeList = processService.getTimeList(filmId, cinemaId);
        return ResponseEntity.ok(CommonResult.success(timeList));
    }

    @Operation(summary = "添加购票场次信息")
    @RequestMapping(value = "/addTime", method = RequestMethod.POST)
    public ResponseEntity<?> addProcess(@RequestBody TimeVO timeVO) {
        return ResponseEntity.ok(timeVO);
    }
}
