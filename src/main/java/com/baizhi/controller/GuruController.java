package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @RequestMapping("/findAllGuru")
    public @ResponseBody List<Guru> findAllGuru(){
        List<Guru> alls = guruService.findAll();
        return alls;
    }
    @RequestMapping("/addGuru")
    public Map<String,Object> addGuru(Guru guru,MultipartFile aa,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            String p = request.getSession().getServletContext().getRealPath("back/banner");
            aa.transferTo(new File(p,aa.getOriginalFilename()));
            guru.setHeadPic("/back/banner/"+aa.getOriginalFilename());
            guruService.add(guru);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/removeGuru")
    public @ResponseBody Map<String,Object> removeGuru(String id){
        Map<String,Object> maps=new HashMap<>();
        try {
            guruService.remove(id);
            maps.put("success",true);
        }catch (Exception e){
            maps.put("success",false);
        }
        return maps;
    }
    @RequestMapping("/motisfyGuru")
    public @ResponseBody Map<String,Object> motisfyGuru(Guru guru){
        Map<String,Object> maps=new HashMap<>();
        try {
            guruService.motify(guru);
            maps.put("success",true);
        }catch (Exception e){
            maps.put("success",false);
        }
        return maps;
    }
}
