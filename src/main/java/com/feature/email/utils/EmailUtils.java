package com.feature.email.utils;

import com.feature.email.common.Enum.Constant;
import com.feature.email.common.Exception.DIYException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@Log4j2
public class EmailUtils {
    //配置信息
    private static final String MAIL_HOST_VALUE_163 = "smtp.163.com"; //发送邮件的服务器地址
    private static final String MAIL_HOST_VALUE_qq = "smtp.qq.com"; //发送邮件的服务器地址

    private static final String DEFAULT_EMAIL_SEND = "feature_email@163.com";
    private static final String AUTHORIZATION_CODE = "5tgb6yhn";

    /**
     * 发送邮件验证码
     *
     * @param emailAddress 收件人邮箱
     * @param verifyCode   验证码
     */
    public static void sendEmail(String emailAddress, String verifyCode, String emailTitle) {
        HtmlEmail email = new HtmlEmail();
        try {
            //判断邮箱类型目前支持163和qq邮箱
            String mailHost = null;
            switch (emailAddress.substring(emailAddress.length() - 7, emailAddress.length() - 4)) {
                case "163":
                    mailHost = MAIL_HOST_VALUE_163;
                    emailAddress.substring(emailAddress.length() - 7);
                    // 这里是SMTP发送服务器的名字：，普通qq号只能是smtp.qq.com ；
                    email.setHostName(MAIL_HOST_VALUE_163);
                    break;
                case "@qq":
                    mailHost = MAIL_HOST_VALUE_qq;
                    emailAddress.substring(emailAddress.length() - 6);
                    // 这里是SMTP发送服务器的名字：，普通qq号只能是smtp.qq.com ；
                    email.setHostName(MAIL_HOST_VALUE_qq);
                    break;
            }
            //设置需要鉴权端口
            email.setSmtpPort(465);
            //开启 SSL 加密
            email.setSSLOnConnect(true);
            // 字符编码集的设置
            email.setCharset(Constant.CODING_TYPE_UTF8);
            // 收件人的邮箱
            email.addTo(emailAddress);
            // 发送人的邮箱
            email.setFrom(DEFAULT_EMAIL_SEND);
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和得到的授权码
            email.setAuthentication(DEFAULT_EMAIL_SEND, AUTHORIZATION_CODE);
            email.setSubject(emailTitle);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg("欢迎注册，您的验证码为：" + verifyCode + "\n" + DEFAULT_EMAIL_SEND);
            // 发送
            email.send();
            log.info("邮件发送成功!");
        } catch (EmailException e) {
            log.error("邮件发送失败!", e);
            throw new DIYException("邮件发送失败", e);
        }
    }


}
