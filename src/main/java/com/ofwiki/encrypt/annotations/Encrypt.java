package com.ofwiki.encrypt.annotations;

import java.lang.annotation.*;

/**
 * 加密注解<br />
 * 将接口的返回数据进行加密操作
 * @author HuangJS
 * @date 2019/12/24 11:18 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Encrypt {

}
