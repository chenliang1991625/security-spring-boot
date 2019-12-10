package com.example.security.securityspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "LoginController|一个用来测试swagger注解的控制器")//swagger在类上注解
public class LoginController {
    @PostMapping( value = "/login-success",produces = {"text/plain;charset=UTF-8"})//如果用swagger动态生成文档API,如果使用RequestMapping要指定请求方法，不然swagger会出现所有请求方法(该方法get/post/delete/put..请求测试都会出现)的test API
    @ApiOperation(value="测试登录成功与否的方法", notes="test: 简单测试")//swagger在方法上注解,RequestMapping
//    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")//swagger对方法参数注解
    public String loginSuccess(){

        //提示具体用户名称登录成功
        return getUsername()+" 登录成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限才可以访问
    @ApiOperation(value="访问/r/r1", notes="测试有没有访问资源1的权限")
    public String r1(){
        return getUsername()+" 访问资源1";
    }

    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")//拥有p2权限才可以访问
    @ApiOperation(value="访问/r/r2", notes="测试有没有访问资源2的权限")
    public String r2(){
        return getUsername()+" 访问资源2";
    }

    //获取当前用户信息
    private String getUsername(){
        String username = null;
        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principal = authentication.getPrincipal();
        if(principal == null){
            username = "匿名";
        }
        if(principal instanceof org.springframework.security.core.userdetails.UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        }else{
            username = principal.toString();
        }
        return username;
    }
}
