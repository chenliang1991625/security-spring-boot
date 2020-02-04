package com.example.security.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain =true)
public class T_role_permission {
    private String role_id ;
    private String permission_id;
}
