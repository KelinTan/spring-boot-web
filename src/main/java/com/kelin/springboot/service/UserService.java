package com.kelin.springboot.service;

import com.kelin.springboot.dao.UserDao;
import com.kelin.springboot.dao.UserMapper;
import com.kelin.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Author: Mr.tan
 * Date:  2017/09/05
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    public User findUser(String id) {
        return userDao.findUserById(id);
    }

    public User findUserByLoginName(String name) {
        return userDao.findUserByLoginName(name);
    }

    //测试事务
    @Transactional(readOnly = true)
    public void save(User user) {

        userMapper.save(user);
    }

    //测试事务回滚
    @Transactional(rollbackFor = IllegalArgumentException.class)
    public void saveRollback(User user) {
        userMapper.save(user);
        if ("test".equals(user.getName()))
            throw new IllegalArgumentException();
    }

    //测试带缓存
    @Cacheable(value = "user", key = "#id")
    public User findUserCache(String id) {
        User user = userDao.findUserById(id);
        System.out.println("数据库取数据。不走缓存");
        return user;
    }

}
