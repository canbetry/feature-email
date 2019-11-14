package com.feature.email.service;

import com.feature.email.common.Enum.BaseErrorMsg;
import com.feature.email.common.Enum.Constant;
import com.feature.email.common.Enum.UserEnum;
import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.dao.UserMapper;
import com.feature.email.entity.User;
import com.feature.email.entityVo.UserVo;
import com.feature.email.utils.Base64Utils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service("userService")
@Log4j2
@SuppressWarnings("all")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public ResponseEntity<UserVo> saveUser(UserVo userVo) {
        if (StringUtils.isBlank(userVo.getUserName()) || StringUtils.isBlank(userVo.getUserPassword())
                || StringUtils.isBlank(userVo.getUserEmail()) || StringUtils.isBlank(userVo.getUserType())) {
            return ResponseEntity.errorInfo(UserEnum.$userInfoNotComplete);
        }
        //将用户信息加密放入数据库
        String salt = Base64Utils.generateMixRandomCode();
        String pwd = null;
        try {
            pwd = Base64Utils.decodeStr(userVo.getUserPassword());
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.decryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$decryptPwdFail);
        }
        String newPwd = (pwd + salt);
        User user = new User();
        user.setUserName(userVo.getUserName());
        try {
            user.setUserPassword(Base64Utils.encodeStr(newPwd));
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.encryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$saveUserInfoFail);
        }
        user.setUserType(userVo.getUserType());
        user.setSalt(salt);
        user.setUserEmail(userVo.getUserEmail());
        if (StringUtils.isNotBlank(userVo.getCustName())) {
            user.setCustName(userVo.getCustName());
        }
        Integer integer = userMapper.saveUser(user);
        if (integer == 1) {
            return ResponseEntity.responseBySucceedMessage(Constant.SUCCESS_MESSAGE);
        } else {
            return ResponseEntity.responseByErrorMessage(Constant.ERROR_MESSAGE);
        }
    }
}
