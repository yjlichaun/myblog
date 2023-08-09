package com.muyi.blog.my.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 历川
 * @version 1.0
 * @description 项目启动类
 * @date 2023/8/9 9:50
 */

@MapperScan("com.muyi.blog.my.core.mapper")
@SpringBootApplication
public class MyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class, args);
    }
}
