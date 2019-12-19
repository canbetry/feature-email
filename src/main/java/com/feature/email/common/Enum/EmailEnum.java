package com.feature.email.common.Enum;

import com.feature.email.common.inteface.BaseBussinessStatus;

public enum EmailEnum implements BaseBussinessStatus {
    $saveEmailFail(10001, "保存邮件失败"),
    ;

    private int code;
    private String message;

    EmailEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
