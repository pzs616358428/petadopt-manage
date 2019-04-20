package com.ysy.petadopt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/encyclopedias/")
public class AdminEncyclopediasController {

    @GetMapping("list")
    public String list() {
        return "encyclopedias/list";
    }

}
