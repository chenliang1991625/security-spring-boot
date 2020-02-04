package com.example.security.securityspringboot;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
//@EnableWebSecurity
@MapperScan(basePackages = {"com.example.mapper"})
@SpringBootApplication(scanBasePackages = {"com.example.security"})//一定要注意com.example.security.config下的配置类也要扫描到
public class SecuritySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySpringBootApplication.class, args);
    }
}
