package com.feature.email.controller.email;

import com.feature.email.common.response.ResponseEntity;
import com.feature.email.entity.email.SendEmail;
import com.feature.email.entity.email.TotalEmail;
import com.feature.email.service.user.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: EmailController <br>
 * @date: 2020/1/7 10:46 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@RestController
@RequestMapping("/email")
@Log4j2
@SuppressWarnings("all")
@Api(description = "邮寄相关")
public class EmailController {


    @Autowired
    private EmailService emailService;


    /**
     * 邮件总列表
     *
     * @param totalEmail {@link TotalEmail}
     * @return
     */
    @PostMapping("/totalPage")
    @ApiOperation("邮件列表")
    public ResponseEntity totalEmailList(@RequestBody TotalEmail totalEmail) {
        return emailService.queryEmailList(totalEmail);
    }


    /**
     * 已发送邮件列表
     *
     * @param sendEmail {@link SendEmail}
     * @return
     */
    @PostMapping("/sendPage")
    @ApiOperation("已发送邮件列表")
    public ResponseEntity sendEmailList(@RequestBody SendEmail sendEmail) {
        return emailService.querySendEmailList(sendEmail);
    }

}
