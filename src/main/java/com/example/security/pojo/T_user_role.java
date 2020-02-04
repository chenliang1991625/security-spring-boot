package com.example.security.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;
//用户和角色对应表
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
