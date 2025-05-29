package com.winter.response;

import com.winter.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 全局统一响应对象
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@Setter
@Getter
public class ResponseResult<T> {


    /**
     * 状态码
     */
    private Integer code;


    /**
     * 描述信息
     */
    private String message;


    /**
     * 返回值
     */
    private T data;


    /**
     * @param code      状态码
     * @param message   描述信息
     * @param data      返回值对象
     * @param <T>       返回值数据类型
     * @return {@link ResponseResult <T>}全局统一响应对象
     */
    private static <T> ResponseResult<T> response(Integer code, String message, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setData(data);
        return responseResult;
    }


    /**
     * 成功
     *
     * @param data      返回值对象
     * @param <T>       返回值数据类型
     * @return {@link ResponseResult <T>}全局统一响应对象
     */
    public static <T> ResponseResult<T> success(T data) {
        return response(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    /**
     * @param code      状态码
     * @param message   描述信息
     * @param data      返回值对象
     * @param <T>       返回值数据类型
     * @return {@link ResponseResult <T>}全局统一响应对象
     */
    public static <T> ResponseResult<T> error(int code, String message, T data) {
        return response(code, message, data);
    }


    /**
     * @param code      状态码
     * @param message   描述信息
     * @param <T>       返回值数据类型
     * @return {@link ResponseResult <T>}全局统一响应对象
     */
    public static <T> ResponseResult<T> error(int code, String message) {
        return response(code, message, null);
    }


}
