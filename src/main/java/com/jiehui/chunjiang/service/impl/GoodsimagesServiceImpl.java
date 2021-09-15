package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.GoodsimagesDao;
import com.jiehui.chunjiang.entity.GoodsimagesEntity;
import com.jiehui.chunjiang.service.GoodsimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("goodsimagesService")
public class GoodsimagesServiceImpl implements GoodsimagesService {

    @Autowired
    private GoodsimagesDao goodsimagesDao;

    @Override
    public List<GoodsimagesEntity> selectGoodsHeadImagesByCode(String goodsCode) {
        return goodsimagesDao.selectGoodsHeadImagesByCode(goodsCode);
    }

    @Override
    public List<GoodsimagesEntity> selectGoodsDetailImagesByCode(String goodsCode) {
        return goodsimagesDao.selectGoodsDetailImagesByCode(goodsCode);
    }
}