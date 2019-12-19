package com.feature.email;

import com.feature.email.utils.Base64Utils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

@Log4j2
@SuppressWarnings("all")
public class EncryptTest {
//userName=admin&userPassword=YWRtaW4=
    @Test
    public static void main(String[] args) {
        try {
            System.out.println(Base64Utils.encodeStr("admin"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
