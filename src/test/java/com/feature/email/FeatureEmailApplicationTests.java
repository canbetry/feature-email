package com.feature.email;

import com.feature.email.dao.user.UserMapper;
import com.feature.email.entity.user.User;
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
        //十进制转二进制
        FeatureEmailApplicationTests featureEmailApplicationTests = new FeatureEmailApplicationTests();
        long convert = featureEmailApplicationTests.convert(10000);
        System.out.println(convert);
    }


    private long convert(long decimal) {
        if (decimal >= 2) {
            return this.convert(decimal / 2) * 10 + decimal % 2;
        } else {
            return decimal;
        }
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
    public void nullTest() {
        User userMsg = userMapper.queryByUserName("luoyunlong");
        System.out.println(org.springframework.util.ObjectUtils.isEmpty(userMsg));
    }

    @Test
    public void utilsTest() {
        User user = new User();
        user.setUserName("");
        CommonBeanUtils.convertEmptyStringToNull(user);
        System.out.println(user.toString());
    }
}
