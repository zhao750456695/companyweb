package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.NewsEnEntity;
import com.jiehui.chunjiang.entity.NewsEntity;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-20 19:52:16
 */
public interface NewsService  extends IService<NewsEntity> {
    PageUtils queryPage(Map<String, Object> params);
    List<NewsEntity> selectThreeNews();
}

