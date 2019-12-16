package com.feature.email.controller;

import com.feature.email.common.Response.ResponseEntity;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@Api(description = "测试接口")
public class TestController {


    @RequestMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.SUCCEED;
    }
}
