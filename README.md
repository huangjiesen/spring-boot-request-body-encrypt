# 项目介绍
使用AES对称加密算法，对以下类型的请求参数及返回结果数据进行加解密
1. 对@RequestBody或HttpEntity方法参数进行解密
1. 对@ResponseBody或ResponseEntity类型的返回数据进行加密

# 使用说明
1. 添加依赖
    ```yaml
    <dependency>
        <groupId>com.ofwiki</groupId>
        <artifactId>spring-boot-request-body-encrypt</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```
1. 配置`application.yml`
    ```yaml
    spring:
      encrypt:
        aes-key: 0123456789123456  # AES密钥,可选长度为128位(16字节)、192位(24字节)、256位(32字节),长度大于128位需要下载JCE无限制权限策略文件
        aes-iv: 1234560123456789   # AES的初始化向量，长度为128位(16字节) 
        debug: false               # 开启调试模式,调试模式下不进行加解密操作
    ```
1. 代码示例
```java
@RestController
@RequestMapping("order")
public class OrderController {
    @PostMapping("get_detail")
    // @Encrypt     // 对返回数据进行加密
    // @Decrypt     // 对请示参数进行解密
    @EncryptDecrypt // 等效于同时使用@Encrypt,@Decrypt两个注解
    public Result<OrderDTO> get(@RequestBody OrderReq req) {
        return Result.success(orderService.getDetail(req.getId()));
    }
}
```

