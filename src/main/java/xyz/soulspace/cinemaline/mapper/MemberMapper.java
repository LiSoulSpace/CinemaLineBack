package xyz.soulspace.cinemaline.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import xyz.soulspace.cinemaline.dto.MemberDTO;
import xyz.soulspace.cinemaline.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
    List<MemberDTO> selectAllById(@Param("id") Long filmId);
}
