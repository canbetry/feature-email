package com.feature.email;

import com.feature.email.utils.CommonBeanUtils;
import com.feature.email.utils.EmailUtils;

public class TestZZ {

    public static void main(String[] args) {
        String verifyCode = CommonBeanUtils.generateVerifyCodeDefaultLength();
        EmailUtils.sendEmail("canbetry@163.com", verifyCode, "邮件主题");
        System.out.println("2112");
    }
}
