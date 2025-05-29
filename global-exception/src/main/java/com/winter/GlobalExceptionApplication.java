package com.winter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 全局响应结果统一处理, 全局异常处理
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@SpringBootApplication
public class GlobalExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlobalExceptionApplication.class, args);
    }
}