package com.feature.email.controller.email;

import com.feature.email.service.user.EmailService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Log4j2
@SuppressWarnings("all")
@Api(description = "邮寄相关")
public class EmailController {


    @Autowired
    private EmailService emailService;

}
