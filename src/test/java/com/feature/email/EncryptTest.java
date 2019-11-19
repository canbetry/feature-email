package com.feature.email;

import com.feature.email.utils.Base64Utils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

@Log4j2
@SuppressWarnings("all")
public class EncryptTest {

    @Test
    public static void main(String[] args) {
        String pwd = null;
        try {
            pwd = Base64Utils.encodeStr("strive0214");
        } catch (UnsupportedEncodingException e) {
        }
        System.out.println(pwd);
        String email = null;
        try {
            email = Base64Utils.encodeStr("canbetry@163.com");
        } catch (UnsupportedEncodingException e) {
        }
        System.out.println(email);
    }
}
