package com.ysy.petadopt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminIndexController {

    /**
     * 访问首页
     *
     * @return 首页地址
     */
    @GetMapping("index")
    public String index() {
        return "index";
    }

}
