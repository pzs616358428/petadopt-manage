package com.ysy.petadopt.config;

import com.ysy.petadopt.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册管理员登录拦截器
        registry.addInterceptor(adminLoginInterceptor).
                addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/user/**");
    }
}
