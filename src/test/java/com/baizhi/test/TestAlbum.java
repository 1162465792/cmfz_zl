package com.baizhi.test;


import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAlbum {
    @Autowired
    private AlbumService albumService;
    @Test
    public  void ss1(){
        List<Album> all = albumService.findAll();
        System.out.println(all);
    }
    @Test
    public  void ss2(){
        Album album= new Album();
        album.setAuthor("w");
        album.setBrief("w");
        album.setBroadCast("w");
        album.setCount("w");
        album.setCoverimg("w");
        album.setStar("w");
        album.setTitle("w");
        System.out.println(album);
        albumService.add(album);
    }
    @Test
    public  void ss3(){
        albumService.findOne("1");

    }
}

