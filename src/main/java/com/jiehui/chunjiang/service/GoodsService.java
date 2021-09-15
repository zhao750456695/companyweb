package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
public interface GoodsService extends IService<GoodsEntity>{

    PageUtils queryPage(Map<String, Object> params);

    List<GoodsEntity> selectHomeGoods();

    IPage<GoodsEntity> selectPageCategoryVo(Page<GoodsEntity> page, String id);

    GoodsEntity selectGoodsByCode(String goodsCode);

    IPage<GoodsEntity> queryGoodsInFilter(Page<?> page, ArrayList<String> cat);
}

