package com.baizhi.test;


import com.baizhi.entity.Coures;
import com.baizhi.service.CouresService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestCoures {
    @Autowired
    private CouresService couresService;
    @Test
    public void ss2(){
        Coures coures = new Coures();
        coures.setMarking("大悲咒");
        coures.setTitle("大悲咒");
        couresService.add(coures);
    }

}

