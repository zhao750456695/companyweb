package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.GoodsDao;
import com.jiehui.chunjiang.entity.GoodsEntity;
import com.jiehui.chunjiang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("goodsService")
public class GoodsServiceImpl  extends ServiceImpl<GoodsDao, GoodsEntity>  implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEntity> page = this.page(
                new Query<GoodsEntity>().getPage(params),
                new QueryWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsEntity> selectHomeGoods() {
        return goodsDao.selectHomeGoods();
    }

    @Override
    public IPage<GoodsEntity> selectPageCategoryVo(Page<GoodsEntity> page, String id) {
        return goodsDao.selectPageCategoryVo(page, id);
    }

    @Override
    public GoodsEntity selectGoodsByCode(String goodsCode) {
        return goodsDao.selectGoodsByCode(goodsCode);
    }

    @Override
    public IPage<GoodsEntity> queryGoodsInFilter(Page<?> page, ArrayList<String> cat) {
        return goodsDao.queryGoodsInFilter(page, cat);
    }
}