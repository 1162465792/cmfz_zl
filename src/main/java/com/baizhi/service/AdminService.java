package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService extends BaseService<Admin> {
    Admin find(String name, String password);
    
}