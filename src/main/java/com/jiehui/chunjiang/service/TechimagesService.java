package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.TechimagesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-26 09:49:22
 */
public interface TechimagesService{
    List<TechimagesEntity> selectMTechimagesByCategory();
    List<TechimagesEntity> selectSTechimagesByCategory();
    List<TechimagesEntity> selectETechimagesByCategory();
}

