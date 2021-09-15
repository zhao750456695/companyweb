package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.IndexEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-06 09:05:25
 */
@Mapper
public interface IndexDao extends BaseMapper<IndexEntity> {
    void insertOnDuplicate(@Param("h1")String h1, @Param("h2")String h2, @Param("category")Integer category, @Param("kid")Integer kid);

    IndexEntity selectAbout();

    List<IndexEntity> selectAboutItems();

    List<IndexEntity> selectAboutNums();

    IndexEntity selectNews();

    IndexEntity selectProduct();

    IndexEntity selectTech();
}
