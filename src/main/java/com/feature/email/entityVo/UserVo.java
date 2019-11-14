package com.feature.email.entityVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户聚合信息表")
public class UserVo implements Serializable {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户登录昵称，用户凭此登录")
    private String userName;
    @ApiModelProperty("用户登陆密码，用户凭此登录")
    private String userPassword;
    @ApiModelProperty("用户类型:1.管理员，2:普通用户")
    private String userType;
    @ApiModelProperty("用户邮箱，用户通过此邮箱找回密码，更新密码")
    private String userEmail;
    @ApiModelProperty(value = "客户真实姓名，用来接收邮件", required = false)
    private String custName;
}
