package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jiehui.chunjiang.entity.WebimagesEnEntity;
import com.jiehui.chunjiang.entity.WebimagesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:03:42
 */
@Mapper
public interface WebimagesEnDao extends BaseMapper<WebimagesEnEntity> {
    List<WebimagesEnEntity> selectBigPicture();

}
