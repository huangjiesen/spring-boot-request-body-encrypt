package com.ofwiki.encrypt.advice;

import com.ofwiki.encrypt.annotations.Encrypt;
import com.ofwiki.encrypt.annotations.EncryptDecrypt;
import com.ofwiki.encrypt.config.EncryptProperties;
import com.ofwiki.encrypt.utils.AesUtil;
import com.ofwiki.encrypt.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author HuangJS
 * @date 2019/12/24 11:11 上午
 */
@ControllerAdvice
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private Logger logger = LoggerFactory.getLogger(DecryptRequestBodyAdvice.class);
    private EncryptProperties ep;
    public EncryptResponseBodyAdvice(EncryptProperties ep) {
        Assert.notNull((this.ep = ep).getAesKey(),"please config spring.encrypt.aes-key");
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter mp, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (ep.isDebug()) {
            return body;
        }

        long startTime = System.currentTimeMillis();
        Method method = mp.getMethod();
        if (method.isAnnotationPresent(Encrypt.class) || method.isAnnotationPresent(EncryptDecrypt.class)) {
            String content = JsonUtil.object2Json(body);
            String result =  AesUtil.encrypt(content, ep.getAesKey(),ep.getAesIv());
            long endTime = System.currentTimeMillis();
            logger.debug("Encrypt Time:" + (endTime - startTime));
            return result;
        }
        return body;
    }
}
