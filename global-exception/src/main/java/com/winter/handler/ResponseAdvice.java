package com.winter.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winter.response.ResponseResult;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 拦截Controller方法的返回值, 统一处理接口返回值
 *
 * @author zhutengxun
 * @RestControllerAdvice是@RestController注解的增强，可以实现三个方面的功能： 1. 全局异常处理
 * 2. 全局数据绑定
 * 3. 全局数据预处理
 * @since 2025/5/29
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 是否开启对所有方法的处理, 可以在此方法中添加条件使其支持对特定方法的处理
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // return false;
        return true;
    }


    /**
     * 将接口返回值封装为全局统一响应对象
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body
            , MethodParameter returnType
            , MediaType selectedContentType
            , Class<? extends HttpMessageConverter<?>> selectedConverterType
            , ServerHttpRequest request
            , ServerHttpResponse response) {

        // 如果Controller返回值String, SpringBoot封装会报错, 使用SpringBoot内置的Jackson来对返回值序列化
        /*
          异常: java.lang.ClassCastException: class com.winter.response.ResponseResult cannot be cast to class java.lang.String (com.winter.response.ResponseResult is in unnamed module of loader 'app'; java.lang.String is in module java.base of loader 'bootstrap')
         */
        if (body instanceof String) {
            return objectMapper.writeValueAsString(ResponseResult.success(body));
        }

        // 如果响应数据类型是已经封装好的, 直接返回
        if (body instanceof ResponseResult) {
            return body;
        }

        return ResponseResult.success(body);

    }


}
