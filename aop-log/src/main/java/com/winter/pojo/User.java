package com.winter.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class User {


    private Long id;

    private String name;

    private int age;

}
