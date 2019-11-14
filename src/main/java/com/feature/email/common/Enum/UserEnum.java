package com.feature.email.common.Enum;

import com.feature.email.common.inteface.BaseBussinessStatus;

public enum UserEnum implements BaseBussinessStatus {
    $encryptPwdFail(1001, "加密密码失败"),
    $decryptPwdFail(1002, "解密密码失败"),
    $userInfoNotComplete(1003, "请输入完整的用户信息"),
    $saveUserInfoFail(1004, "添加用户信息失败");

    private int code;
    private String message;

    UserEnum(int code, String message) {
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
