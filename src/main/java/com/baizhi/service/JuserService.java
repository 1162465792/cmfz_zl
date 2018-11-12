package com.baizhi.service;

import com.baizhi.entity.Juesr;

public interface JuserService extends BaseService<Juesr>{
    Juesr find(String name, String pwd);
}
