package com.baizhi.dao;

import com.baizhi.entity.Juesr;
import org.apache.ibatis.annotations.Param;

public interface JuserDao extends BaseDAO<Juesr> {
    Juesr query(@Param("name") String name, @Param("pwd") String pwd);
}
