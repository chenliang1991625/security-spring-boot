package com.example.security.securityspringboot.service;

import com.example.security.pojo.T_permission;
import com.example.security.pojo.T_user;
import com.example.security.securityspringboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //将来连接数据库根据账号查询用户信息
        T_user t_user = userDao.getUserByUsername(username);
        if(t_user == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<T_permission> permissionsList = userDao.findPermissionsByUserId(t_user.getId());
        List<String> permissions = new ArrayList<>();
        permissionsList.forEach(c -> permissions.add(c.getCode()));
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(t_user.getUsername()).password(t_user.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
