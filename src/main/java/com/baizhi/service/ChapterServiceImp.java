package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class ChapterServiceImp implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setUploadTime(new Date());
        chapterDao.insert(chapter);
    }

    @Override
    public void motify(Chapter chapter) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Chapter findOne(String id) {
        return null;
    }

    @Override
    public List<Chapter> findAll() {
        return null;
    }
}
