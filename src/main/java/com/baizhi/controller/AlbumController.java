package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/findOne")
    public @ResponseBody Album findOne(String id){
        System.out.println(id);
        Album one = albumService.findOne(id);
        return one;
    }
    @RequestMapping("/findAllAlbum")
    public @ResponseBody Map<String,Object> findAllAlbum(Integer page, Integer rows){
        Map<String,Object> map=new HashMap<>();
        List<Album> byPage = albumService.findByPage(page,rows);
        Long totals = albumService.findTotals();
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }
    @RequestMapping("/addAlbums")
    public @ResponseBody Map<String,Object> addAlbum(Album album, MultipartFile aaa, HttpServletRequest request){
        Map<String,Object> map =new HashMap<>();
        try {
            String p = request.getSession().getServletContext().getRealPath("back/banner");
            aaa.transferTo(new File(p,aaa.getOriginalFilename()));
            album.setCoverimg("/back/banner/"+aaa.getOriginalFilename());
            albumService.add(album);
            map.put("success",true);
        }catch (Exception e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
