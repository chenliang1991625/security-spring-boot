package com.example.mapper;
import com.example.security.pojo.User;
import com.example.security.pojo.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface UserMapper/* extends tk.mybatis.mapper.common.Mapper<User>, MySqlMapper<User>*/ {
    long countByExample(UserExample example);
    /*
     *根据条件(实体类属性值)删除
     */
    int deleteByExample(UserExample example);

    /*
     *根据主键uid删除
     */
    int deleteByPrimaryKey(Integer uid);

    /*
     *保存用户
     */
    int insert(User user);

    /*
     *更新用户:精确插入用户
     */
    int insertSelective(User user);

    /*
     * 根据条件(实体类属性值)查询
     */
    List<User> selectByExample(UserExample example);

    /*
     * 根据主键uid查询
     */
    User selectByPrimaryKey(Integer uid);

    /*
     * 根据(实体类属性值)精确更新：updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
     */
    int updateByExampleSelective(@Param("user") User user, @Param("example") UserExample example);

    /*
     * 根据(实体类属性值)更新：updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
     */
    int updateByExample(@Param("user") User user, @Param("example") UserExample example);

    /*
     * 根据主键uid更新部分想要的字段
     */
    int updateByPrimaryKeySelective(User user);

    /*
     * 根据主键uid更新全部字段
     */
    int updateByPrimaryKey(User user);
}
