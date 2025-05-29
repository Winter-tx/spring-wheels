package com.winter.controller;


import com.winter.enums.ResultCode;
import com.winter.pojo.User;
import com.winter.response.ResponseResult;
import com.winter.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * UserController
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final IUserService userService;


// ------------------------------ 通过ResponseResult方法处理为统一响应对象 -------------------------------------------------


    /**
     * success
     * 通过ResponseResult方法处理为统一响应对象
     *
     * @param id id
     * @return 统一响应对象, 泛型为User对象
     */
    @GetMapping(value = "/info/{id}")
    public ResponseResult<User> info(@PathVariable Long id) {
        User info = userService.info(id);
        return ResponseResult.success(info);
    }


    /**
     * success
     * 通过ResponseResult方法处理为统一响应对象
     *
     * @param id id
     * @return 统一响应对象, 泛型为void
     */
    @GetMapping("/info/void/{id}")
    public ResponseResult<Void> infoVoid(Long id) {
        userService.infoVoid(id);
        return ResponseResult.success(null);
    }


    /**
     * error
     * 通过ResponseResult方法处理为统一响应对象
     *
     * @param user user
     * @return 统一响应对象, 泛型为User对象
     */
    @PostMapping("/update")
    public ResponseResult<User> update(@RequestBody User user) {
        User update = userService.update(user);
        return ResponseResult.error(ResultCode.SERVICE_ERROR.getCode(), ResultCode.SERVICE_ERROR.getMessage());
    }


    /**
     * success
     * 通过ResponseResult方法处理为统一响应对象
     *
     * @return 统一响应对象, 泛型为User对象集合
     */
    @GetMapping(value = "/list")
    public ResponseResult<List<User>> list() {
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(1L).name("张三").age(1).build());
        list.add(User.builder().id(1L).name("李四").age(1).build());

        return ResponseResult.success(list);
    }


// ------------------------------ 通过ResponseBodyAdvice拦截controller方法的返回值 -------------------------------------------------

    /**
     * 通过ResponseBodyAdvice拦截controller方法的返回值
     *
     * @return User对象集合
     */
    @GetMapping(value = "/list/advice")
    public List<User> listAdvice() {
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(1L).name("张三").age(1).build());
        list.add(User.builder().id(1L).name("李四").age(1).build());

        return list;
    }

    /**
     * 通过ResponseBodyAdvice拦截controller方法的返回值
     *
     * @return User对象集合
     */
    @GetMapping(value = "/name")
    public String userName() {
        return "winter";
    }


}
