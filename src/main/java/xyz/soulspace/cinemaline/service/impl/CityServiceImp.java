package xyz.soulspace.cinemaline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.soulspace.cinemaline.entity.City;
import xyz.soulspace.cinemaline.mapper.CityMapper;
import xyz.soulspace.cinemaline.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:03
 */
@Service
public class CityServiceImp extends ServiceImpl<CityMapper, City> implements CityService {
    @Autowired
    CityMapper cityMapper;

    @Override
    public Map<String, List<Map<String, String>>> getAllCityInfo() {
        Map<String, List<Map<String, String>>> map = new ConcurrentHashMap<>();
        for (City city : list()) {
            String initialChar = city.getInitialChar();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", String.valueOf(city.getId()));
            hashMap.put("city", city.getCityName());
            List<Map<String, String>> mapList = map.getOrDefault(initialChar, new LinkedList<>());
            mapList.add(hashMap);
            map.put(initialChar, mapList);
        }
        System.out.println(map);
        return map;
    }
}
