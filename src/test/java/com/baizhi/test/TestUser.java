package com.baizhi.test;


import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {
    @Autowired
    private UserService userService;
    @Test
    public  void ss1(){
        userService.findAll();
    }
    @Test
    public  void ss2(){
        User b = new User();
        userService.add(b);
    }
    @Test
    public  void ss3(){
        userService.remove("sssss");
    }
    @Test
    public  void ss4(){
        User b = new User();
        userService.motify(b);
    }
}

