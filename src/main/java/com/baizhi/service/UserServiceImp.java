package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findByPage(Integer start, Integer rows) {
        int s=(start-1)*rows;
        return userDao.findByPage(s,rows);
    }

    @Override
    public Long findTotals() {
        return userDao.findTotals();
    }

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setDate(new Date());
        userDao.insert(user);
    }

    @Override
    public void motify(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public User findOne(String id) {
        return userDao.queryOne(id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
