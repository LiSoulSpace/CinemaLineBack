package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.entity.AreaInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:38:55
 */
@Mapper
public interface AreaInfoMapper extends BaseMapper<AreaInfo> {
    List<AreaInfo> selectIdByArea(@Param("area") String area);

}
