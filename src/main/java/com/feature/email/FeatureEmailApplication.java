package com.feature.email;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@MapperScan(basePackages = "com.feature.email.dao")
@EnableScheduling   //开启定时任务
@EnableCaching  //开启缓存
@EnableRedisHttpSession
public class FeatureEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureEmailApplication.class, args);
    }

}
