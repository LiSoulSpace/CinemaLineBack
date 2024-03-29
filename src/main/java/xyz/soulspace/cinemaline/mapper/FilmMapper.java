package xyz.soulspace.cinemaline.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.dto.FilmAllDTO;
import xyz.soulspace.cinemaline.dto.FilmSimpleDTO;
import xyz.soulspace.cinemaline.dto.FilmTempDTO;
import xyz.soulspace.cinemaline.entity.Film;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 电影表 Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:34:09
 */
@Mapper
public interface FilmMapper extends BaseMapper<Film> {
    List<Film> selectIdByFilmName(@Param("filmName") String filmName);

    List<Film> selectAllById(@Param("id") Long id);

    FilmTempDTO selectFAllById(@Param("id") Long id);

    List<FilmSimpleDTO> selectFList(@Param("sort") String sort,
                                    @Param("tag") String tag,
                                    @Param("area") String area,
                                    @Param("years") String years);

    List<FilmSimpleDTO> selectAll();
}
