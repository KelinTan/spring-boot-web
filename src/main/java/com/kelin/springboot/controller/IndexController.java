package com.kelin.springboot.controller;

import com.kelin.springboot.dao.UserMapper;
import com.kelin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Mr.tan
 * Date:  2017/09/05
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("home")
    public String toIndex(Model model) {

        //mybatis 查询
        model.addAttribute("user", userService.findUser("7"));

        //测试 jpa 查询
        System.out.println("users" + userMapper.findAll());
        return "index";
    }

}
