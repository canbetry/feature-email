package com.feature.email;

import com.feature.email.dao.UserMapper;
import com.feature.email.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
@SuppressWarnings("all")
class FeatureEmailApplicationTests {

    @Autowired
    private UserMapper userMapper;

   @Test
    public void userTest(){
       User user = new User();
       user.setCustName("luoyunlong");
       user.setUserEmail("canbetry@163.com");
       user.setUserName("Admin");
       user.setUserPassword("admin123");
       user.setUserType("1");
       Integer integer = userMapper.saveUser(user);
       log.info(user.toString());
   }

}
