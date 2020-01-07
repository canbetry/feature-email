package com.feature.email.utils;

import com.feature.email.common.Enum.BaseErrorMsg;
import com.feature.email.common.Enum.Constant;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


/**
 * @description: RsaEncrypt <br>
 * @date: 2020/1/7 10:46 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@SuppressWarnings("all")
@Log4j2
public class RsaEncrypt {

    /**
     * 用于封装随机产生的公钥与私钥
     */
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();

    /**
     * 路径
     */
    private static String keyFilePathLinux = "/home/rsaKey";
    private static String keyFilePathWindows = "D:\\\\rsaKey";

    /**
     * Linux密钥
     */
    private static String linuxPriKeyPath = "/home/rsaKey/rsaPriKey.key";
    private static String linuxPubKeyPath = "/home/rsaKey/rsaPubKey.key";

    /**
     * windows密钥
     */
    private static String windosPriKeyPath = "D:\\rsaKey\\rsaPriKey.key";
    private static String windosPubKeyPath = "D:\\rsaKey\\rsaPubKey.key";

    /**
     * 读取本地公钥
     *
     * @return
     * @throws IOException
     */
    public final static String getPubKeyString() throws IOException {
        String pubKeyPath = System.getProperty(Constant.SYSTEM_PROPERTY).toLowerCase().
                startsWith(Constant.WIN_SYSTEM_VERSION_LOWER_CASE) ? windosPubKeyPath : linuxPubKeyPath;
        return readFile(pubKeyPath);
    }


    /**
     * 读取本地私钥
     *
     * @return
     * @throws IOException
     */
    public final static String getPrikeyString() throws IOException {
        String priKeyPath = System.getProperty(Constant.SYSTEM_PROPERTY).toLowerCase().
                startsWith(Constant.WIN_SYSTEM_VERSION_LOWER_CASE) ? windosPriKeyPath : linuxPriKeyPath;
        return readFile(priKeyPath);
    }

    /**
     * @param file
     * @return
     * @throws IOException
     */
    private final static String readFile(String file) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(file)));
        String keyStr = "";
        try {
            int ch = 0;
            while ((ch = isr.read()) != -1) {
                keyStr = keyStr + (char) ch;
            }
        } finally {
            isr.close();
        }
        return keyStr;
    }

    /**
     * 加密
     *
     * @param str
     * @param publicKey
     * @return
     * @throws Exception
     */
    public final static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(Constant.STRING_RSA).generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance(Constant.STRING_RSA);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes(Constant.CODING_TYPE_UTF8)));
        return outStr;
    }


    /**
     * 解密
     *
     * @param str
     * @param privateKey
     * @return
     * @throws Exception
     */
    public final static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes(Constant.CODING_TYPE_UTF8));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(Constant.STRING_RSA).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance(Constant.STRING_RSA);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


    /**
     * 生成密钥、保存密钥、验证密钥
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "luoyunlong";
        System.out.println("随机生成的公钥为:" + keyMap.get(Constant.COMMON_NUMBER_ZERO));
        System.out.println("随机生成的私钥为:" + keyMap.get(Constant.COMMON_NUMBER_ONE));
        String messageEn = encrypt(message, keyMap.get(Constant.COMMON_NUMBER_ZERO));
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(Constant.COMMON_NUMBER_ONE));
        System.out.println("还原后的字符串为:" + messageDe);
    }


    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public final static void genKeyPair() throws NoSuchAlgorithmException, FileNotFoundException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(Constant.STRING_RSA);
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(Constant.COMMON_NUMBER_MB, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(Constant.COMMON_NUMBER_ZERO, publicKeyString);  //0表示公钥
        keyMap.put(Constant.COMMON_NUMBER_ONE, privateKeyString);  //1表示私钥
        //将密钥保存至本地
        String keyFilePath = null;
        String property = System.getProperty(Constant.SYSTEM_PROPERTY);
        keyFilePath = property.toLowerCase().startsWith(Constant.WIN_SYSTEM_VERSION_LOWER_CASE) ?
                keyFilePathWindows : keyFilePathLinux;

        //路径
        File keyFile = new File(keyFilePath);
        if (keyFile.exists()) {
            System.out.println(BaseErrorMsg.fileExists);
        } else {
            keyFile.mkdirs();
        }
        File priKey = new File(keyFile + (property.toLowerCase().startsWith(Constant.WIN_SYSTEM_VERSION_LOWER_CASE)
                ? Constant.WIN_RSA_PRIVATE_KEY_PATH : Constant.LINUX_RSA_PRIVATE_KEY_PATH));
        if (!priKey.exists()) {
            try {
                priKey.createNewFile();
            } catch (IOException e) {
                log.error(BaseErrorMsg.IOEXCEPTION, e);
            }
        }
        File pubKey = new File(keyFile + (property.toLowerCase().startsWith(Constant.WIN_SYSTEM_VERSION_LOWER_CASE)
                ? Constant.WIN_RSA_PUBLIC_KEY_PATH : Constant.LINUX_RSA_PUBLIC_KEY_PATH));
        //保存私钥
        BufferedWriter writerPri = null;
        try {
            writerPri = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(priKey, false), Constant.CODING_TYPE_UTF8));
            writerPri.write(privateKeyString);
        } catch (IOException e) {
            log.error(BaseErrorMsg.IOEXCEPTION, e);
        } finally {
            try {
                if (writerPri != null) {
                    writerPri.close();
                }
            } catch (IOException e) {
                log.error(BaseErrorMsg.IOEXCEPTION, e);
            }
        }
        //保存公钥
        BufferedWriter writerPub = null;
        try {
            writerPub = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pubKey, false), Constant.CODING_TYPE_UTF8));
            writerPub.write(publicKeyString);
        } catch (IOException e) {
            log.error(BaseErrorMsg.IOEXCEPTION, e);
        } finally {
            try {
                if (writerPub != null) {
                    writerPub.close();
                }
            } catch (IOException e) {
                log.error(BaseErrorMsg.IOEXCEPTION, e);
            }
        }
    }


}
