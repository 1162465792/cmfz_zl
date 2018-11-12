package com.baizhi.dao;

import java.util.List;

public interface BaseDAO<T> {

    void insert(T t);

    void update(T t);

    void delete(String id);

    T queryOne(String id);

    List<T> queryAll();

}
