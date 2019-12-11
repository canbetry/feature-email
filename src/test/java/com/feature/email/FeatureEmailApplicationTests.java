package com.feature.email;

import com.feature.email.common.Exception.DIYException;
import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.conf.RedisUtils;
import com.feature.email.dao.user.UserMapper;
import com.feature.email.entity.user.User;
import com.feature.email.entityVo.user.UserPwdVo;
import com.feature.email.entityVo.user.UserVo;
import com.feature.email.service.user.UserService;
import com.feature.email.utils.Base64Utils;
import com.feature.email.utils.CommonBeanUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@Log4j2
@SuppressWarnings("all")
class FeatureEmailApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

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

    @Test
    public void saveUser() {
        UserVo userVo = new UserVo();
        userVo.setUserName("admin");
        try {
            userVo.setUserPassword(Base64Utils.encodeStr("admin"));
        } catch (UnsupportedEncodingException e) {
            log.error("加密密码失败", e);
            throw new DIYException("注册失败", e);
        }
        try {
            userVo.setUserEmail(Base64Utils.encodeStr("canbetry@163.com"));
        } catch (UnsupportedEncodingException e) {
            log.error("加密邮箱失败", e);
        }
        userVo.setUserType("1");
        ResponseEntity<UserVo> userVoResponseEntity = userService.saveUser(userVo);
        if (userVoResponseEntity.isNotSuccess()) {
            log.error("注册失败");
        } else {
            log.info("注册成功");
        }
    }

    @Test
    public void updateUserTest() {
        UserVo userVo = new UserVo();
        userVo.setUserName("admin");
        userVo.setId(5L);
        try {
            userVo.setUserEmail(Base64Utils.encodeStr("canbetry@163.com"));
        } catch (UnsupportedEncodingException e) {
            log.error("加密失败");
        }
        ResponseEntity responseEntity = userService.updateUser(userVo);
        if (responseEntity.isNotSuccess()) {
            log.error("更新失败");
        } else {
            log.info("更新成功");
        }
    }

    @Test
    public void testResponseEntity() {
        ResponseEntity<UserVo> userVoResponseEntity = userService.saveUser(new UserVo());
        System.out.println(userVoResponseEntity.isNotSuccess());
        System.out.println(userVoResponseEntity.isSuccess());
    }

    @Test
    public void updatePwd() {
        UserPwdVo userPwdVo = new UserPwdVo();
        userPwdVo.setId(6L);
        try {
            userPwdVo.setOldPwd(Base64Utils.encodeStr("admin123"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("1212121221");
            throw new DIYException("12222222");
        }
        try {
            userPwdVo.setNewPwd(Base64Utils.encodeStr("admin"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("--------------------");
            throw new DIYException("---------------------");
        }
        ResponseEntity responseEntity = userService.updatePwd(userPwdVo);
        if (responseEntity.isNotSuccess()) {
            throw new DIYException("==========失败============");
        }
        System.out.println("++++++++++成功+++++++++++++");
    }

    @Autowired
    private RedisUtils redisUtils;

    @Value("${spring-redis-session-name-pre}")
    private String redisPre;

    @Test
    public void sessionTest() {
        redisUtils.set(redisPre + "test", "admin");
        System.out.println(redisUtils.get(redisPre + "test"));
    }
}
