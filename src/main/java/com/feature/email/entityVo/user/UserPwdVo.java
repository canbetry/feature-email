package com.feature.email.entityVo.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: UserPwdVo <br>
 * @date: 2020/1/7 10:58 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Data
@ApiModel("用户密码实体")
public class UserPwdVo implements Serializable {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 旧密码
     */
    private String oldPwd;
    /**
     * 新密码
     */
    private String newPwd;

}
