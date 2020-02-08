package com.example.security.securityspringboot.service;
import com.example.security.pojo.T_user;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author: 陈亮
 * @Description:
 * @Time: 2019/9/19 星期四 00:32
 **/
public interface UserService {
    /*
     *根据条件字段uid获取记录数
     */
 Long getCountByUid(T_user user);
    /*
     *根据条件字段password获取记录数
     */
 Long getCountByPassword(T_user user);
    /*
     *根据条件字段mobile获取记录数
     */
 Long getCountByMobile(T_user user);
    /*
     *根据条件字段username获取记录数
     */
 Long getCountByUsername(T_user user);
    /*
     *根据uid删除
     */
    int deleteByUid(Integer uid);
    /*
     *根据password删除
     */
    int deleteByPassword(String password);
    /*
     *根据mobile删除
     */
    int deleteByMobile(String mobile);
    /*
     *根据username删除
     */
    int deleteByUsername(String username);
    /*
     *根据主键uid删除
     */
    int deleteByKey(Integer uid);
    /*
     *保存用户
     */
    int insert(T_user user);
    /*
     *保存用户:精确保存想要的字段
     */
    int insertAllColumn(T_user user);
    /*
     * 根据条件(实体类属性值Uid)查询
     */
    List<T_user> selectListByUid(T_user user);
    /*
     * 根据条件(实体类属性值Password)查询
     */
    List<T_user> selectListByPassword(T_user user);
    /*
     * 根据条件(实体类属性值Mobile)查询
     */
    List<T_user> selectListByMobile(T_user user);
    /*
     * 根据条件(实体类属性值Username)查询
     */
    List<T_user> selectListByUsername(T_user user);
   /*
    * 根据条件(实体类属性值Username2)查询
    */
   List<T_user> selectListByUsername(Object conditionColumn);
    /*
     * 根据主键uid查询
     */
    T_user findByUid(Integer uid);
    /*
     * 根据(实体类属性值uid)精确更新
     */
    int updateByUid(T_user user, Integer uid);
    /*
     * 根据(实体类属性值password)精确更新
     */
    int updateByPassword(T_user user, String password);
    /*
     * 根据(实体类属性值mobile)精确更新
     */
    int updateByMobile(T_user user, String mobile);
    /*
     * 根据(实体类属性值username)精确更新
     */
    int updateByUsername(T_user user, String username);
    /*
     * 根据(实体类属性值uid)更新
     */
    int updateAllColumnByUid(T_user user, Integer uid);
    /*
     * 根据(实体类属性值password)更新
     */
    int updateAllColumnByPassword(T_user user, String password);
    /*
     * 根据(实体类属性值mobile)更新
     */
    int updateAllColumnByMobile(T_user user, String mobile);
    /*
     * 根据(实体类属性值username)更新
     */
    int updateAllColumnByUsername(T_user user, String username);
    /*
     * 根据主键uid更新部分想要的字段
     */
    int updateByKey(T_user user);
    /*
     * 根据主键uid更新全部字段
     */
    int updateAllColumnByKey(T_user user);
    /*
     * 查出所有user信息
     */
    List<T_user> list();
    /*
     * 条件+分页查询
     */
   Page<T_user> findPage(int page, int size);
   /*
    * 分页查询
    */
   Page<T_user> findPage(Map<String,Object> searchMap, int page, int size);
}
