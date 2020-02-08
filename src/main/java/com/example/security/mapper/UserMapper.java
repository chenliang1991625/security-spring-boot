package com.example.security.mapper;
import com.example.security.pojo.T_user;
import com.example.security.pojo.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.MySqlMapper;
import java.util.List;
//@Mapper
@Repository
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<T_user>,MySqlMapper<T_user> {
    long countByExample(UserExample example);
    /*
     *根据条件(实体类属性值)删除
     */
    int deleteByExample(UserExample example);

    /*
     *根据主键id删除
     */
    int deleteByPrimaryKey(Integer id);

    /*
     *保存用户
     */
    int insert(T_user user);

    /*
     *更新用户:精确插入用户
     */
    int insertSelective(T_user user);

    /*
     * 根据条件(实体类属性值)查询
     */
    List<T_user> selectByExample(UserExample example);

    /*
     * 根据主键id查询
     */
    T_user selectByPrimaryKey(Integer id);

    /*
     * 根据(实体类属性值)精确更新：updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
     */
    int updateByExampleSelective(@Param("user") T_user user, @Param("example") UserExample example);

    /*
     * 根据(实体类属性值)更新：updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
     */
    int updateByExample(@Param("user") T_user user, @Param("example") UserExample example);

    /*
     * 根据主键id更新部分想要的字段
     */
    int updateByPrimaryKeySelective(T_user user);

    /*
     * 根据主键id更新全部字段
     */
    int updateByPrimaryKey(T_user user);
}
