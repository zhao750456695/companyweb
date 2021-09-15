package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.HomeProductsDao;
import com.jiehui.chunjiang.entity.HomeProductsEntity;
import com.jiehui.chunjiang.service.HomeProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("homeProductsService")
public class HomeProductsServiceImpl extends ServiceImpl<HomeProductsDao, HomeProductsEntity> implements HomeProductsService {

    @Autowired
    private HomeProductsDao homeProductsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeProductsEntity> page = this.page(
                new Query<HomeProductsEntity>().getPage(params),
                new QueryWrapper<HomeProductsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(HomeProductsEntity homeProductsEntity) {
        homeProductsDao.insertOnDuplicate(homeProductsEntity.getLabel(), homeProductsEntity.getProducts(), homeProductsEntity.getCategory());
    }

    @Override
    public List<HomeProductsEntity> getAll() {
        return homeProductsDao.getAll();
    }

}