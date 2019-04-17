package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.User;
import com.ysy.petadopt.service.UserService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("loginPage")
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("login")
    @ResponseBody
    public ResultVO login(User user, String remember, HttpServletRequest request) {
        // 根据用户名从数据库查询出userData对象
        User userData = userService.findByUsername(user.getUsername());
        if (userData == null) {
            return ResultVOUtils.error(1, "用户名不正确");
        } else if (!userData.getPassword().equals(user.getPassword())) {
            return ResultVOUtils.error(2, "密码不正确");
        } else {
            // 登录成功将用户信息保存到session中
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userInfo", userData);
            return ResultVOUtils.success();
        }
    }

}
