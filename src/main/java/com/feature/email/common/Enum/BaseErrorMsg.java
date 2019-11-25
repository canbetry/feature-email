package com.feature.email.common.Enum;

/**
 * 基础错误信息
 */
public enum BaseErrorMsg {
    encryptPwdFail("加密密码失败"),
    decryptPwdFail("解密密码失败"),
    sessionInfoIsNull("未找到用户信息"),
    IOEXCEPTION("IO异常"),
    fileExists("文件已存在");
    private String msg;

    BaseErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
