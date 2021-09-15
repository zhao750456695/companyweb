package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.IndexEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-06 09:05:25
 */
public interface IndexService extends IService<IndexEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(IndexEntity index);

    IndexEntity selectAbout();

    List<IndexEntity> selectAboutItems();

    List<IndexEntity> selectAboutNums();

    IndexEntity selectNews();

    IndexEntity selectProduct();

    IndexEntity selectTech();
}

