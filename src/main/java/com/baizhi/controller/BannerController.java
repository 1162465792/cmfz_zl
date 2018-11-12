package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/findAllBanner")
    public @ResponseBody List<Banner> findAllBanner(){
        List<Banner> allAdmin = bannerService.findAll();
        return allAdmin;
    }
    @RequestMapping("/insertBanner")
    public @ResponseBody Map<String,Object> insertBanner(Banner banner,MultipartFile aas,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            String realPaths = request.getSession().getServletContext().getRealPath("back/banner");
            aas.transferTo(new File(realPaths,aas.getOriginalFilename()));
            banner.setImgPath("/back/banner/"+aas.getOriginalFilename());
            bannerService.add(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/deleteBanner")
    public @ResponseBody Map<String,Object> deleteBanner(String id){
        Map<String,Object> map = new HashMap<>();
        try {
            bannerService.remove(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/updateBanner")
    public @ResponseBody Map<String,Object> updateBanner(Banner banner,MultipartFile aas,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            String realPaths = request.getSession().getServletContext().getRealPath("back/banner");
            aas.transferTo(new File(realPaths,aas.getOriginalFilename()));
            banner.setImgPath("/back/banner/"+aas.getOriginalFilename());
            bannerService.motify(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/findOneBanner")
    public @ResponseBody Banner findOneBanner(String id){
        Banner one = bannerService.findOne(id);
        return one;
    }
}
