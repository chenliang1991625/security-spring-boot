package com.example.security.pojo.viewPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * @author Administrator
 * @version 1.0
 * 前端展示封装的pojo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain =true)
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
