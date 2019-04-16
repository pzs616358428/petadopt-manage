package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.User;

public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return 用户对象
     */
    User findByUsername(String username);

}
