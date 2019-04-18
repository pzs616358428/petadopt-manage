package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.User;
import com.ysy.petadopt.service.UserService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private UserService userService;

    @GetMapping("loginPage")
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("login")
    @ResponseBody
    public ResultVO login(User user, String remember, HttpServletResponse response, HttpSession httpSession) {
        // 根据用户名从数据库查询出userData对象
        User userData = userService.findByUsername(user.getUsername());
        if (userData == null) {
            return ResultVOUtils.error(1, "用户名不正确");
        } else if (!userData.getPassword().equals(user.getPassword())) {
            return ResultVOUtils.error(2, "密码不正确");
        } else {
            // 登录成功将用户信息保存到session中
            httpSession.setAttribute("user", userData);
            // 如果remember为null则不免登陆
            if (remember == null) {
                // 清除其他用户存的cookie
                Cookie cookie = new Cookie("user", null);
                cookie.setMaxAge(0);
                cookie.setPath(contextPath + "/admin");
                response.addCookie(cookie);
            } else {
                // 使用cookie保存用户信息实现免登陆
                Cookie cookie = new Cookie("user", userData.getUsername());
                cookie.setPath(contextPath + "/admin");
                // 设置cookie保存时间为十五天
                cookie.setMaxAge(60 * 60 * 24 * 15);
                response.addCookie(cookie);
            }
            return ResultVOUtils.success();
        }
    }

    @GetMapping("logout")
    public String logout(HttpServletResponse response, HttpSession httpSession) {
        // 清除session中的用户信息
        httpSession.removeAttribute("user");
        // 清除cookie中的用户信息
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        cookie.setPath(contextPath + "/admin");
        response.addCookie(cookie);
        // 回到登录页
        return "redirect:/admin/user/loginPage";
    }

}
