package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.GoodsCategoryEnEntity;
import com.jiehui.chunjiang.entity.GoodsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:25:37
 */
public interface GoodsCategoryEnService extends IService<GoodsCategoryEnEntity> {

    List<GoodsCategoryEnEntity> queryGoodsCategoryList();
}

