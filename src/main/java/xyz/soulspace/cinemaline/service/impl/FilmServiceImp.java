package xyz.soulspace.cinemaline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.soulspace.cinemaline.entity.Film;
import xyz.soulspace.cinemaline.mapper.FilmMapper;
import xyz.soulspace.cinemaline.service.FilmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电影表 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 03:34:09
 */
@Service
public class FilmServiceImp extends ServiceImpl<FilmMapper, Film> implements FilmService {

    @Autowired
    FilmMapper filmMapper;

    @Override
    public Film getFilmById(Long id) {
        return filmMapper.selectById(id);
    }
}
