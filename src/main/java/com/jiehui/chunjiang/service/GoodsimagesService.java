package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.GoodsimagesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 商品图片管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
public interface GoodsimagesService{

    List<GoodsimagesEntity> selectGoodsHeadImagesByCode(String goodsCode);
    List<GoodsimagesEntity> selectGoodsDetailImagesByCode(String goodsCode);
}

