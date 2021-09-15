package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.GoodsEnDao;
import com.jiehui.chunjiang.entity.GoodsEnEntity;
import com.jiehui.chunjiang.service.GoodsEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;





@Service("goodsEnService")
public class GoodsEnServiceImpl extends ServiceImpl<GoodsEnDao, GoodsEnEntity> implements GoodsEnService {

    @Autowired
    private GoodsEnDao goodsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEnEntity> page = this.page(
                new Query<GoodsEnEntity>().getPage(params),
                new QueryWrapper<GoodsEnEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public GoodsEnEntity selectGoodsByCode(String goodsCode) {
        return goodsDao.selectGoodsByCode(goodsCode);
    }

    @Override
    public List<GoodsEnEntity> selectHomeGoods() {
        return goodsDao.selectHomeGoods();
    }

    @Override
    public IPage<GoodsEnEntity> selectPageCategoryVo(Page<GoodsEnEntity> page, String id) {
        return goodsDao.selectPageCategoryVo(page, id);
    }

}