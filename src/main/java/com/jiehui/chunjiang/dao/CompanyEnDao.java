package com.jiehui.chunjiang.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jiehui.chunjiang.entity.CompanyEnEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:56:12
 */
@Mapper
public interface CompanyEnDao extends BaseMapper<CompanyEnEntity> {
    CompanyEnEntity selectIntro();

    CompanyEnEntity selectIntroDetail();

    CompanyEnEntity selectIntroItems();

    CompanyEnEntity selectHistory();

    CompanyEnEntity selectHistoryDetail();

    CompanyEnEntity selectStructure();

    CompanyEnEntity selectStructureDetail();

    CompanyEnEntity selectCert();

    CompanyEnEntity selectCertDetail();

    CompanyEnEntity selectContactUs();
}
