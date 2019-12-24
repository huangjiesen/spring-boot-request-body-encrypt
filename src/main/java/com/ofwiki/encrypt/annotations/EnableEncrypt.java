package com.ofwiki.encrypt.annotations;

import com.ofwiki.encrypt.config.EncryptConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * 启用加密Starter<br />
 * <p>在Spring Boot启动类上加上此注解<p>
 * <pre class="code">
 * &#064;SpringBootApplication
 * &#064;EnableEncrypt
 * public class App {
 *     public static void main(String[] args) {
 *         SpringApplication.run(App.class, args);
 *     }
 * }
 * <pre>
 * @author HuangJS
 * @date 2019/12/24 11:18 上午
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EncryptConfiguration.class})
@Deprecated
public @interface EnableEncrypt {

}
