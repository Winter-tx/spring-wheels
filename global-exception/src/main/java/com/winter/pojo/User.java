package com.winter.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * User
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@Setter
@Getter
@Builder
public class User {

    private long id;

    private String name;

    private int age;

}
