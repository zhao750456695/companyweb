package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.WebimagesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 21:09:15
 */
@Mapper
public interface WebimagesDao{
    List<WebimagesEntity> selectBigPicture();
    List<WebimagesEntity> selectPictureByCat(@Param("category")Integer cat);
}
