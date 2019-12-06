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
        String email = "canbetry@163.com";
        String salt = "d0Cn75BB";
        String newEmail = null;
        try {
            newEmail = Base64Utils.decodeStr("YWRtaW4xMjM=6y0jFTwe=");
        } catch (UnsupportedEncodingException e) {
        }
        System.out.println(newEmail);
    }
}
