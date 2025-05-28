package com.winter.service.impl;

import com.winter.annotation.AopAnno;
import com.winter.pojo.User;
import com.winter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @AopAnno
    @Override
    public User userInfoBYId(Long id) {
        log.info("Running-Method-Begin: UserServiceImpl.userInfoBYId ---------------------");

//        if (true) {
//            throw new RuntimeException("Winter, Exception");
//        }

        return User.builder()
                .id(1L)
                .name("winter")
                .age(1)
                .build();

    }


    @AopAnno
    @Override
    public void infoVoid(Long id) {

        log.info("Running-Method-Begin: UserServiceImpl.infoVoid ---------------------");

    }


    @AopAnno
    @Override
    public User update(User user) {

        log.info("Running-Method-Begin: UserServiceImpl.update ---------------------");

//        if (true) {
//            throw new RuntimeException("Winter, Exception");
//        }

        return user;
    }


}


