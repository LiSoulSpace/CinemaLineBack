package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.City;
import xyz.soulspace.cinemaline.mapper.CityMapper;
import xyz.soulspace.cinemaline.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:03
 */
@Service
public class CityServiceImp extends ServiceImpl<CityMapper, City> implements CityService {

}
