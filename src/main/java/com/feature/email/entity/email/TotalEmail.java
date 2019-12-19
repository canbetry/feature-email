package com.feature.email.entity.email;

import com.feature.email.common.commonEntity.CommonEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Data
@ApiModel("邮件总表")
public class TotalEmail extends CommonEntity implements Serializable {
    private Long userId;                //写邮件的用户的id
    private String emailTitle;          //邮件主题
    private String emailContent;        //邮件具体内容
    private String sendUserRealName;    //寄件人(真实姓名)
    private String sendUserRealEmail;   //寄件人邮箱,邮件寄件时会发一封邮件通知寄件人
    private String reciveUserRealName;  //收件人(真实姓名)
    private String reciveUserRealAddr = "寄件人选择网络邮箱收件";  //收件人真实地址,如果未填写地址那么默认为'寄件人选择网络邮箱收件'
    private String reciveUserRealEmail; //收件人邮箱,邮件寄件时会发一封邮件通知收件人
    private String isVisible = "否";
    private Date createEmailTime;       //邮件创建时间
    private String updateEmailTime;    //邮件更新时间
    private String isSend = "未发送";              //邮件是否发送：未发送、已发送,默认未发送

    public TotalEmail() {
        this.createEmailTime = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
    }
}
