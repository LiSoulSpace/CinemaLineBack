package xyz.soulspace.cinemaline.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import xyz.soulspace.cinemaline.dto.UserBasicDTO;
import xyz.soulspace.cinemaline.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    UserBasicDTO selectIdAndNicknameAndAvatarUrlByUsername(@Param("username") String username);

    int countById(@Param("id") Long id);

    List<User> selectAllByUsername(@Param("username") String username);
}
