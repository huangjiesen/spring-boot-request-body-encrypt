package com.ofwiki.encrypt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


/**
 * @author HuangJS
 * @date 2019/12/24 11:20 上午
 */
public class AesUtil {
    private static final Logger logger = LoggerFactory.getLogger(AesUtil.class);
    public final static String ECB = "AES/ECB/PKCS5Padding";
    public final static String CBC = "AES/CBC/PKCS5Padding";
    final static String UTF_8 = "UTF-8";

    /**
     * 加密
     * @param text
     * @param key
     * @return
     */
    public static String encrypt(String text, String key){
        return encrypt(text, key, null, UTF_8);
    }

    /**
     * 加密
     * @param text
     * @param key
     * @param ivKey
     * @return
     */
    public static String encrypt(String text, String key,String ivKey){
        return encrypt(text, key, ivKey, UTF_8);
    }

    /**
     * 加密
     * @param text
     * @param key
     * @param ivKey
     * @param charset
     * @return
     */
    public static String encrypt(String text, String key, String ivKey, String charset){
        try {
            boolean hasIV = ivKey != null;
            Cipher cipher = Cipher.getInstance(hasIV ? CBC : ECB);
            SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(charset), "AES");
            if (hasIV) {
                // 加密和解密工作模式为CBC、CFB、OFB时必需指定初始化向量
                IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes(charset));
                cipher.init(Cipher.ENCRYPT_MODE, aesKey, iv);
            } else {
                // 工作模式为ECB时不可初始化向量
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            }
            byte[] bytes = cipher.doFinal(text.getBytes(charset));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    /**
     * 解密
     * @param cipherText
     * @param key
     * @return
     */
    public static String decrypt(String cipherText, String key){
        return decrypt(cipherText, key, null, UTF_8);
    }

    /**
     * 解密
     * @param cipherText
     * @param key
     * @param iv
     * @return
     */
    public static String decrypt(String cipherText, String key,String iv){
        return decrypt(cipherText, key, iv, UTF_8);
    }

    /**
     * 解密
     * @param cipherText
     * @param key
     * @param ivKey
     * @param charset
     * @return
     */
    public static String decrypt(String cipherText, String key,String ivKey, String charset){
        try {
            boolean hasIV = ivKey != null;
            Cipher cipher = Cipher.getInstance(hasIV ? CBC : ECB);
            SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(charset), "AES");
            if (hasIV) {
                IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes(charset));
                cipher.init(Cipher.DECRYPT_MODE, aesKey, iv);
            } else {
                cipher.init(Cipher.DECRYPT_MODE,aesKey);
            }
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
            return new String(bytes, "utf-8");
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }
}
