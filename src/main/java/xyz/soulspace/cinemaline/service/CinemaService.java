package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.dto.CinemaAllDTO;
import xyz.soulspace.cinemaline.dto.CinemaSimpleDTO;
import xyz.soulspace.cinemaline.entity.Cinema;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 影院表 服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:02:14
 */
public interface CinemaService extends IService<Cinema> {
    List<CinemaSimpleDTO> getCinemaSimpleList(String city, Long filmId);

    CinemaAllDTO getCinemaInfoById(Long id);
}
