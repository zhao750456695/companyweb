package com.jiehui.chunjiang.service.impl;


import com.jiehui.chunjiang.common.utils.PageUtils;

import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.SampleimageDao;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import com.jiehui.chunjiang.service.SampleimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("sampleimageService")
public class SampleimageServiceImpl implements SampleimageService {

    @Autowired
    private SampleimageDao sampleimageDao;


    public SampleimageEntity selectAboutImage(){
        return sampleimageDao.selectAboutImage();
    }

    public SampleimageEntity selectNewsImage(){
        return sampleimageDao.selectNewsImage();
    }

    public SampleimageEntity selectProductImage(){
        return sampleimageDao.selectProductImage();
    }

    public SampleimageEntity selectTechImage(){
        return sampleimageDao.selectTechImage();
    }

    public SampleimageEntity selectContactImage(){
        return sampleimageDao.selectContactImage();
    }

    public SampleimageEntity selectBackImage(){
        return sampleimageDao.selectBackImage();
    }

    @Override
    public SampleimageEntity selectIndexTechImage() {
        return sampleimageDao.selectIndexTechImage();
    }

    @Override
    public SampleimageEntity selectByCategory(Integer category) {
        return sampleimageDao.selectByCategory(category);
    }

}