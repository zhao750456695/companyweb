package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.RecruitDao;
import com.jiehui.chunjiang.entity.RecruitEntity;
import com.jiehui.chunjiang.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("recruitService")
public class RecruitServiceImpl extends ServiceImpl<RecruitDao, RecruitEntity> implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecruitEntity> page = this.page(
                new Query<RecruitEntity>().getPage(params),
                new QueryWrapper<RecruitEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<RecruitEntity> selectOrderByDate() {
        return recruitDao.selectOrderByDate();
    }

}