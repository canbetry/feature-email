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
    @ApiModelProperty("用户类型:1.管理员，2:普通用户")
    private String userType;
}
