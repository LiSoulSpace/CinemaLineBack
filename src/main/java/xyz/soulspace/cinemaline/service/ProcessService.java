package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.dto.ShowTimeDTO;
import xyz.soulspace.cinemaline.entity.Process;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
public interface ProcessService extends IService<Process> {
    List<ShowTimeDTO> getTimeList(Long filmId, Long cinemaId);
}
