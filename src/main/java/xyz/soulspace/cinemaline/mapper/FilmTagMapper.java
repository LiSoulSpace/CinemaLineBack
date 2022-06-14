package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.entity.FilmTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:43:16
 */
@Mapper
public interface FilmTagMapper extends BaseMapper<FilmTag> {
    List<FilmTag> selectTagById(@Param("id") Long id);
}
