package com.ofwiki.encrypt.annotations;

import java.lang.annotation.*;

/**
 * 加解密注解,等同使用了{@link Decrypt @Decrypt}、{@link Encrypt @Encrypt}
 * <ul>
 *     <li>将接口的请求参数进行数据解密操作</li>
 *     <li>将接口的返回数据进行加密操作</li>
 * </ul>
 * @author HuangJS
 * @date 2019/12/24 11:19 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptDecrypt {
}
