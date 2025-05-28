package com.winter.controller;

import com.winter.pojo.User;
import com.winter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/info/{id}")
    public User userInfoBYId(@PathVariable Long id) {
        return userService.userInfoBYId(id);

//        userService.infoVoid(id);
//        return null;

    }


    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

}