package com.example.security.securityspringboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableWebSecurity
@SpringBootApplication(scanBasePackages = {"com.example.security"})//一定要注意com.example.security.config下的配置类也要扫描到
public class SecuritySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySpringBootApplication.class, args);
    }
}
