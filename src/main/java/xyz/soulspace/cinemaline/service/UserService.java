package xyz.soulspace.cinemaline.service;

import org.springframework.security.core.userdetails.UserDetails;
import xyz.soulspace.cinemaline.dto.UserBasicDTO;
import xyz.soulspace.cinemaline.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
public interface UserService extends IService<User> {
    boolean isExistUser(Long userId);

    Map<String, String> login(String username, String password);

    String register(String username, String password);

    String logout(String username);

    UserBasicDTO getUserBasicDTOByUsername(String username);

    UserDetails loadUserByUsername(String username);

    UserBasicDTO whoAmI(String token);
}
