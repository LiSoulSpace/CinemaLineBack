package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.dto.CinemaAllDTO;
import xyz.soulspace.cinemaline.dto.CinemaSimpleDTO;
import xyz.soulspace.cinemaline.entity.Cinema;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 影院表 Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:02:14
 */
@Mapper
public interface CinemaMapper extends BaseMapper<Cinema> {
    List<Cinema> selectAllByCityId(@Param("cityId") Long cityId);

    List<CinemaSimpleDTO> selectAllByCityNameAndFilmId(@Param("cityName")String cityName,@Param("filmId") Long filmId);

    List<CinemaAllDTO> selectCinemaAllDTOById(@Param("Id")Long id);
}
