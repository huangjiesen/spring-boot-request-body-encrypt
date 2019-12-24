package com.ofwiki.encrypt.advice;

import com.ofwiki.encrypt.annotations.Decrypt;
import com.ofwiki.encrypt.annotations.EncryptDecrypt;
import com.ofwiki.encrypt.config.EncryptProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author HuangJS
 * @date 2019/12/24 10:57 上午
 */
@ControllerAdvice
public class DecryptRequestBodyAdvice implements RequestBodyAdvice {
    private Logger logger = LoggerFactory.getLogger(DecryptRequestBodyAdvice.class);

    private EncryptProperties ep;

    public DecryptRequestBodyAdvice(EncryptProperties ep) {
        Assert.notNull((this.ep = ep).getAesKey(),"please config spring.encrypt.aes-key");
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage im, MethodParameter mp, Type type, Class<? extends HttpMessageConverter<?>> aClass)  {
        if (ep.isDebug()) {
            return im;
        }
        Method method = mp.getMethod();
        if (method.isAnnotationPresent(Decrypt.class) || method.isAnnotationPresent(EncryptDecrypt.class)) {
            try {
                return new DecryptHttpInputMessage(im, ep);
            } catch (Exception e) {
                logger.error("Decrypt body error | " + e.getMessage(), e);
            }
            return null;
        }
        return im;
    }
}
