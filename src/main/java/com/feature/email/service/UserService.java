package com.feature.email.service;

import com.feature.email.common.Enum.Constant;
import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.dao.UserMapper;
import com.feature.email.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
@Log4j2
@SuppressWarnings("all")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public ResponseEntity<User> saveUser(User user) {
        Integer integer = userMapper.saveUser(user);
        if (integer == 1) {
            return ResponseEntity.responseBySucceedContent(Constant.SUCCESS_MESSAGE, user);
        } else {
            return ResponseEntity.responseByErrorMessage(Constant.ERROR_MESSAGE);
        }
    }
}
