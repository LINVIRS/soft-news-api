package com.soft1851.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCrypt;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: sada
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 14:52:25 
 * @Version: V1.0
 **/
@SpringBootApplication()
@ComponentScan(basePackages = {"com.soft1851","org.n3r.idworker"})
@MapperScan(basePackages = "com.soft1851.admin.mapper")
public class AdminApplication {
    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
    }
}