package com.ysy.petadopt.controller;

import com.ysy.petadopt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/loginPage")
    public String loginPage() {
        return "user/login";
    }

}
