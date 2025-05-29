package com.winter.enums;

import lombok.Getter;


/**
 * 响应结果状态码
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "success"),
    PARAM_ERROR(400, "请求参数错误"),
    SERVER_ERROR(500, "服务器错误");


    /**
     * 编码
     */
    private final int code;

    /**
     * 描述信息
     */
    private final String message;


    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
