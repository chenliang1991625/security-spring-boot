package com.example.security.securityspringboot.service.impl;
import com.example.security.pojo.User;
import com.example.security.pojo.UserExample;
import com.example.mapper.UserMapper;
import com.example.security.securityspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
     *根据条件字段uid获取记录数
     */
    @Override
    public Long getCountByUid(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo("陈亮");
        Integer uid = user.getUid();
        if (uid!= null) {
            criteria.andUidEqualTo(uid);
        }
        Long count = userMapper.countByExample(example);
        return count;
    }
    /*
     *根据条件字段password获取记录数
     */
    @Override
    public Long getCountByPassword(User user) {
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
    public Long getCountByMobile(User user) {
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
    public Long getCountByUsername(User user) {
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
     *根据uid删除
     */
    public int deleteByUid(Integer uid) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        return userMapper.deleteByExample(example);
//相当于：delete from user where uid='uid'
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
     *根据主键uid删除
     */
    public int deleteByKey(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }
    /*
     *保存用户
     */
    public int insert(User user) {
        User user1 = new User();
        user1.setUid(user.getUid());
user1.setPassword(user.getPassword());
user1.setMobile(user.getMobile());
user1.setUsername(user.getUsername());

//相当于：insert into user(ID,username,password,email) values ('dsfgsdfgdsfgds','admin','admin','wyw@126.com');
        return userMapper.insert(user1);
    }
    /*
     *保存用户:精确保存想的字段
     */
    public int insertAllColumn(User user) {
        User user1 = new User();
        user1.setUid(user.getUid());
user1.setPassword(user.getPassword());
user1.setMobile(user.getMobile());
user1.setUsername(user.getUsername());
        return userMapper.insertSelective(user1);
        //相当于：update user set password='wyw' where username='admin'
    }
     /*
      *
      */
    public List<User> selectListByUid(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getUid());
        criteria.andUidIsNull();//uid为空的也查出来
        example.setOrderByClause("uid asc");//按uid升序排列
// example.setOrderByClause("uid asc,uid desc");
//相当于：select * from user where uid = 'wyw' and  uid is null order by uid asc,email desc
        return userMapper.selectByExample(example);
    }
     /*
      *
      */
    public List<User> selectListByPassword(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andPasswordIsNull();//password为空的也查出来
        example.setOrderByClause("uid asc");//按uid升序排列
// example.setOrderByClause("password asc,uid desc");
//相当于：select * from user where password = 'wyw' and  password is null order by password asc,email desc
        return userMapper.selectByExample(example);
    }
     /*
      *
      */
    public List<User> selectListByMobile(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(user.getMobile());
        criteria.andMobileIsNull();//mobile为空的也查出来
        example.setOrderByClause("uid asc");//按uid升序排列
// example.setOrderByClause("mobile asc,uid desc");
//相当于：select * from user where mobile = 'wyw' and  mobile is null order by mobile asc,email desc
        return userMapper.selectByExample(example);
    }
     /*
      *
      */
    public List<User> selectListByUsername(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andUsernameIsNull();//username为空的也查出来
        example.setOrderByClause("uid asc");//按uid升序排列
// example.setOrderByClause("username asc,uid desc");
//相当于：select * from user where username = 'wyw' and  username is null order by username asc,email desc
        return userMapper.selectByExample(example);
    }
    /*
     * 根据主键uid查询
     */
    public User findByUid(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
    /*
     * 根据(实体类属性值uid)精确更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateByUid(User user, Integer uid) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        User user1 = new User();
                    user1.setUid(user.getUid());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByExampleSelective(user1, example);
        //相当于：update user set password='wyw' where uid='uid'
    }
     /*
     * 根据(实体类属性值uid)更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateAllColumnByUid(User user, Integer uid) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        User user1 = new User();
                    user1.setUid(user.getUid());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByExample(user1, example);
        //相当于：update user set password='wyw' where uid='uid'
    }
    /*
     * 根据(实体类属性值password)精确更新
     * updateAllColumn()更新所有的字段，包括字段为null的也更新，建议使用 update()更新想更新的字段
     */
    public int updateByPassword(User user, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(password);
        User user1 = new User();
                    user1.setUid(user.getUid());
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
    public int updateAllColumnByPassword(User user, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(password);
        User user1 = new User();
                    user1.setUid(user.getUid());
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
    public int updateByMobile(User user, String mobile) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        User user1 = new User();
                    user1.setUid(user.getUid());
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
    public int updateAllColumnByMobile(User user, String mobile) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        User user1 = new User();
                    user1.setUid(user.getUid());
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
    public int updateByUsername(User user, String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        User user1 = new User();
                    user1.setUid(user.getUid());
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
    public int updateAllColumnByUsername(User user, String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        User user1 = new User();
                    user1.setUid(user.getUid());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());

        return userMapper.updateByExample(user1, example);
        //相当于：update user set password='wyw' where username='username'
    }
/*
 * 根据主键uid更新部分想要的字段
 */
public int updateByKey(User user) {
        User user1 = new User();
            user1.setUid(user.getUid());
            user1.setPassword(user.getPassword());
            user1.setMobile(user.getMobile());
            user1.setUsername(user.getUsername());
        return userMapper.updateByPrimaryKey(user1);
        //相当于：update user set password='wyw' where id='dsfgsdfgdsfgds'
        }
/*
 * 根据主键uid更新全部字段
 */
public int updateAllColumnByKey(User user) {
        User user1 = new User();
            user1.setUid(user.getUid());
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
    public List<User> list() {
        return userMapper.selectByExample(null);
    }
    /*
     * 创建Example条件
     */
    private UserExample.Criteria createExample(User user) {
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user != null) {
                       Integer uid = user.getUid();
            // uid
            if (uid != null && !"".equals(uid+"")) {
                criteria.andUidEqualTo(uid);
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
