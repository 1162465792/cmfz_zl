package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImp implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setDate(new Date());
        bannerDao.insert(banner);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);

    }

    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }

    @Override
    public Banner findOne(String id) {
        Banner banner = bannerDao.queryOne(id);
        return banner;
    }

    @Override
    public List<Banner> findAll() {
        List<Banner> banners = bannerDao.queryAll();
        return banners;
    }
}
