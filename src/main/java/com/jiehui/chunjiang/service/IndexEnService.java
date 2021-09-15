package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.IndexEnEntity;
import com.jiehui.chunjiang.entity.IndexEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-06 09:05:25
 */
public interface IndexEnService extends IService<IndexEnEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(IndexEnEntity index);

    IndexEnEntity selectAbout();

    List<IndexEnEntity> selectAboutItems();

    List<IndexEnEntity> selectAboutNums();

    IndexEnEntity selectNews();

    IndexEnEntity selectProduct();

    IndexEnEntity selectTech();
}

