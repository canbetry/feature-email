package com.feature.email.utils;

import com.feature.email.common.Exception.DIYException;

import java.io.IOException;


/**
 * @description: RsaUtils <br>
 * @date: 2020/1/7 10:51 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
public class RsaUtils {

    /**
     * 私钥加密
     *
     * @param text
     * @return
     */
    public final static String encode(String text) {
        String publickeyString = null;
        try {
            publickeyString = RsaEncrypt.getPubKeyString();
        } catch (IOException e) {
            throw new DIYException("获取本地私钥失败", e);
        }
        String encStr = null;
        try {
            encStr = RsaEncrypt.encrypt(text, publickeyString);
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
        String privateString = null;
        try {
            privateString = RsaEncrypt.getPrikeyString();
        } catch (IOException e) {
            throw new DIYException("获取本地公钥失败", e);
        }
        String descStr = null;
        try {
            descStr = RsaEncrypt.decrypt(text, privateString);
        } catch (Exception e) {
            throw new DIYException("解密失败", e);
        }
        return descStr;
    }
}
