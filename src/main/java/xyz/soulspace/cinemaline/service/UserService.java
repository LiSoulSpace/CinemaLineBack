package xyz.soulspace.cinemaline.service;

import xyz.soulspace.cinemaline.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

    String login(String username, String password);

    String register(String username, String password);

    String logout(String username);
}
