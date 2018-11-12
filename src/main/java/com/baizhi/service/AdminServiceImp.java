package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin find(String name, String password) {
        Admin query = adminDao.query(name, password);
        return query;
    }

    @Override
    public void add(Admin admin) {

    }

    @Override
    public void motify(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Admin findOne(String id) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }
}
