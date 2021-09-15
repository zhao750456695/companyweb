package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.GoodsCategoryDao;
import com.jiehui.chunjiang.entity.GoodsCategoryEntity;
import com.jiehui.chunjiang.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;



    @Override
    public List<GoodsCategoryEntity> queryGoodsCategoryList() {
        return goodsCategoryDao.queryCategoryList();
    }

}