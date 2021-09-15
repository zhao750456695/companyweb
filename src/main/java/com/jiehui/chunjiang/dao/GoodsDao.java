package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehui.chunjiang.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity>  {
	List<GoodsEntity> selectHomeGoods();

	IPage<GoodsEntity> selectPageCategoryVo(Page<?> page, String id);

	GoodsEntity selectGoodsByCode(@Param("code") String goodsCode);
	IPage<GoodsEntity> queryGoodsInFilter(Page<?> page, @Param("list") List<String> cat);
}
