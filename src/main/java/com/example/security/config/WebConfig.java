package com.example.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    //默认Url根路径跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login-view");//默认根路径跳转到springSecurity的Controller(/login-view)进行登录认证处理
        registry.addViewController("/login-view").setViewName("login");//认证成功后进入springSecurity的login.jsp登录页面展示
    }
}

