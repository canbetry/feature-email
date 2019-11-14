package com.feature.email;

import com.feature.email.dao.UserMapper;
import com.feature.email.entity.User;
import com.feature.email.utils.Base64Utils;
import com.feature.email.utils.CommonBeanUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@Log4j2
@SuppressWarnings("all")
class FeatureEmailApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public static void main(String[] args) {

    }

    @Test
    public void userTest() {
        User user = new User();
        try {
            user.setCustName(Base64Utils.encodeStr("luoyunlong"));
            user.setUserEmail(Base64Utils.encodeStr("canbetry@163.com"));
            user.setUserPassword(Base64Utils.encodeStr("admin123!@#"));
        } catch (UnsupportedEncodingException e) {
            log.error("编码失败", e);
        }
        user.setUserName("Admin");
        user.setUserType("1");
        Integer integer = userMapper.saveUser(user);
        System.out.println(user.toString());
    }


    @Test
    public void utilsTest(){
        User user = new User();
        user.setUserName("");
        CommonBeanUtils.convertEmptyStringToNull(user);
        System.out.println(user.toString());
    }
}
