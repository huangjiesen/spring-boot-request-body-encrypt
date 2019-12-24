package com.ofwiki.encrypt.annotations;

import java.lang.annotation.*;
/**
 * 加密注解<br />
 * 将接口的请求参数进行数据解密操作<br />
 * @author HuangJS
 * @date 2019/12/24 11:17 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt {

}
