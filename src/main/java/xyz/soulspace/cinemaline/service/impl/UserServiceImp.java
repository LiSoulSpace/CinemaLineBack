package xyz.soulspace.cinemaline.service.impl;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.soulspace.cinemaline.component.security.AppUserDetails;
import xyz.soulspace.cinemaline.dto.UserBasicDTO;
import xyz.soulspace.cinemaline.entity.Permission;
import xyz.soulspace.cinemaline.entity.User;
import xyz.soulspace.cinemaline.exception.Asserts;
import xyz.soulspace.cinemaline.mapper.UserMapper;
import xyz.soulspace.cinemaline.mapper.UserRoleRelationMapper;
import xyz.soulspace.cinemaline.service.UserCacheService;
import xyz.soulspace.cinemaline.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.soulspace.cinemaline.util.JwtTokenUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    UserCacheService userCacheService;
    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;

    @Override
    public boolean isExistUser(Long userId) {
        int count = userMapper.countById(userId);
        return count > 0;
    }

    public List<Permission> getPermissionList(Long userId) {
        List<Permission> resourceList = userCacheService.getPermissionList(userId);
        if (CollUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }
        resourceList = userRoleRelationMapper.selectPermissionsByUserId(userId);
        if (CollUtil.isNotEmpty(resourceList)) {
            userCacheService.setPermissionList(userId, resourceList);
        }
        return resourceList;
    }

    @Override
    public Map<String, String> login(String username, String password) {
        String token = null;
        try {
            Map<String, String> resultMap = new HashMap<>();
            UserDetails userDetails = loadUserByUsername(username);
            log.warn("password {} , userDetailsPassword {}", password, userDetails.getPassword());
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            UserBasicDTO userBasicDTOByUsername = getUserBasicDTOByUsername(username);
            resultMap.put("userId", String.valueOf(userBasicDTOByUsername.getUserId()));
            resultMap.put("nickName", userBasicDTOByUsername.getNickName());
            resultMap.put("avatar", userBasicDTOByUsername.getAvatar());
            resultMap.put("token", token);
            return resultMap;
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return new HashMap<>() {{
            put("token", null);
        }};
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
        return userMapper.selectIdAndNicknameAndAvatarUrlByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<User> users = userMapper.selectAllByUsername(username);
        log.warn(users.toString());
        if (users.size() > 0) {
            List<Permission> permissionList = getPermissionList(users.get(0).getId());
            log.warn(String.valueOf(users.get(0)));
            return new AppUserDetails(users.get(0), permissionList);
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }

    @Override
    public UserBasicDTO whoAmI(String token) {
        return null;
    }

}
