package com.example.security.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Table;
import java.io.Serializable;
//用户表
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_user")
public class T_user implements Serializable {
    private Integer id;
    private String username;
    private String password;
//    private String fullname;
    private String mobile;
}
