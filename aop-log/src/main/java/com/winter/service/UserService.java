package com.winter.service;

import com.winter.pojo.User;

public interface UserService {


    User userInfoBYId(Long id);



    void infoVoid(Long id);




    User update(User user);

}
