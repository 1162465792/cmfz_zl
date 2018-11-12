package com.baizhi.test;


import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBanner {
    @Autowired
    private BannerService bannerService;
    @Test
    public  void ss1(){
        bannerService.findAll();
    }
    @Test
    public  void ss2(){
        Banner b = new Banner();
        b.setTitle("2");
        b.setImgPath("2");
        b.setDescription("2");
        b.setStatus("2");
        b.setDate(new Date());
        bannerService.add(b);
    }
    @Test
    public  void ss3(){
        bannerService.remove("sssss");
    }
    @Test
    public  void ss4(){
        Banner b = new Banner();
        b.setId("241ec594-f43e-4bfb-91ad-1abdfe3b924d");
        b.setTitle("2");
        b.setImgPath("3");
        b.setDescription("2");
        b.setStatus("2");
        b.setDate(new Date());
        bannerService.motify(b);
    }
}

