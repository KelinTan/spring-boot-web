package com.kelin.springboot.controller;

import com.kelin.springboot.entity.Author;
import com.kelin.springboot.entity.RestResponse;
import com.kelin.springboot.redis.RedisClient;
import com.kelin.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Mr.tan
 * Date:  2017/09/05
 */

@RestController
@CrossOrigin
@RequestMapping("/welcome")
public class WelcomeController {

    private Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("hello")
    public RestResponse sayHello() {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(200);
        restResponse.setMsg("你好");
        logger.info("姓名："+ Author.name);
        logger.info("redis 测试:"+redisClient.get("subjectCacheBO`@~16377728"));
        logger.info(redisClient.hGet("dzh$sub`@~50655705","0"));
        return restResponse;
    }

    @RequestMapping("findUser")
    public RestResponse findUser() {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(200);
        restResponse.setMsg("你好");
        restResponse.setData(userService.findUser("7"));
        return restResponse;
    }
}
