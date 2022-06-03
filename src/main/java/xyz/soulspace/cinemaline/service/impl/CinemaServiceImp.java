package xyz.soulspace.cinemaline.service.impl;

import xyz.soulspace.cinemaline.entity.Cinema;
import xyz.soulspace.cinemaline.mapper.CinemaMapper;
import xyz.soulspace.cinemaline.service.CinemaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 影院表 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:02:14
 */
@Service
public class CinemaServiceImp extends ServiceImpl<CinemaMapper, Cinema> implements CinemaService {

}
