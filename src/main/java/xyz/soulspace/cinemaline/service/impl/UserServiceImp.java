package xyz.soulspace.cinemaline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.soulspace.cinemaline.entity.User;
import xyz.soulspace.cinemaline.mapper.UserMapper;
import xyz.soulspace.cinemaline.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Slf4j
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isExistUser(Long userId) {
        int count = userMapper.countById(userId);
        return count > 0;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        return null;
    }

    @Override
    public String register(String username, String password) {
        return null;
    }

    @Override
    public String logout(String username) {
        return null;
    }
}
