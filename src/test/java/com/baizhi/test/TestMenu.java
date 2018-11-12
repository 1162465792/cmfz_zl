package com.baizhi.test;


import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestMenu {
    @Autowired
    private MenuService menuService;
    @Test
    public  void ss1(){
        List<Menu> allAdmin = menuService.findAll();
        for (Menu menu : allAdmin) {
            System.out.println(menu);
        }
    }

}

