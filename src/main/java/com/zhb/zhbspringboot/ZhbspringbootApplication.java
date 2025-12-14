package com.zhb.zhbspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.mybatis.spring.annotation.MapperScan;
@EnableScheduling
@SpringBootApplication
@MapperScan("com.zhb.zhbspringboot.ecology.mapper")
public class ZhbspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhbspringbootApplication.class, args);
    }

}
