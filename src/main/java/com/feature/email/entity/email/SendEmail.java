package com.feature.email.entity.email;


import com.feature.email.common.commonEntity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * @description: SendEmail <br>
 * @date: 2020/1/7 11:09 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@ApiModel("寄件表,已经寄出去的邮件表")
@Data
public class SendEmail extends CommonEntity {
    @ApiModelProperty("寄件用户id")
    private Long sendUserId;
    @ApiModelProperty("寄件人(真实姓名)")
    private String sendUserRealName;
    @ApiModelProperty("寄件人邮箱,邮件寄件时会发一封邮件通知寄件人")
    private String sendUserRealEmail;
    @ApiModelProperty("收件人(真实姓名)")
    private String reciveUserRealName;
    @ApiModelProperty("收件人真实地址")
    private String reciveUserRealAddr;
    @ApiModelProperty("收件人邮箱,邮件寄件时会发一封邮件通知收件人")
    private String reciveUserRealEmail;
    @ApiModelProperty("发邮件时间")
    private Date sendEmailTime;
    @ApiModelProperty("收邮件时间")
    private String reviceEmailTime;
    @ApiModelProperty("发送邮件对应总邮件表id")
    private String totalEmailId;
    @ApiModelProperty("邮件状态:未收货、已收货")
    private String emailStatus;
}
