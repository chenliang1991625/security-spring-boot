package com.example.security.securityspringboot.service;
import com.example.security.pojo.User;
import java.util.List;
/**
 * @Author: 陈亮
 * @Description:
 * @Time: 2019/9/19 星期四 00:32
 **/
public interface UserService {
    /*
     *根据条件字段uid获取记录数
     */
 Long getCountByUid(User user);
    /*
     *根据条件字段password获取记录数
     */
 Long getCountByPassword(User user);
    /*
     *根据条件字段mobile获取记录数
     */
 Long getCountByMobile(User user);
    /*
     *根据条件字段username获取记录数
     */
 Long getCountByUsername(User user);

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
    int insert(User user);
    /*
     *保存用户:精确保存想要的字段
     */
    int insertAllColumn(User user);
    /*
     * 根据条件(实体类属性值Uid)查询
     */
    List<User> selectListByUid(User user);
    /*
     * 根据条件(实体类属性值Password)查询
     */
    List<User> selectListByPassword(User user);
    /*
     * 根据条件(实体类属性值Mobile)查询
     */
    List<User> selectListByMobile(User user);
    /*
     * 根据条件(实体类属性值Username)查询
     */
    List<User> selectListByUsername(User user);

    /*
     * 根据主键uid查询
     */
    User findByUid(Integer uid);
    /*
     * 根据(实体类属性值uid)精确更新
     */
    int updateByUid(User user, Integer uid);
    /*
     * 根据(实体类属性值password)精确更新
     */
    int updateByPassword(User user, String password);
    /*
     * 根据(实体类属性值mobile)精确更新
     */
    int updateByMobile(User user, String mobile);
    /*
     * 根据(实体类属性值username)精确更新
     */
    int updateByUsername(User user, String username);

    /*
     * 根据(实体类属性值uid)更新
     */
    int updateAllColumnByUid(User user, Integer uid);
    /*
     * 根据(实体类属性值password)更新
     */
    int updateAllColumnByPassword(User user, String password);
    /*
     * 根据(实体类属性值mobile)更新
     */
    int updateAllColumnByMobile(User user, String mobile);
    /*
     * 根据(实体类属性值username)更新
     */
    int updateAllColumnByUsername(User user, String username);

    /*
     * 根据主键uid更新部分想要的字段
     */
    int updateByKey(User user);
    /*
     * 根据主键uid更新全部字段
     */
    int updateAllColumnByKey(User user);
    /*
     * 查出所有user信息
     */
    List<User> list();

}
