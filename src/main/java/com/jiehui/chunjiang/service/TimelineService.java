package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.TimelineEntity;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-13 21:25:35
 */
public interface TimelineService extends IService<TimelineEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<TimelineEntity> selectByOrder();

    void insertOnDuplicate();
}

