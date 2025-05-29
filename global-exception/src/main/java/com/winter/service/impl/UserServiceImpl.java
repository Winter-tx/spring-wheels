package com.winter.service.impl;

import com.winter.pojo.User;
import com.winter.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * UserServiceImpl
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {


    /**
     * @param id id
     * @return User
     */
    @Override
    public User info(Long id) {

        log.info("Running-Method-Begin: UserServiceImpl.info ---------------------");

        return User.builder()
                .id(1L)
                .name("winter")
                .age(1)
                .build();

    }


    /**
     * @param id id
     */
    @Override
    public void infoVoid(Long id) {

        log.info("Running-Method-Begin: UserServiceImpl.infoVoid ---------------------");

    }


    /**
     * @param user user
     * @return User
     */
    @Override
    public User update(User user) {

        log.info("Running-Method-Begin: UserServiceImpl.update ---------------------");

        return user;
    }

}
