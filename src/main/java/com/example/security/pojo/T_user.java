package com.example.security.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/*
* //5. 创建t_user表
        CREATE TABLE `t_user` (
                             `id` bigint(20) NOT NULL COMMENT '用户id',
                             `username` varchar(64) NOT NULL,
                             `password` varchar(64) NOT NULL,
                             `fullname` varchar(255) NOT NULL COMMENT '用户姓名',
                              mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
                                PRIMARY KEY(`id`) USING BTREE )ENGINE = InnoDB DEFAULT CHARSET = utf8
                                ROW_FORMAT = DYNAMIC;
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class T_user {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
