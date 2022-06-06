package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:03
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {
    List<City> selectIdByCityName(@Param("cityName") String cityName);

    List<City> selectCityNameAndIdByInitialChar(@Param("initialChar") String initialChar);
}
