package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:03
 */
public interface CityService extends IService<City> {
    Map<String, List<Map<String, String>>>  getAllCityInfo();
}
