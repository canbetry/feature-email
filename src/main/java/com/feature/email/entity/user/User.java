package com.feature.email.entity.user;

import com.feature.email.common.commonEntity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * @description: User <br>
 * @date: 2020/1/7 11:08 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Data
@ApiModel("用户信息表")
public class User extends CommonEntity {
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
    @ApiModelProperty("用户创建时间")
    private Date createTime;
    @ApiModelProperty("用户更新时间")
    private String updateTime;
}
