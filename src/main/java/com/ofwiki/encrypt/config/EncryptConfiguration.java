package com.ofwiki.encrypt.config;

import com.ofwiki.encrypt.advice.DecryptRequestBodyAdvice;
import com.ofwiki.encrypt.advice.EncryptResponseBodyAdvice;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuangJS
 * @date 2019/12/24 11:07 上午
 */
@Configuration
@EnableConfigurationProperties(EncryptProperties.class)
public class EncryptConfiguration {

    /**
     * 配置请求加密
     * @return
     */
    @Bean
    public EncryptResponseBodyAdvice encryptResponseBodyAdvice(EncryptProperties properties) {
        return new EncryptResponseBodyAdvice(properties);
    }

    /**
     * 配置请求解密
     * @return
     */
    @Bean
    public DecryptRequestBodyAdvice encryptRequestBodyAdvice(EncryptProperties properties) {
        return new DecryptRequestBodyAdvice(properties);
    }
}
