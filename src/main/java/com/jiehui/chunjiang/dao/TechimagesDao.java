package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.TechimagesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-26 09:49:22
 */
@Mapper
public interface TechimagesDao {
    List<TechimagesEntity> selectMTechimagesByCategory();
    List<TechimagesEntity> selectSTechimagesByCategory();
    List<TechimagesEntity> selectETechimagesByCategory();
}
