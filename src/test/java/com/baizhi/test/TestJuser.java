package com.baizhi.test;


import com.baizhi.entity.Juesr;
import com.baizhi.service.JuserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestJuser {
    @Autowired
    private JuserService juserService;
    @Test
    public void ss2(){
        Juesr juesr=new Juesr();
        juesr.setPwd("www");
        juesr.setName("www");
        juesr.setTimeDate(new Date());
        juserService.add(juesr);
    }

}

