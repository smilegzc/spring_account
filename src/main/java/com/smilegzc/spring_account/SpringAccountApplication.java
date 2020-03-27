package com.smilegzc.spring_account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.smilegzc.spring_account.mapper")
@SpringBootApplication
public class SpringAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAccountApplication.class, args);
    }

}
