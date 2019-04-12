package com.multipart.multipartdatasource.usertest;

import com.multipart.multipartdatasource.model.User;
import com.multipart.multipartdatasource.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testWrite(){
        User user = new User();
        user.setId(2L);
        user.setUser_name("master");
        user.setEmail("master@qq.com");
        userService.insert(user);
    }


    @Test
    public void testRead(){
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println("=======username========"+user.getUser_name());

        }

    }
}
