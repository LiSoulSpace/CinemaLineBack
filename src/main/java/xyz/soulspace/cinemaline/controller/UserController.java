package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.service.UserService;
import xyz.soulspace.cinemaline.util.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author soulspace
 * @since 2022-06-02 10:03:04
 */
@Controller
@RequestMapping("/user")
@CrossOrigin
@Tag(name = "用户控制器(UserController)")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@Param("username") String username, @Param("password") String password,
                                   HttpServletRequest request, HttpServletResponse response) {
        String token = userService.login(username, password);
        if (token == null) {
            return ResponseEntity.ok(CommonResult.failed(1, "用户名或密码错误", null));
        }
        CookieUtil.setCookie(request, response, "token", token, 24*60*60);

        return ResponseEntity.ok("");
    }

}
