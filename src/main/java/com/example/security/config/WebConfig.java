package com.example.security.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //默认Url根路径跳转到/login,此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");//默认根路径/跳转到/login路径
        registry.addViewController("/login").setViewName("login");// 访问/login路径进入login.jsp登录页面
    }
}

