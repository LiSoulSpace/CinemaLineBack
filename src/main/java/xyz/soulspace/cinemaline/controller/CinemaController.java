package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.CinemaAllDTO;
import xyz.soulspace.cinemaline.dto.CinemaSimpleDTO;
import xyz.soulspace.cinemaline.service.CinemaService;

import java.util.List;

/**
 * <p>
 * 影院表 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@CrossOrigin
@Controller
@RequestMapping("/cinema")
@Tag(name = "影院控制器(CinemaController)")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Operation(summary = "获取电影院列表")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseEntity<?> getCinemaList(@RequestParam(required = false) String city,
                                           @RequestParam(required = false) Long id) {
        List<CinemaSimpleDTO> cinemaSimpleList = cinemaService.getCinemaSimpleList(city, id);
        return ResponseEntity.ok(CommonResult.success(cinemaSimpleList));
    }

    @Operation(summary = "根据id获取电影院具体信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCinemaById(@PathVariable(name = "id") Long id) {
        CinemaAllDTO cinemaInfoById = cinemaService.getCinemaInfoById(id);
        return ResponseEntity.ok(CommonResult.success(cinemaInfoById));
    }
}
