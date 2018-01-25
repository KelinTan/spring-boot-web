package com.kelin.springboot.dao;

import com.kelin.springboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Author: Mr.tan
 * Date:  2017/09/05
 */
@Repository
public interface UserDao {
     User findUserById(String id);

     User findUserByLoginName(String name);
}
