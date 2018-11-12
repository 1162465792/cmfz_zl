package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @RequestMapping("/findAll")
    public String findAll(String name, String password,String enCode,HttpSession session){
        Object validationCode = session.getAttribute("validationCode");
        Admin admin = adminService.find(name, password);

        if(validationCode.equals(enCode)){
            if (admin!=null){
                session.setAttribute("admins",admin);
                return "redirect:/back/main/main.jsp";
            }else {
                return  "redirect:/back/login.jsp";
            }
        }else {
            return  "redirect:/back/login.jsp";
        }
    }
    @RequestMapping("/updateAdmin")
    public @ResponseBody
    Map<String,Object> updateAdmin(Admin admin,String password,String pwd) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (password.equals(pwd)) {
            try {
                adminService.motify(admin);
                result.put("success",true);
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success",false);
                result.put("message",e.getMessage());
            }
        }else {
            result.put("message","两次密码不一样！！！");
        }
            return result;
    }
    @RequestMapping("/remveAdmin")
    public String remveAdmin(HttpSession session){
        session.removeAttribute("admins");
        return "redirect:/back/login.jsp";
    }
}
