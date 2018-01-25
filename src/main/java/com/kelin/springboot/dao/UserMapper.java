package com.kelin.springboot.dao;

import com.kelin.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Mr.tan
 * Date:  2018/01/18 19:24
 * Description: jpa auto curd
 */
@Repository
public interface UserMapper extends JpaRepository<User, Integer> {

}
