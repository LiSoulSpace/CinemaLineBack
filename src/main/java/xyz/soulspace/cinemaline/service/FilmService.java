package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.dto.FilmAllDTO;
import xyz.soulspace.cinemaline.dto.FilmSimpleDTO;
import xyz.soulspace.cinemaline.entity.Film;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 电影表 服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:34:09
 */
public interface FilmService extends IService<Film> {
    Film getFilmById(Long id);

    FilmAllDTO getFilmAllById(Long id);

    List<FilmSimpleDTO> getAll();
}
