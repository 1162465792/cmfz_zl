package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface AlbumService extends BaseService<Album> {
    List<Album> findByPage(@Param("page") Integer page, @Param("rows") Integer rows);
    Long findTotals();//计算总条数
}
