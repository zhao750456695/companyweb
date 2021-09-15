package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.IndexDao;
import com.jiehui.chunjiang.entity.IndexEntity;
import com.jiehui.chunjiang.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("indexService")
public class IndexServiceImpl extends ServiceImpl<IndexDao, IndexEntity> implements IndexService {

    @Autowired
    private IndexDao indexDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IndexEntity> page = this.page(
                new Query<IndexEntity>().getPage(params),
                new QueryWrapper<IndexEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(IndexEntity index) {
        indexDao.insertOnDuplicate(index.getH1(), index.getH2(), index.getCategory(), index.getKid());
    }

    @Override
    public IndexEntity selectAbout() {
        return indexDao.selectAbout();
    }

    @Override
    public List<IndexEntity> selectAboutItems() {
        return indexDao.selectAboutItems();
    }

    @Override
    public List<IndexEntity> selectAboutNums() {
        return indexDao.selectAboutNums();
    }

    @Override
    public IndexEntity selectNews() {
        return indexDao.selectNews();
    }

    @Override
    public IndexEntity selectProduct() {
        return indexDao.selectProduct();
    }

    @Override
    public IndexEntity selectTech() {
        return indexDao.selectTech();
    }

}