package com.feature.email.service.user;


import com.feature.email.common.Enum.EmailEnum;
import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.dao.email.SendEmailMapper;
import com.feature.email.dao.email.TotalEmailMapper;
import com.feature.email.entity.email.SendEmail;
import com.feature.email.entity.email.TotalEmail;
import com.feature.email.utils.CommonBeanUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    /**
     * 删除邮件
     *
     * @param emailId
     * @return
     */
    public ResponseEntity removeEmail(Long emailId) {
        Integer integer = totalEmailMapper.removeTotalEmail(emailId);
        if (1 != integer) {

        }
        return ResponseEntity.SUCCEED;
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


    /**
     * 查询邮件
     *
     * @param totalEmail
     * @return
     */
    public ResponseEntity<List<TotalEmail>> queryEmailList(TotalEmail totalEmail) {
        CommonBeanUtils.convertEmptyStringToNull(totalEmail);
        //查询邮件列表
        List<TotalEmail> totalEmails = totalEmailMapper.queryTotalEmailList(totalEmail);
        return ResponseEntity.responseBySucceed(totalEmails);
    }


    /**
     * 查询发送邮件
     *
     * @param sendEmail
     * @return
     */
    public ResponseEntity<List<SendEmail>> querySendEmailList(SendEmail sendEmail) {
        //TODO 查询已发送邮件列表

        return ResponseEntity.SUCCEED;
    }

    /**
     * //TODO 发送邮件,修改邮件状态并新增发送邮件到已发送邮件表
     * @return
     */
    public ResponseEntity sendEmail(){

        return ResponseEntity.responseBySucceed();
    }
}
