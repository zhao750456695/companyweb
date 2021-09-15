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
 * @date 2021-04-20 19:52:16
 */
@Mapper
public interface NewsDao  extends BaseMapper<NewsEntity> {
	List<NewsEntity> selectThreeNews();
}
