package com.example.security.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/*//1.角色表
        CREATE TABLE t_role (
        id varchar(32) NOT NULL,
        role_name varchar(255) DEFAULT NULL,
        description varchar(255) DEFAULT NULL,
        create_time datetime DEFAULT NULL,
        update_time datetime DEFAULT NULL,
        status char(1) NOT NULL, PRIMARY KEY(id),
         UNIQUE KEY unique_role_name (role_name) )ENGINE = InnoDB,
        DEFAULT CHARSET = utf8 ;
        insert into t_role (id, role_name, description, create_time, update_time, status)*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class T_role {
      private String id ;
      private String role_name ;
      private String description;
      private Date create_time ;
      private Date update_time ;
      private String status;
}
