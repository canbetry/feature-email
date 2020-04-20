package com.feature.email;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
@MapperScan(basePackages = "com.feature.email.dao")
@EnableScheduling   //开启定时任务
//@EnableCaching  //开启缓存
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 900)
public class FeatureEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureEmailApplication.class, args);
    }

}
