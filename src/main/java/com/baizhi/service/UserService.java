package com.baizhi.service;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends BaseService<User>{
    List<User> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);//参数1:起始条数 //参数2:每页显示的记录数
    Long findTotals();//计算总条数
}
