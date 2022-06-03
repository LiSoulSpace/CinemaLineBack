package xyz.soulspace.cinemaline.mapper;

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

}
