package com.example.security.pojo.securityPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain =true)
public class T_permission {
   private String id ;
   private String code ;
   private String descriptio;
   private String  ur;
}
