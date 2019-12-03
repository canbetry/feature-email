package com.feature.email.controller.user;

import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.controller.BaseController;
import com.feature.email.entityVo.user.UserVo;
import com.feature.email.service.user.UserService;
import com.feature.email.utils.CommonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
@Api(description = "用户相关接口")
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("注册用户接口")
    @PostMapping("/register")
    public ResponseEntity<UserVo> saveUser(@RequestBody UserVo userVo) {
        CommonBeanUtils.convertEmptyStringToNull(userVo);
        return userService.saveUser(userVo);
    }

    @ApiOperation("用户登录接口")
    @GetMapping("/login")
    public ResponseEntity<UserVo> userLogin(String userName, String userPassword, HttpServletRequest request) {
        UserVo userVo = new UserVo();
        userVo.setUserName(userName);
        userVo.setUserPassword(userPassword);
        return userService.userLogin(userVo, request);
    }

    @ApiOperation("用户登出接口")
    @GetMapping("/logout")
    public ResponseEntity userLogout(HttpServletRequest request) {
        return userService.userLogout(request);
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserVo userVo) {
        CommonBeanUtils.convertEmptyStringToNull(userVo);
        return userService.updateUser(userVo);
    }
}
