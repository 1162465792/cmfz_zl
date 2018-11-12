package com.baizhi.controller;

import com.baizhi.entity.Coures;
import com.baizhi.service.CouresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/coures")
public class CouresController {
    @Autowired
    private CouresService couresService;
    @RequestMapping("/findCoures")
    public @ResponseBody List<Coures> findCoures(){
        List<Coures> all = couresService.findAll();
        return all;
    }
    @RequestMapping("addCoures")
    public  @ResponseBody Map<String,Object> addCoures(Coures coures){
        Map<String,Object> map= new HashMap<>();
        try {
            couresService.add(coures);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }
    @RequestMapping("/removeCoures")
    public  @ResponseBody Map<String,Object> removeCoures(String id){
        Map<String,Object> map= new HashMap<>();
        try {
            couresService.remove(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }
}
