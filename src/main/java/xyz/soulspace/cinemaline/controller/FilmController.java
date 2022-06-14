package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.FilmAllDTO;
import xyz.soulspace.cinemaline.dto.FilmSimpleDTO;
import xyz.soulspace.cinemaline.entity.Film;
import xyz.soulspace.cinemaline.service.FilmService;

import java.util.List;

/**
 * <p>
 * 电影表 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Controller
@RequestMapping("/film")
@Tag(name = "电影控制器(FilmController)")
@CrossOrigin
public class FilmController {

    @Autowired
    FilmService filmService;

    @Operation(summary = "根据id返回电影全部信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFilmAllInfoById(@PathVariable String id) {
        FilmAllDTO filmAllById = filmService.getFilmAllById(Long.valueOf(id));
        return ResponseEntity.ok(CommonResult.success(filmAllById));
    }

    @Operation(summary = "获取电影信息")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseEntity<?> getFilmList(@RequestParam(required = false) String sort,
                                         @RequestParam(required = false) String tag,
                                         @RequestParam(required = false) String area,
                                         @RequestParam(required = false) String yeats) {
        List<FilmSimpleDTO> all = filmService.getAll();
        return ResponseEntity.ok(CommonResult.success(all));
    }
}
