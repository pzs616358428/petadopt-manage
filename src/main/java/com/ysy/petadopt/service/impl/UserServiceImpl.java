package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.User;
import com.ysy.petadopt.repository.UserRepository;
import com.ysy.petadopt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
