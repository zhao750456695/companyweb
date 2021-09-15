package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.NewsEnDao;
import com.jiehui.chunjiang.entity.NewsEnEntity;
import com.jiehui.chunjiang.service.NewsEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;





@Service("newsEnService")
public class NewsEnServiceImpl extends ServiceImpl<NewsEnDao, NewsEnEntity> implements NewsEnService {

    @Autowired
    private NewsEnDao newsEnDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NewsEnEntity> page = this.page(
                new Query<NewsEnEntity>().getPage(params),
                new QueryWrapper<NewsEnEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NewsEnEntity> selectThreeNews() {
        return newsEnDao.selectThreeNews();
    }

}