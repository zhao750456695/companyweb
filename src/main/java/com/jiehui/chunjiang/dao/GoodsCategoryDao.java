package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.GoodsCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-19 09:51:16
 */
@Mapper
public interface GoodsCategoryDao{
    List<GoodsCategoryEntity> queryCategoryList();
    Boolean updateCategory();
}
