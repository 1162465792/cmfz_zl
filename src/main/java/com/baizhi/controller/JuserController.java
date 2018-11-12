package com.baizhi.controller;

import com.baizhi.entity.Juesr;
import com.baizhi.service.JuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/juser")
public class JuserController {
    @Autowired
    private JuserService juserService;
    @RequestMapping("/findAll")
    public String findAll(String name, String pwd){
        juserService.find(name,pwd);
        return "indexss";
    }
    @RequestMapping("/addJuser")
    public String addJuser(Juesr juesr){
        juserService.add(juesr);
        return "indexss";
    }
    @RequestMapping("/updateJuser")
    public String updateJuser(Juesr juesr){
        juserService.motify(juesr);
        return "indexss";
    }
}
