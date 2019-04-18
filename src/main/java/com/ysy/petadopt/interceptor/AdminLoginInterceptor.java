package com.ysy.petadopt.interceptor;

import com.ysy.petadopt.entity.User;
import com.ysy.petadopt.service.UserService;
import com.ysy.petadopt.utils.CookiesToMapConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 登录拦截器类
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        // 如果user为null说明session中没有用户信息
        if (user == null) {
            // 查询cookie中的userInfo
            Map<String, String> cookieMap = CookiesToMapConvert.convert(request.getCookies());
            String username = cookieMap.get("user");
            // 如果cookie中也没有登录信息说明未免登陆
            if (username == null) {
                response.sendRedirect(contextPath + "/admin/user/loginPage");
                return false;
            } else {
                User userData = userService.findByUsername(username);
                // 有用户修改了cookie或者用户被删除了
                if (userData == null) {
                    response.sendRedirect(contextPath + "/admin/user/loginPage");
                    return false;
                } else {
                    // 如果cookie存在user信息则存入到session中
                    httpSession.setAttribute("user", userData);
                    return true;
                }
            }
        } else {
            return true;
        }
    }
}
