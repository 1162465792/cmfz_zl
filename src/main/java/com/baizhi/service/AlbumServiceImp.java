package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImp implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> findByPage(Integer page, Integer rows) {
        int s=(page-1)*rows;
        List<Album> byPage = albumDao.findByPage(s, rows);
        return byPage;
    }
    @Override
    public List<Album> findAll() {
        List<Album> albums = albumDao.queryAll();
        return albums;
    }
    @Override
    public Long findTotals() {
        Long totals = albumDao.findTotals();
        return totals;
    }

    @Override
    public void add(Album album) {
        album.setPublishDate(new Date());
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    @Override
    public void motify(Album album) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Album findOne(String id) {
        Album album = albumDao.queryOne(id);
        return album;
    }


}
