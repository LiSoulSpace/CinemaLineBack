package xyz.soulspace.cinemaline.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import xyz.soulspace.cinemaline.api.CommonResult;
import xyz.soulspace.cinemaline.dto.UserBasicDTO;
import xyz.soulspace.cinemaline.dto.UserRequestBody;
import xyz.soulspace.cinemaline.kafka.producer.OrderProducer;
import xyz.soulspace.cinemaline.service.UserService;
import xyz.soulspace.cinemaline.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${Cros.set-domain}")
    private String domain;
    @Autowired
    UserService userService;

    @Operation(summary = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserRequestBody user,
                                   HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = userService.login(user.getUsername(), user.getPassword());
        if (map.get("token") == null) {
            String msg = map.get("msg");
            return ResponseEntity.ok(CommonResult.failed(1, msg, null));
        }
        CookieUtil.setCookie(request, response, "token", map.get("token"), 24 * 60 * 60);
        CookieUtil.setCookie(request, response, "tokenHead", tokenHead);
        response.setHeader("token", map.get("token"));
        response.setHeader("tokenHead", tokenHead);
        response.setHeader("tokenHeader", tokenHeader);
        return ResponseEntity.ok(CommonResult.success(map));
    }

    @Operation(summary = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.setCookie(request, response, "token", "", 24 * 60 * 60);
        CookieUtil.setCookie(request, response, "tokenHead", "");
        return ResponseEntity.ok(CommonResult.success(null));
    }

    @Operation(summary = "whoami")
    @RequestMapping(value = "/whoami", method = RequestMethod.GET)
    public ResponseEntity<?> whoAmI(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        UserBasicDTO userBasicDTO = userService.whoAmI(token);
        return ResponseEntity.ok(CommonResult.success(userBasicDTO));
    }

    @Operation(summary = "获取个人信息")
    @RequestMapping(value = "/sig", method = RequestMethod.GET)
    public ResponseEntity<?> onesInfo(@RequestParam Long userId) {
        return ResponseEntity.ok(userId);
    }

}
