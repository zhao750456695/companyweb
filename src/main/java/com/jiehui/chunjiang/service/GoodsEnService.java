package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.GoodsEnEntity;
import com.jiehui.chunjiang.entity.GoodsEntity;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 08:40:03
 */
public interface GoodsEnService extends IService<GoodsEnEntity> {



    PageUtils queryPage(Map<String, Object> params);

    List<GoodsEnEntity> selectHomeGoods();

    IPage<GoodsEnEntity> selectPageCategoryVo(Page<GoodsEnEntity> page, String id);

    GoodsEnEntity selectGoodsByCode(String goodsCode);
}

