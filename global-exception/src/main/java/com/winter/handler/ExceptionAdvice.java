package com.winter.handler;

import com.winter.enums.ResultCode;
import com.winter.response.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常响应处理
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@RestControllerAdvice
public class ExceptionAdvice {


    /**
     * 最大异常处理
     * <p>
     * 注解@ExceptionHandler: 统一处理某一类异常; 比如捕获空指针异常: @ExceptionHandler(NullPointerException.class)
     * 注解@ResponseStatus: 指定浏览器接收的HTTP请求状态码;
     * 注意是HTTP请求的状态码, 并非为统一响应对象ResponseResult的状态码
     * 比如@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)表示浏览器接收的HTTP请求状态码为500.
     * 如果不指定, 则默认返回200.
     *
     * @param ex 异常对象
     * @return 全局统一响应对象
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<String> exceptionHandler(Exception ex) {
        //  return ResponseResult.error(ResultCode.SERVER_ERROR.getCode(), ex.getMessage());
        return ResponseResult.error(ResultCode.SERVER_ERROR.getCode(), ex.toString());
    }


}
