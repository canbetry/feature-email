package com.feature.email;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan(basePackages = "com.feature.email.dao")
public class FeatureEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureEmailApplication.class, args);
    }

}
