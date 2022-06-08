package xyz.soulspace.cinemaline.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.dto.SeatDTO;
import xyz.soulspace.cinemaline.entity.SeatInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-06 10:37:07
 */
@Mapper
public interface SeatInfoMapper extends BaseMapper<SeatInfo> {
    List<SeatInfo> selectSeatArrangementByProcessId(@Param("processId") Long processId);

    List<String> selectSeatDTOByFSCID(@Param("filmId") Long filmId,
                                       @Param("cinemaId") Long cinemaId,
                                       @Param("showId") Long showId);

    String getTicketsByInfo(@Param("userId") Long userId,
                  @Param("fileId") Long fileId,
                  @Param("cinemaId") Long cinemaId,
                  @Param("showId") Long showId,
                  @Param("col") int col,
                  @Param("row") int row);

    int setSeatArrangementByProcessId(@Param("seatArrangement") String seatArrangement, @Param("processId") Long processId);
}
