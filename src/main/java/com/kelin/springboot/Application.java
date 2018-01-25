package com.kelin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring boot入口
 * 默认扫描application所在的包和其子路径
 * Author: Mr.tan
 * Date:  2017/09/05
 */

@SpringBootApplication
@EnableTransactionManagement //开启事务支持
@EnableCaching//开启缓存支持
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
