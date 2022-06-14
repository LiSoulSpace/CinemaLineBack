package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.dto.ShowTimeDTO;
import xyz.soulspace.cinemaline.entity.Process;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
@Mapper
public interface ProcessMapper extends BaseMapper<Process> {
    List<Process> selectAllByCinemaIdAndFilmId(@Param("cinemaId") Long cinemaId, @Param("filmId") Long filmId);

    List<ShowTimeDTO> selectTimeByCinemaIdAndFilmId(@Param("filmId") Long filmId, @Param("cinemaId") Long cinemaId);
}
