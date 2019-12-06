package com.feature.email.entityVo.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户密码实体")
public class UserPwdVo implements Serializable {
    private Long id;
    private String oldPwd;  //旧密码
    private String newPwd;  //新密码

}
