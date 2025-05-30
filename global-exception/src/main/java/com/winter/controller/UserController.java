package com.winter.controller;


import com.winter.enums.ResultCode;
import com.winter.exception.BusinessException;
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
        /*
         对于返回void的方法:
            1.使用ResponseResult.success()时, data赋值为null;
            2. 使用ResponseBodyAdvice时, 同样会将data处理为null
         */
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
        return ResponseResult.error(ResultCode.SERVER_ERROR.getCode(), ResultCode.SERVER_ERROR.getMessage());
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


// ------------------------------ 全局异常捕获 -------------------------------------------------


    /**
     * 全局异常捕获
     *
     * @return User对象集合
     */
    @GetMapping(value = "/ex/list/advice")
    public List<User> exListAdvice() {
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(1L).name("张三").age(1).build());
        list.add(User.builder().id(1L).name("李四").age(1).build());

        // 异常测试
        list.get(2);

        return list;
    }

    /**
     * 全局异常捕获-自定义异常
     *
     * @return User对象集合
     */
    @GetMapping(value = "/ex/business")
    public List<User> exBusiness() {
        List<User> list = new ArrayList<>();

        // 自定义异常
        if (true) {
            throw new BusinessException(ResultCode.SERVICE_UNAVAILABLE_ERROR.getCode(), ResultCode.SERVICE_UNAVAILABLE_ERROR.getMessage());
        }

        return list;
    }


    /**
     * 全局异常捕获-约定异常编码
     *
     * @return User对象集合
     */
    @GetMapping(value = "/ex/agree")
    public List<User> exAgree() {
        List<User> list = new ArrayList<>();

        // 空指针异常(约定异常编码:)
        list = null;
        list.get(0);

        return list;
    }


}
