package com.baizhi.test;


import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestChapter {
    @Autowired
    private ChapterService chapterService;

    @Test
    public  void ss2(){
        Chapter chapter= new Chapter();
        chapter.setDownPath("周磊");
        chapter.setDuration("周磊");
        chapter.setAlbum_id("1");
        chapter.setSize("周磊");
        chapter.setTitle("周磊");
        chapterService.add(chapter);
    }

}

