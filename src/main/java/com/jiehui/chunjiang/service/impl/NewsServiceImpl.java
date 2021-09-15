package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.NewsDao;
import com.jiehui.chunjiang.dao.NewsEnDao;
import com.jiehui.chunjiang.entity.NewsEnEntity;
import com.jiehui.chunjiang.entity.NewsEntity;
import com.jiehui.chunjiang.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity>  implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NewsEntity> page = this.page(
                new Query<NewsEntity>().getPage(params),
                new QueryWrapper<NewsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<NewsEntity> selectThreeNews() {
        return newsDao.selectThreeNews();
    }
}