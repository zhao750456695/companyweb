package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.GoodsimagesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@Mapper
public interface GoodsimagesDao {
    List<GoodsimagesEntity> selectGoodsHeadImagesByCode(@Param("code") String goodsCode);
    List<GoodsimagesEntity> selectGoodsDetailImagesByCode(@Param("code") String goodsCode);
}
