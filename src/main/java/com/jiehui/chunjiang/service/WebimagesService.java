package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.WebimagesEntity;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 21:09:15
 */
public interface WebimagesService{
    List<WebimagesEntity> selectBigPicture();
    List<WebimagesEntity> selectPictureByCat(Integer cat);
}

