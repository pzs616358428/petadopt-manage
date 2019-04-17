package com.ysy.petadopt.interceptor;

import com.ysy.petadopt.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截器类
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userInfo");
        // 如果user为null说明未登录
        if (user == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/admin/user/loginPage");
            return false;
        } else {
            return true;
        }
    }
}
