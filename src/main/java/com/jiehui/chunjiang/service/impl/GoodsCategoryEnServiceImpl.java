package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.GoodsCategoryEnDao;
import com.jiehui.chunjiang.entity.GoodsCategoryEnEntity;
import com.jiehui.chunjiang.service.GoodsCategoryEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;





@Service("goodsCategoryEnService")
public class GoodsCategoryEnServiceImpl extends ServiceImpl<GoodsCategoryEnDao, GoodsCategoryEnEntity> implements GoodsCategoryEnService {

    @Autowired
    private GoodsCategoryEnDao goodsCategoryEnDao;

    @Override
    public List<GoodsCategoryEnEntity> queryGoodsCategoryList() {
        return goodsCategoryEnDao.queryCategoryList();
    }
}