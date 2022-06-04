package xyz.soulspace.cinemaline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.soulspace.cinemaline.dto.UserBasicDTO;
import xyz.soulspace.cinemaline.entity.User;
import xyz.soulspace.cinemaline.exception.Asserts;
import xyz.soulspace.cinemaline.mapper.UserMapper;
import xyz.soulspace.cinemaline.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.soulspace.cinemaline.util.JwtTokenUtil;

import java.util.List;

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
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean isExistUser(Long userId) {
        int count = userMapper.countById(userId);
        return count > 0;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            //insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String register(String username, String password) {
        return null;
    }

    @Override
    public String logout(String username) {
        return null;
    }

    @Override
    public UserBasicDTO getUserBasicDTOByUsername(String username) {
        return userMapper.selectIdAndNicknameAndAvatarMd5ByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<User> users = userMapper.selectAllByUsername(username);
        if (users.size()>0){
            return null;
        }return null;
    }

}
