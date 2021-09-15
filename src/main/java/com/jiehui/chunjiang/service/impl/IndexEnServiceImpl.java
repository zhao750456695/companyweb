package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.IndexDao;
import com.jiehui.chunjiang.dao.IndexEnDao;
import com.jiehui.chunjiang.entity.IndexEnEntity;
import com.jiehui.chunjiang.entity.IndexEntity;
import com.jiehui.chunjiang.service.IndexEnService;
import com.jiehui.chunjiang.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("indexEnService")
public class IndexEnServiceImpl extends ServiceImpl<IndexEnDao, IndexEnEntity> implements IndexEnService {

    @Autowired
    private IndexEnDao indexDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IndexEnEntity> page = this.page(
                new Query<IndexEnEntity>().getPage(params),
                new QueryWrapper<IndexEnEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(IndexEnEntity index) {
        indexDao.insertOnDuplicate(index.getH1(), index.getH2(), index.getCategory(), index.getKid());
    }

    @Override
    public IndexEnEntity selectAbout() {
        return indexDao.selectAbout();
    }

    @Override
    public List<IndexEnEntity> selectAboutItems() {
        return indexDao.selectAboutItems();
    }

    @Override
    public List<IndexEnEntity> selectAboutNums() {
        return indexDao.selectAboutNums();
    }

    @Override
    public IndexEnEntity selectNews() {
        return indexDao.selectNews();
    }

    @Override
    public IndexEnEntity selectProduct() {
        return indexDao.selectProduct();
    }

    @Override
    public IndexEnEntity selectTech() {
        return indexDao.selectTech();
    }

}