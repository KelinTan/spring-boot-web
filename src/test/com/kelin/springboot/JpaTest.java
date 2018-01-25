package com.kelin.springboot;

import com.kelin.springboot.dao.UserMapper;
import com.kelin.springboot.entity.User;
import com.kelin.springboot.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Author: Mr.tan
 * Date:  2018/01/18 20:23
 * Description:
 */
public class JpaTest extends SpringBootBaseTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {


        System.out.println(userMapper.findAll());

    }

    @Test
    public void testGetOne() {
        System.out.println(userMapper.findOne(7));
    }

    @Test
    public void testSort() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        System.out.println(userMapper.findAll(sort));
    }

    @Test
    public void testPage() {
        Pageable pageable = new PageRequest(1, 2);
        System.out.println(userMapper.findAll(pageable));
    }

    @Test
    public void testReadOnly() {

        User user = new User();
        user.setName("jiangshanyigai");
        userService.save(user);
    }

    @Test
    public void testRollback() {

        User user = new User();
        user.setName("test");
        userService.saveRollback(user);
    }

    @Test
    public void testCache() {

        for (int i = 0 ; i < 5; i++) {
            System.out.println(userService.findUserCache("7"));
        }
    }
}
