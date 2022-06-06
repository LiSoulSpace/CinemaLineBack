package xyz.soulspace.cinemaline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.soulspace.cinemaline.dto.ShowTimeDTO;
import xyz.soulspace.cinemaline.entity.Process;
import xyz.soulspace.cinemaline.mapper.ProcessMapper;
import xyz.soulspace.cinemaline.service.ProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
@Service
public class ProcessServiceImp extends ServiceImpl<ProcessMapper, Process> implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<ShowTimeDTO> getTimeList(Long filmId, Long cinemaId) {
        try {
            return processMapper.selectTimeByCinemaIdAndFilmId(filmId, cinemaId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
