package com.example.security.pojo.securityPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;
/*//2.用户和角色中间表
CREATE TABLE t_user_role (
        user_id varchar(32) NOT NULL
        role_id varchar(32) NOT NULL
        create_time datetime DEFAULT NULL
        creator varchar(255) DEFAULT NULL
        PRIMARY KEY(user_id role_id) )ENGINE = InnoDB
        DEFAULT CHARSET = utf8 ;
        insert into t_user_role (user_id role_id create_time creator)
        values('1' '1' NULL NULL);*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class T_user_role {
   private String user_id;
   private String role_id;
   private Date  create_time ;
   private String  creator;
}
