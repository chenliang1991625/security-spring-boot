package com.example.security.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;
//角色表
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
