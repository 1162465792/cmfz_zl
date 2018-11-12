package com.baizhi.test;


import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestGuru {
    @Autowired
    private GuruService guruService;
    @Test
    public  void ss1(){
        guruService.findAll();
    }
    @Test
    public  void ss2(){
        Guru guru = new Guru();
        guru.setHeadPic("s");
        guru.setName("s");
        guru.setStatus("s");
        guru.setSxs("s");
        guruService.add(guru);
    }
    @Test
    public  void ss3(){
        guruService.remove("sssss");
    }
    @Test
    public  void ss4(){
        Guru guru = new Guru();
        guruService.motify(guru);
    }
}

