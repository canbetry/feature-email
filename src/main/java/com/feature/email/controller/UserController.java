package com.feature.email.controller;

import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.entityVo.UserVo;
import com.feature.email.service.UserService;
import com.feature.email.utils.CommonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@Api("用户相关接口")
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("注册用户接口")
    @RequestMapping("/register")
    public ResponseEntity<UserVo> saveUser(@RequestBody UserVo userVo) {
        CommonBeanUtils.convertEmptyStringToNull(userVo);
        return userService.saveUser(userVo);
    }
}
