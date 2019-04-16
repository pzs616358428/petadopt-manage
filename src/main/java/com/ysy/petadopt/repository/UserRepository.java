package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return 用户对象
     */
    User findByUsername(String username);

}
