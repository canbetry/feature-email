package com.feature.email;

import com.feature.email.utils.Base64Utils;
import com.feature.email.utils.RsaUtils;

import java.io.UnsupportedEncodingException;

public class TestZZ {

    public static void main(String[] args) {
        String emailEncode = "QDVsWr62jbNjm+VfLDN8K64nxUHlyO8kMIV2kYSQUveTf9Ste+Q6qRbUg9lB8RP6wM/ewJIC5ASKvI3arf+vqNHdqHypq8G6aWhHoKJEXoUbN1P0O11GkXZEg1/Ed4RPxRmyYEtBkHWxCUixWhBi6m2oFrLb91nB5PTibgqgMBA=";
        String pwdEncode = "I2zkP6MIyQRTk8PEKBg0MCrWqz+0vXmJ1yVD2eAHFnGgGUjrtG4rVDKFOQSYbM+MhYHTQfxr6ug4SSB/fFfSZc16NRV488EPc2y3mGlkUlMiCyG5BEc1CmE64kG8uiUVRU/8aNU/3nuzL5GgWTSIXXr9pLq/EuCDlUu6UnyShHg=";
        try {
            System.out.println(Base64Utils.decodeStr(RsaUtils.decode(emailEncode)));
            System.out.println(Base64Utils.decodeStr(RsaUtils.decode(pwdEncode)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
