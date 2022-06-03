package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.entity.Film;
import xyz.soulspace.cinemaline.service.FilmService;

/**
 * <p>
 * 电影表 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Controller
@RequestMapping("/cinemaline/film")
@Tag(name = "电影控制器(FilmController)")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Operation(summary = "根据id返回电影全部信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFilmAllInfoById(@PathVariable String id){
        Film filmById = filmService.getFilmById(Long.valueOf(id));
        return ResponseEntity.ok(CommonResult.success(filmById));
    }
}
