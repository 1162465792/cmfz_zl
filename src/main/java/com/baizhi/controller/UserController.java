package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAllUser")
    public @ResponseBody Map<String,Object> findAllUser(Integer page, Integer rows){
        Map<String,Object> map=new HashMap<>();
        List<User> byPage = userService.findByPage(page,rows);
        Long totals = userService.findTotals();
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }
    @RequestMapping("/findOneUser")
    public @ResponseBody User findOneUser(String id){
        User one = userService.findOne(id);
        return one;
    }
    @RequestMapping("/updateUser")
    public Map<String,Object> updateUser(User user){
        Map<String,Object> map=new HashMap<>();
        try {
            userService.motify(user);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
