package com.winter.service;


import com.winter.pojo.User;


/**
 * UserService
 *
 * @author zhutengxun
 * @since 2025/5/29
 */
public interface IUserService {


    /**
     * @param id id
     * @return User
     */
    User info(Long id);


    /**
     * @param id id
     */
    void infoVoid(Long id);


    /**
     * @param user user
     * @return User
     */
    User update(User user);
}
