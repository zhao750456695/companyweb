package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-25 17:25:57
 */
public interface SampleimageService{

    SampleimageEntity selectAboutImage();

    SampleimageEntity selectNewsImage();

    SampleimageEntity selectProductImage();

    SampleimageEntity selectTechImage();

    SampleimageEntity selectContactImage();

    SampleimageEntity selectBackImage();

    SampleimageEntity selectIndexTechImage();

    SampleimageEntity selectByCategory(Integer category);
}

