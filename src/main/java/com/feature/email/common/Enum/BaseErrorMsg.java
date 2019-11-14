package com.feature.email.common.Enum;

public enum BaseErrorMsg {
    encryptPwdFail("加密密码失败"),
    decryptPwdFail("解密密码失败");
    private String msg;

    BaseErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
