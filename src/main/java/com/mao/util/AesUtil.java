package com.mao.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 用于与前端交互使用的加密解密
 * @author mao by 15:04 2019/12/24
 */
public class AesUtil {

    private static final String CODE = "utf-8";
    private static final String KEY_ALGORITHM = "AES";
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String enCode(String content, String key) {
        if (key == null || "".equals(key)) return null;
        if (key.length() != 16) return null;
        try {
            byte[] raw = key.getBytes();
            SecretKeySpec _key = new SecretKeySpec(raw,KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,_key);
            byte [] byte_content = content.getBytes(CODE);
            byte [] encode_content = cipher.doFinal(byte_content);
            return Base64.getEncoder().encodeToString(encode_content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String deCode(String content, String key) {
        if (key == null || "".equals(key)) return null;
        if (key.length() != 16) return null;
        try {
            byte[] raw = key.getBytes();
            SecretKeySpec _key = new SecretKeySpec(raw,KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,_key);
            byte [] encode_content = Base64.getDecoder().decode(content);
            byte [] byte_content = cipher.doFinal(encode_content);
            return new String(byte_content,CODE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String a = "hello world";
        String key = "aaa111bbb111ccc2";
        String encrypt = enCode(a, key);
        System.out.println(encrypt);
    }

}