package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.ShowsDao;
import com.jiehui.chunjiang.entity.ShowsEntity;
import com.jiehui.chunjiang.service.ShowsService;
import com.jiehui.chunjiang.vo.ShowsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("showsService")
public class ShowsServiceImpl extends ServiceImpl<ShowsDao, ShowsVO> implements ShowsService {

    @Autowired
    private ShowsDao showsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShowsVO> page = this.page(
                new Query<ShowsVO>().getPage(params),
                new QueryWrapper<ShowsVO>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertShowInfo(ShowsEntity show) {
        showsDao.insertShowInfo(show);
    }

    @Override
    public void updateShowById(ShowsEntity show) {
        showsDao.updateShowById(show);
    }

    @Override
    public List<ShowsVO> selectOrderByDate() {
        return showsDao.selectOrderByDate();
    }

}