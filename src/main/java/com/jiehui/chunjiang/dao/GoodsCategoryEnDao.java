package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.GoodsCategoryEnEntity;
import com.jiehui.chunjiang.entity.GoodsCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:25:37
 */
@Mapper
public interface GoodsCategoryEnDao extends BaseMapper<GoodsCategoryEnEntity> {
    List<GoodsCategoryEnEntity> queryCategoryList();
}
