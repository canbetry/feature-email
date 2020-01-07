package com.feature.email.entityVo.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * @description: TotalEmailVo <br>
 * @date: 2020/1/7 11:02 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Data
@ApiModel("邮件总表对象实体")
public class TotalEmailVo {
    @ApiModelProperty("自增序列id")
    private Long id;
    @ApiModelProperty("写邮件的用户的id")
    private Long userId;
    @ApiModelProperty("邮件主题")
    private String emailTitle;
    @ApiModelProperty("邮件具体内容")
    private String emailContent;
    @ApiModelProperty("寄件人(真实姓名)")
    private String sendUserRealName;
    @ApiModelProperty("寄件人邮箱,邮件寄件时会发一封邮件通知寄件人")
    private String sendUserRealEmail;
    @ApiModelProperty("收件人(真实姓名)")
    private String reciveUserRealName;
    @ApiModelProperty("收件人真实地址,如果未填写地址那么默认为'寄件人选择网络邮箱收件'")
    private String reciveUserRealAddr;
    @ApiModelProperty("收件人邮箱,邮件寄件时会发一封邮件通知收件人")
    private String reciveUserRealEmail;
    @ApiModelProperty("邮件创建时间")
    private Date createEmailTime;
    @ApiModelProperty("邮件更新时间")
    private String updateEmailTime;
    @ApiModelProperty("邮件是否发送：未发送、已发送,默认未发送")
    private String isSend;
}
