package com.jiehui.chunjiang.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jiehui.chunjiang.entity.GoodsimagesEnEntity;
import com.jiehui.chunjiang.entity.GoodsimagesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 09:12:56
 */
@Mapper
public interface GoodsimagesEnDao extends BaseMapper<GoodsimagesEnEntity> {

    List<GoodsimagesEnEntity> selectGoodsHeadImagesByCode(@Param("code") String goodsCode);
    List<GoodsimagesEnEntity> selectGoodsDetailImagesByCode(@Param("code") String goodsCode);

}