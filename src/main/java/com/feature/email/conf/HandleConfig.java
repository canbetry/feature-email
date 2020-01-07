package com.feature.email.conf;

import com.feature.email.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: HandleConfig <br>
 * @date: 2020/1/7 11:09 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Configuration
public class HandleConfig extends WebMvcConfigurationSupport {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }

}
