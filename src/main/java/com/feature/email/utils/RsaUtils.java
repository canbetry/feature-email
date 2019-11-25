package com.feature.email.utils;

import com.feature.email.common.Exception.DIYException;

import java.io.IOException;


/**
 * RSA封装工具类
 */
public class RsaUtils {

    /**
     * 私钥加密
     *
     * @param text
     * @return
     */
    public final static String encode(String text) {
        String privatekeyString = null;
        try {
            privatekeyString = RsaEncrypt.getPrikeyString();
        } catch (IOException e) {
            throw new DIYException("获取本地私钥失败", e);
        }
        String encStr = null;
        try {
            encStr = RsaEncrypt.encrypt(text, privatekeyString);
        } catch (Exception e) {
            throw new DIYException("加密失败", e);
        }
        return encStr;
    }

    /**
     * 公钥解密
     *
     * @param text
     * @return
     */
    public final static String decode(String text) {
        String publicString = null;
        try {
            publicString = RsaEncrypt.getPubKeyString();
        } catch (IOException e) {
            throw new DIYException("获取本地公钥失败", e);
        }
        String descStr = null;
        try {
            descStr = RsaEncrypt.decrypt(text, publicString);
        } catch (Exception e) {
            throw new DIYException("解密失败", e);
        }
        return descStr;
    }
}
