package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.NewsEnEntity;
import com.jiehui.chunjiang.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:40:24
 */
@Mapper
public interface NewsEnDao extends BaseMapper<NewsEnEntity> {
    List<NewsEnEntity> selectThreeNews();

}
