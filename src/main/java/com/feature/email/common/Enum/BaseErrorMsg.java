package com.feature.email.common.Enum;

/**
 * 基础错误信息
 *
 * @description: BaseErrorMsg <br>
 * @date: 2020/1/7 11:13 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
public enum BaseErrorMsg {
    encryptPwdFail("加密密码失败"),
    decryptPwdFail("解密密码失败"),
    sessionInfoIsNull("未找到用户信息"),
    IOEXCEPTION("IO异常"),
    fileExists("文件已存在"),
    decryptEmailFail("解密邮箱失败"),
    encryptEmailFail("加密邮箱失败"),
    updateFail("更新失败,系统异常"),
    saveFail("保存失败,系统异常"),
    oldPwdDifferent("原始密码不一致，修改密码失败"),
    decryptFail("解密失败"),
    encryptFail("加密失败"),
    systemException("系统异常"),
    argsLengthError("参数长度不对，attachments请传2两个参数[文件名][文件路径]"),
    //----------------------email相关--------------------------//
    saveEmailFail("保存邮件失败");
    private String msg;

    BaseErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
