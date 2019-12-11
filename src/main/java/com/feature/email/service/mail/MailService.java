package com.feature.email.service.mail;

import com.feature.email.common.Enum.BaseErrorMsg;
import com.feature.email.common.Enum.UserEnum;
import com.feature.email.common.Response.ResponseEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("mailService")
@Log4j2
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;


    /**
     *
     * @param toEmailAddr
     * @param title
     * @param text
     * @param attachments
     * @return
     * @throws MessagingException
     */
    public ResponseEntity sendMail(String toEmailAddr, String title, String text, String... attachments) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //发件人
        helper.setFrom(emailFrom);
        //收件人
        helper.setTo(toEmailAddr);
        //标题
        helper.setSubject(title);
        //文本
        helper.setText(text);
        //附件
        if (attachments != null) {
            if (attachments.length != 2) {
                log.error(BaseErrorMsg.argsLengthError);
                return ResponseEntity.errorInfo(UserEnum.$systemException);
            }
            helper.addAttachment(attachments[0], new File(attachments[1]));
        }
        mailSender.send(mimeMessage);
        return ResponseEntity.SUCCEED;
    }

}
