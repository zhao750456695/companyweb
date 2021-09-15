package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.CompanyDao;
import com.jiehui.chunjiang.dao.CompanyEnDao;
import com.jiehui.chunjiang.entity.CompanyEnEntity;
import com.jiehui.chunjiang.service.CompanyEnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("companyEnService")
public class CompanyEnServiceImpl extends ServiceImpl<CompanyEnDao, CompanyEnEntity> implements CompanyEnService {

    @Autowired
    private CompanyEnDao companyDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyEnEntity> page = this.page(
                new Query<CompanyEnEntity>().getPage(params),
                new QueryWrapper<CompanyEnEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public CompanyEnEntity selectIntro() {
        return companyDao.selectIntro();
    }

    @Override
    public CompanyEnEntity selectIntroDetail() {
        return companyDao.selectIntroDetail();
    }

    @Override
    public CompanyEnEntity selectIntroItems() {
        return companyDao.selectIntroItems();
    }

    @Override
    public CompanyEnEntity selectHistory() {
        return companyDao.selectHistory();
    }

    @Override
    public CompanyEnEntity selectHistoryDetail() {
        return companyDao.selectHistoryDetail();
    }

    @Override
    public CompanyEnEntity selectStructure() {
        return companyDao.selectStructure();
    }

    @Override
    public CompanyEnEntity selectStructureDetail() {
        return companyDao.selectStructureDetail();
    }

    @Override
    public CompanyEnEntity selectCert() {
        return companyDao.selectCert();
    }

    @Override
    public CompanyEnEntity selectCertDetail() {
        return companyDao.selectCertDetail();
    }

    @Override
    public CompanyEnEntity selectContactUs() {
        return companyDao.selectContactUs();
    }

}