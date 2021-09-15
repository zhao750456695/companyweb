package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.TimelineDao;
import com.jiehui.chunjiang.entity.TimelineEntity;
import com.jiehui.chunjiang.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("timelineService")
public class TimelineServiceImpl extends ServiceImpl<TimelineDao, TimelineEntity> implements TimelineService {

    @Autowired
    private TimelineDao timelineDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TimelineEntity> page = this.page(
                new Query<TimelineEntity>().getPage(params),
                new QueryWrapper<TimelineEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<TimelineEntity> selectByOrder() {
        return timelineDao.selectByOrder();
    }

    @Override
    public void insertOnDuplicate() {
        timelineDao.insertOnDuplicate();
    }

}