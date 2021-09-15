package com.jiehui.chunjiang.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiehui.chunjiang.common.utils.PageUtils;

import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.InfoDao;
import com.jiehui.chunjiang.entity.InfoEntity;
import com.jiehui.chunjiang.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, InfoEntity> implements InfoService {

    @Autowired
    private InfoDao infoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InfoEntity> page = this.page(
                new Query<InfoEntity>().getPage(params),
                new QueryWrapper<InfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InfoEntity> getInfo() {
        return infoDao.getInfo();
    }

}