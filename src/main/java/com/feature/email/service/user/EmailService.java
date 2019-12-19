package com.feature.email.service.user;


import com.feature.email.common.Enum.EmailEnum;
import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.dao.email.SendEmailMapper;
import com.feature.email.dao.email.TotalEmailMapper;
import com.feature.email.entity.email.TotalEmail;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("all")
@Log4j2
@Service("emailService")
public class EmailService {

    @Autowired
    private TotalEmailMapper totalEmailMapper;

    @Autowired
    private SendEmailMapper sendEmailMapper;


    /**
     * 写邮件
     *
     * @param totalEmail
     * @return
     */
    public ResponseEntity<TotalEmail> writeEmail(TotalEmail totalEmail) {
        if (!emailFieldCheck(totalEmail)) {
            return ResponseEntity.errorInfo(EmailEnum.$saveEmailFail);
        }
        TotalEmail email = new TotalEmail();
        BeanUtils.copyProperties(totalEmail, email);
        Integer integer = totalEmailMapper.saveTotalEmail(email);
        if (1 != integer) {
            return ResponseEntity.errorInfo(EmailEnum.$saveEmailFail);
        }
        return ResponseEntity.responseBySucceed(totalEmail);
    }


    private boolean emailFieldCheck(TotalEmail totalEmail) {
        if (null != totalEmail.getUserId() && StringUtils.isNotBlank(totalEmail.getEmailTitle()) &&
                StringUtils.isNotBlank(totalEmail.getEmailContent()) && StringUtils.isNotBlank(totalEmail.getSendUserRealName()) &&
                StringUtils.isNotBlank(totalEmail.getSendUserRealEmail()) && StringUtils.isNotBlank(totalEmail.getReciveUserRealEmail())
                && StringUtils.isNotBlank(totalEmail.getReciveUserRealName())) {
            return true;
        } else {
            return false;
        }
    }
}
