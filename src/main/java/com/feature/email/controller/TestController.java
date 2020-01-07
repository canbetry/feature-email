package com.feature.email.controller;

import com.feature.email.common.response.ResponseEntity;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: TestController <br>
 * @date: 2020/1/7 11:02 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@RestController
@Log4j2
@Api(description = "测试接口")
public class TestController {


    /**
     * 测试接口
     * @return
     */
    @RequestMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.SUCCEED;
    }
}
