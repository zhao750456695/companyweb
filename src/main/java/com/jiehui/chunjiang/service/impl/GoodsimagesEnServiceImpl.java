package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.GoodsimagesEnDao;
import com.jiehui.chunjiang.entity.GoodsimagesEnEntity;
import com.jiehui.chunjiang.service.GoodsimagesEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;




@Service("goodsimagesEnService")
public class GoodsimagesEnServiceImpl extends ServiceImpl<GoodsimagesEnDao, GoodsimagesEnEntity> implements GoodsimagesEnService {

    @Autowired
    private GoodsimagesEnDao goodsimagesEnDao;


    @Override
    public List<GoodsimagesEnEntity> selectGoodsHeadImagesByCode(String goodsCode) {
        return goodsimagesEnDao.selectGoodsHeadImagesByCode(goodsCode);
    }

    @Override
    public List<GoodsimagesEnEntity> selectGoodsDetailImagesByCode(String goodsCode) {
        return goodsimagesEnDao.selectGoodsDetailImagesByCode(goodsCode);
    }
}