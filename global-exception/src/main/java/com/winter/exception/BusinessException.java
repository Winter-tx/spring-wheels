package com.winter.exception;

import lombok.Getter;
import lombok.Setter;


/**
 * 自定义异常
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {


    /**
     * 状态码
     */
    private Integer code;


    /**
     * 描述信息
     */

    private String message;


    public BusinessException(Integer code, String message) {
        // super(message);
        this.code = code;
        this.message = message;
    }

}
