package com.feature.email.utils;

import org.apache.commons.lang3.RandomUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64工具类
 */
public class Base64Utils {

    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();
    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    //base64加密
    public final static String encodeStr(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("UTF-8");
        return encoder.encodeToString(bytes);
    }

    //base64解密
    public final static String decodeStr(String enText) throws UnsupportedEncodingException {
        return new String(decoder.decode(enText), "UTF-8");
    }


    //随机生成8位数盐值，用于特殊信息加密
    public static String generateMixRandomCode() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int number = RandomUtils.nextInt(0, 62);
            sb.append(RANDOM_STR.charAt(number));
        }
        return sb.toString();
    }
}
