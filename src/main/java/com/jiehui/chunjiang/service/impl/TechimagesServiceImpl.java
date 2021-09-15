package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.TechimagesDao;
import com.jiehui.chunjiang.entity.TechimagesEntity;
import com.jiehui.chunjiang.service.TechimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("techimagesService")
public class TechimagesServiceImpl implements TechimagesService {

    @Autowired
    TechimagesDao techimagesDao;

    @Override
    public List<TechimagesEntity> selectMTechimagesByCategory() {
        return techimagesDao.selectMTechimagesByCategory();
    }

    @Override
    public List<TechimagesEntity> selectSTechimagesByCategory() {
        return techimagesDao.selectSTechimagesByCategory();
    }

    @Override
    public List<TechimagesEntity> selectETechimagesByCategory() {
        return techimagesDao.selectETechimagesByCategory();
    }
}