package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.GoodsimagesEnEntity;
import com.jiehui.chunjiang.entity.GoodsimagesEntity;


import java.util.List;
import java.util.Map;

/**
 * 商品图片管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 09:12:56
 */
public interface GoodsimagesEnService extends IService<GoodsimagesEnEntity> {

    List<GoodsimagesEnEntity> selectGoodsHeadImagesByCode(String goodsCode);
    List<GoodsimagesEnEntity> selectGoodsDetailImagesByCode(String goodsCode);
}

