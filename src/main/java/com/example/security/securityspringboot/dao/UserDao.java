package com.example.security.securityspringboot.dao;
import com.example.security.pojo.T_permission;
import com.example.security.pojo.T_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author Administrator
 * @version 1.0
 **/
@Repository
public class UserDao {
    @Autowired//用springJdbcTemplate查询数据库,不行换mabatis
    private JdbcTemplate jdbcTemplate;
    //根据账号查询用户信息
    public T_user getUserByUsername(String username) {
        String sql = "select id,username,password,fullname,mobile from t_user where username = ?";
        //连接数据库查询用户
        List<T_user> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(T_user.class));
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
//根据账号查询用户信息
/*
public T_user getUserByUsername(final String username) {
    String sql = "select * from t_user where username = ?";
    //连接数据库查询用户
    final T_user user = new T_user();
    //将结果集数据行中的数据抽取到forum对象中
    jdbcTemplate.query(sql, new Object[]{username}, new RowCallbackHandler() {
        public void processRow(ResultSet rs) throws SQLException {
            user.setId(rs.getLong("id"));
            user.setUsername(username);
            user.setPassword(rs.getString("password"));
            user.setFullname(rs.getString("fullname"));
            user.setMobile(rs.getString("mobile"));
        }
    });
    return user;
*/
    //根据用户id查询用户权限,此处用子查询,会拖慢系统性能,可优化
    public List<T_permission> findPermissionsByUserId(Long userId) {
        String sql = "SELECT * FROM t_permission WHERE id IN(\n" +
                "\n" +
                "SELECT permission_id FROM t_role_permission WHERE role_id IN(\n" +
                "  SELECT role_id FROM t_user_role WHERE user_id = ? \n" +
                ")\n" +
                ")\n";
        List<T_permission> permissionsList = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(T_permission.class));
      /*  List<String> permissions = new ArrayList<>();
        permissionsList.forEach(c -> permissions.add(c.getCode()));*/
        return permissionsList;
    }
}
