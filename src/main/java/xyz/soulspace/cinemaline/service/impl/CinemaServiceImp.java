package xyz.soulspace.cinemaline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.soulspace.cinemaline.dto.CinemaAllDTO;
import xyz.soulspace.cinemaline.dto.CinemaSimpleDTO;
import xyz.soulspace.cinemaline.entity.Cinema;
import xyz.soulspace.cinemaline.mapper.CinemaMapper;
import xyz.soulspace.cinemaline.service.CinemaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    CinemaMapper cinemaMapper;

    @Override
    public List<CinemaSimpleDTO> getCinemaSimpleList(String city, Long filmId) {
        try {

            return cinemaMapper.selectAllByCityNameAndFilmId(city, filmId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public CinemaAllDTO getCinemaInfoById(Long id) {
        try {
            List<CinemaAllDTO> cinemaAllDTOS = cinemaMapper.selectCinemaAllDTOById(id);
            if (cinemaAllDTOS.size() == 1) {
                return cinemaAllDTOS.get(0);
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return null;

    }
}
