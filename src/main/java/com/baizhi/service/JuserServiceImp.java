package com.baizhi.service;

import com.baizhi.dao.JuserDao;
import com.baizhi.entity.Juesr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class JuserServiceImp implements JuserService {
    @Autowired
    private JuserDao juserDao;
    @Override
    public Juesr find(String name, String pwd) {
        Juesr query = juserDao.query(name, pwd);
        System.out.println("--------登录测试-------"+query);
        return query;
    }
    @Override
    public void add(Juesr juesr) {
        juesr.setTimeDate(new Date());
        juserDao.insert(juesr);
    }

    @Override
    public void motify(Juesr juesr) {
        juesr.setTimeDate(new Date());
        juserDao.update(juesr);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Juesr findOne(String id) {
        return null;
    }

    @Override
    public List<Juesr> findAll() {
        return null;
    }


}
