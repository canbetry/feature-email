package com.feature.email.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {

    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();


    //base64加密
    public final static String encodeStr(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("UTF-8");
        return encoder.encodeToString(bytes);
    }

    //base64解密
    public final static String decodeStr(String enText) throws UnsupportedEncodingException {
        return new String(decoder.decode(enText), "UTF-8");
    }
}
