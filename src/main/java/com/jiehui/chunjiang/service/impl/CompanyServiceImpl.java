package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.CompanyDao;
import com.jiehui.chunjiang.entity.CompanyEntity;
import com.jiehui.chunjiang.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public CompanyEntity selectIntro() {
        return companyDao.selectIntro();
    }

    @Override
    public CompanyEntity selectIntroDetail() {
        return companyDao.selectIntroDetail();
    }

    @Override
    public CompanyEntity selectIntroItems() {
        return companyDao.selectIntroItems();
    }

    @Override
    public CompanyEntity selectHistory() {
        return companyDao.selectHistory();
    }

    @Override
    public CompanyEntity selectHistoryDetail() {
        return companyDao.selectHistoryDetail();
    }

    @Override
    public CompanyEntity selectStructure() {
        return companyDao.selectStructure();
    }

    @Override
    public CompanyEntity selectStructureDetail() {
        return companyDao.selectHistoryDetail();
    }

    @Override
    public CompanyEntity selectCert() {
        return companyDao.selectCert();
    }

    @Override
    public CompanyEntity selectCertDetail() {
        return companyDao.selectCertDetail();
    }

    @Override
    public CompanyEntity selectContactUs() {
        return companyDao.selectContactUs();
    }

    @Override
    public CompanyEntity selectByCat(Integer category) {
        return companyDao.selectByCat(category);
    }

}