package com.feature.email.common.Enum;

import com.feature.email.common.inteface.BaseBussinessStatus;


/**
 * 用户模块异常信息
 */
public enum UserEnum implements BaseBussinessStatus {
    $encryptPwdFail(1001, "加密密码失败"),
    $decryptPwdFail(1002, "解密密码失败"),
    $userInfoNotComplete(1003, "请输入完整的用户信息"),
    $saveUserInfoFail(1004, "添加用户信息失败"),
    $decryptEmailFail(1005, "解密邮箱失败"),
    $encryptEmailFail(1006, "加密邮箱失败"),
    $userInfoIsNull(1007, "用户信息为空，请检查用户名和密码是否为空"),
    $userIsExisted(1008, "用户名已被占用"),
    $userPasswordError(1009, "登陆失败，密码错误"),
    $registerFailed(1010, "注册失败，系统异常"),
    $loginFailed(1011, "登陆失败，系统异常"),
    $loginSuccess(1012, "登陆成功");

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
