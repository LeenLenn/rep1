package com.xzm.springbootjpa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//【启动文件】
@SpringBootApplication
@MapperScan("com.xzm.springbootjpa.repository")
public class Appcation {
    public static void main(String[] args) {
        SpringApplication.run(Appcation.class, args);
    }
}
