package com.feature.email.entity.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户信息表")
public class User {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户登录昵称，用户凭此登录")
    private String userName;
    @ApiModelProperty("用户登陆密码，用户凭此登录")
    private String userPassword;
    @ApiModelProperty(value = "用户独有盐值", required = false)
    private String salt;
    @ApiModelProperty("用户邮箱，用户通过此邮箱找回密码，更新密码")
    private String userEmail;
    @ApiModelProperty("用户类型:1.管理员，2:普通用户")
    private String userType;
    @ApiModelProperty("客户真实姓名，用来接收邮件")
    private String custName;
    @ApiModelProperty("逻辑删除标志:0.正常，1.删除")
    private String isDeleted;
}
