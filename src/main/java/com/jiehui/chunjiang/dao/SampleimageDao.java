package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-25 17:25:57
 */
@Mapper
public interface SampleimageDao {

	SampleimageEntity selectAboutImage();

	SampleimageEntity selectNewsImage();

	SampleimageEntity selectProductImage();

	SampleimageEntity selectTechImage();

	SampleimageEntity selectContactImage();

	SampleimageEntity selectBackImage();

	SampleimageEntity selectIndexTechImage();

	SampleimageEntity selectByCategory(@Param("category")Integer category);
}
