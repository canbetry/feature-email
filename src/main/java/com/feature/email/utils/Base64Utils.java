package com.feature.email.utils;

import org.apache.commons.lang3.RandomUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @description: Base64Utils <br>
 * @date: 2020/1/7 10:53 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
public class Base64Utils {

    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();
    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 默认盐值长度
     */
    final static int DEFAULT_LENGTH = 8;

    /**
     * base64加密
     *
     * @param text
     * @return
     * @throws UnsupportedEncodingException
     */
    public final static String encodeStr(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("UTF-8");
        return encoder.encodeToString(bytes);
    }

    /**
     * base64解密
     *
     * @param enText
     * @return
     * @throws UnsupportedEncodingException
     */
    public final static String decodeStr(String enText) throws UnsupportedEncodingException {
        return new String(decoder.decode(enText), "UTF-8");
    }


    /**
     * 随机生成8位数盐值，用于特殊信息加密
     *
     * @return
     */
    public static String generateMixRandomCode() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            int number = RandomUtils.nextInt(0, 62);
            sb.append(RANDOM_STR.charAt(number));
        }
        return sb.toString();
    }
}
