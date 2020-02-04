package com.example.security.securityspringboot.service.impl;

import com.example.mapper.UserMapper;
import com.example.security.pojo.T_user;
import com.example.security.pojo.UserExample;
import com.example.security.securityspringboot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @Author: 陈亮
 * @Description:
 * @Time: 2019/9/19 星期四 00:33
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExample userExample;
    /*
     *根据条件字段id获取记录数
     */
    @Override
    public Long getCountByUid(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo("陈亮");
        Integer id = Math.toIntExact(user.getId());
        if (id!= null) {
            criteria.andUidEqualTo(id);
        }
        Long count = userMapper.countByExample(example);
        return count;
    }
    /*
     *根据条件字段password获取记录数
     */
    @Override
    public Long getCountByPassword(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo("陈亮");
        String password = user.getPassword();
        if (password!= null) {
            criteria.andPasswordEqualTo(password);
        }
        Long count = userMapper.countByExample(example);
        return count;
    }
    /*
     *根据条件字段mobile获取记录数
     */
    @Override
    public Long getCountByMobile(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo("陈亮");
        String mobile = user.getMobile();
        if (mobile!= null) {
            criteria.andMobileEqualTo(mobile);
        }
        Long count = userMapper.countByExample(example);
        return count;
    }
    /*
     *根据条件字段username获取记录数
     */
    @Override
    public Long getCountByUsername(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo("陈亮");
        String username = user.getUsername();
        if (username!= null) {
            criteria.andUsernameEqualTo(username);
        }
        Long count = userMapper.countByExample(example);
        return count;
    }
    /*
     *根据id删除
     */
    public int deleteByUid(Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(id);
        return userMapper.deleteByExample(example);
//相当于：delete from user where id='id'
    }
    /*
     *根据password删除
     */
    public int deleteByPassword(String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(password);
        return userMapper.deleteByExample(example);
//相当于：delete from user where password='password'
    }
    /*
     *根据mobile删除
     */
    public int deleteByMobile(String mobile) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        return userMapper.deleteByExample(example);
//相当于：delete from user where mobile='mobile'
    }
    /*
     *根据username删除
     */
    public int deleteByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.deleteByExample(example);
//相当于：delete from user where username='username'
    }
    /*
     *根据主键id删除
     */
    public int deleteByKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    /*
     *保存用户
     */
    public int insert(T_user user) {
        T_user user1 = new T_user();
        user1.setId(user.getId());
user1.setPassword(user.getPassword());
user1.setMobile(user.getMobile());
user1.setUsername(user.getUsername());

//相当于：insert into user(ID,username,password,email) values ('dsfgsdfgdsfgds','admin','admin','wyw@126.com');
        return userMapper.insert(user1);
    }
    /*
     *保存用户:精确保存想的字段
     */
    public int insertAllColumn(T_user user) {
        T_user user1 = new T_user();
        user1.setId(user.getId());
user1.setPassword(user.getPassword());
user1.setMobile(user.getMobile());
user1.setUsername(user.getUsername());
        return userMapper.insertSelective(user1);
        //相当于：update user set password='wyw' where username='admin'
    }
     /*
      *
      */
    public List<T_user> selectListByUid(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Math.toIntExact(user.getId()));
        criteria.andUidIsNull();//id为空的也查出来
        example.setOrderByClause("id asc");//按id升序排列
// example.setOrderByClause("id asc,id desc");
//相当于：select * from user where id = 'wyw' and  id is null order by id asc,email desc
        return userMapper.selectByExample(example);
    }
     /*
      *
      */
    public List<T_user> selectListByPassword(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andPasswordIsNull();//password为空的也查出来
        example.setOrderByClause("id asc");//按id升序排列
// example.setOrderByClause("password asc,id desc");
//相当于：select * from user where password = 'wyw' and  password is null order by password asc,email desc
        return userMapper.selectByExample(example);
    }
     /*
      *
      */
    public List<T_user> selectListByMobile(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(user.getMobile());
        criteria.andMobileIsNull();//mobile为空的也查出来
        example.setOrderByClause("id asc");//按id升序排列
// example.setOrderByClause("mobile asc,id desc");
//相当于：select * from user where mobile = 'wyw' and  mobile is null order by mobile asc,email desc
        return userMapper.selectByExample(example);
    }
     /*
      *
      */
    public List<T_user> selectListByUsername(T_user user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andUsernameIsNull();//username为空的也查出来
        example.setOrderByClause("id asc");//按id升序排列
// example.setOrderByClause("username asc,id desc");
//相当于：select * from user where username = 'wyw' and  username is null order by username asc,email desc
        return userMapper.selectByExample(example);
    }
    /*
     * 根据主键id查询
     */
    public T_user findByUid(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    /*
     * 根据(实体类属性值id)精确更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateByUid(T_user user, Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(id);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByExampleSelective(user1, example);
        //相当于：update user set password='wyw' where id='id'
    }
     /*
     * 根据(实体类属性值id)更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateAllColumnByUid(T_user user, Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(id);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByExample(user1, example);
        //相当于：update user set password='wyw' where id='id'
    }
    /*
     * 根据(实体类属性值password)精确更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateByPassword(T_user user, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(password);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());

        return userMapper.updateByExampleSelective(user1, example);
        //相当于：update user set password='wyw' where password='password'
    }
     /*
     * 根据(实体类属性值password)更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateAllColumnByPassword(T_user user, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(password);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());

        return userMapper.updateByExample(user1, example);
        //相当于：update user set password='wyw' where password='password'
    }
    /*
     * 根据(实体类属性值mobile)精确更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateByMobile(T_user user, String mobile) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByExampleSelective(user1, example);
        //相当于：update user set password='wyw' where mobile='mobile'
    }
     /*
     * 根据(实体类属性值mobile)更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateAllColumnByMobile(T_user user, String mobile) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());

        return userMapper.updateByExample(user1, example);
        //相当于：update user set password='wyw' where mobile='mobile'
    }
    /*
     * 根据(实体类属性值username)精确更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateByUsername(T_user user, String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByExampleSelective(user1, example);
        //相当于：update user set password='wyw' where username='username'
    }
     /*
     * 根据(实体类属性值username)更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateAllColumnByUsername(T_user user, String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        T_user user1 = new T_user();
                    user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());

        return userMapper.updateByExample(user1, example);
        //相当于：update user set password='wyw' where username='username'
    }
/*
 * 根据主键id更新部分想要的字段
 */
public int updateByKey(T_user user) {
        T_user user1 = new T_user();
            user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByPrimaryKey(user1);
        //相当于：update user set password='wyw' where id='dsfgsdfgdsfgds'
        }
    /*
    * 根据主键id更新全部字段
    */
    public int updateAllColumnByKey(T_user user) {
        T_user user1 = new T_user();
            user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByPrimaryKey(user1);
//相当于：update user set password='wyw' where id='dsfgsdfgdsfgds'
        }
    /*
     * 查询所有：按条件查询,条件设为null就是查询所有
     */
    @Override
    public List<T_user> list() {
        return userMapper.selectByExample(null);
    }
    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Page<T_user> findPage( int page, int size){
        PageHelper.startPage(page,size);
        return (Page<T_user>)userMapper.selectAll();
    }
    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public Page<T_user> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<T_user>)userMapper.selectByExample(example);
    }
    /**
     * 构建Example查询条件对象2
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String,Object> searchMap){
        Example example=new Example(T_user.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // username
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
            }
            // password
            if(searchMap.get("password")!=null && !"".equals(searchMap.get("password"))){
                criteria.andLike("password","%"+searchMap.get("password")+"%");
            }


        }
        return example;
    }
    /*
     * 创建Example条件查询对象1
     */
    private UserExample.Criteria createExample1(T_user user) {
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user != null) {
                       Integer id = Math.toIntExact(user.getId());
            // id
            if (id != null && !"".equals(id+"")) {
                criteria.andUidEqualTo(id);
            }
           String password = user.getPassword();
            // password
            if (password != null && !"".equals(password+"")) {
                criteria.andPasswordEqualTo(password);
            }
           String mobile = user.getMobile();
            // mobile
            if (mobile != null && !"".equals(mobile+"")) {
                criteria.andMobileEqualTo(mobile);
            }
           String username = user.getUsername();
            // username
            if (username != null && !"".equals(username+"")) {
                criteria.andUsernameEqualTo(username);
            }
        }
        return criteria;
    }
}
