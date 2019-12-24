package com.ofwiki.encrypt.advice;

import com.ofwiki.encrypt.config.EncryptProperties;
import com.ofwiki.encrypt.utils.AesUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author HuangJS
 * @date 2019/12/24 10:55 上午
 */
public class DecryptHttpInputMessage implements HttpInputMessage {
    private Logger logger = LoggerFactory.getLogger(DecryptRequestBodyAdvice.class);
    private HttpHeaders headers;
    private InputStream body;

    public DecryptHttpInputMessage(HttpInputMessage inputMessage, EncryptProperties ep) throws Exception {
        String content = IOUtils.toString(inputMessage.getBody(), "UTF-8");
        long startTime = System.currentTimeMillis();
        // decrypt body data
        String decryptBody = AesUtil.decrypt(content, ep.getAesKey(), ep.getAesIv());
        logger.debug("Decrypt Time:" + (System.currentTimeMillis() - startTime));

        this.body = IOUtils.toInputStream(decryptBody != null ? decryptBody : "{}", "UTF-8");
        this.headers = inputMessage.getHeaders();
    }

    @Override
    public InputStream getBody() throws IOException {
        return this.body;
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.headers;
    }
}
