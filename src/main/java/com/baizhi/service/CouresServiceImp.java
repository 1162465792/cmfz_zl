package com.baizhi.service;

import com.baizhi.dao.CouresDao;
import com.baizhi.entity.Coures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CouresServiceImp implements CouresService {
    @Autowired
    private CouresDao couresDao;
    @Override
    public void add(Coures coures) {
        coures.setId(UUID.randomUUID().toString());
        coures.setCreatTime(new Date());
        couresDao.insert(coures);
    }

    @Override
    public void motify(Coures coures) {

    }

    @Override
    public void remove(String id) {
        couresDao.delete(id);
    }

    @Override
    public Coures findOne(String id) {
        return null;
    }

    @Override
    public List<Coures> findAll() {
        List<Coures> couress = couresDao.queryAll();
        return couress;
    }
}
