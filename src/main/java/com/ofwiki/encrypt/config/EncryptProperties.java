package com.ofwiki.encrypt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author HuangJS
 * @date 2019/12/24 11:20 上午
 */
@ConfigurationProperties(prefix = "spring.encrypt")
public class EncryptProperties {
    /**
     * AES加密KEY
     */
    private String aesKey;

    /**
     * AES加密的初始化向量
     */
    private String aesIv;

    /**
     * 开启调试模式,调试模式下不进行加解密操作
     */
    private boolean debug = false;


    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getAesIv() {
        return aesIv;
    }

    public void setAesIv(String aesIv) {
        this.aesIv = aesIv;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
