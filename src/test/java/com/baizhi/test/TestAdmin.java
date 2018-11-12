package com.baizhi.test;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAdmin {
    @Autowired
    private AdminService adminService;
    @Test
    public  void ss1(){
        adminService.find("www","www");
    }
    @Test
    public void ss2(Admin admin){
        Admin admin1s=new Admin();
        admin1s.setId(admin.getId());
        admin1s.setName(admin.getName());
        admin1s.setPassword("eee");
        adminService.motify(admin1s);
    }

}

