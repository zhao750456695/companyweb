package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.TimelineEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-13 21:25:35
 */
@Mapper
public interface TimelineDao extends BaseMapper<TimelineEntity> {
    List<TimelineEntity> selectByOrder();

    void insertOnDuplicate();
}
