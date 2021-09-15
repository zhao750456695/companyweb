package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.WebimagesEnEntity;
import com.jiehui.chunjiang.entity.WebimagesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:03:42
 */
public interface WebimagesEnService extends IService<WebimagesEnEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<WebimagesEnEntity> selectBigPicture();
}

