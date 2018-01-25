package com.kelin.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过@component和ConfigurationProperties注解进行属性和bean的自动对应
 * 也可以通过@value注解 需手动设置每个属性
 *
 * Author: Mr.tan
 * Date:  2017/09/05
 */
@Component
@ConfigurationProperties(prefix = "author",locations = "classpath:author.properties")
public class Author {

    public static String name;
    public static Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
