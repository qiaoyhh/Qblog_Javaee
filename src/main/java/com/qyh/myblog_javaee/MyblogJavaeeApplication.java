package com.qyh.myblog_javaee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启缓存功能
@MapperScan("com.qyh.myblog_javaee.mapper")
public class MyblogJavaeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogJavaeeApplication.class, args);
    }

}
