package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 12:32:19
 */
@Mapper
public interface CompanyDao {
    CompanyEntity selectIntro();

    CompanyEntity selectIntroDetail();

    CompanyEntity selectIntroItems();

    CompanyEntity selectHistory();

    CompanyEntity selectHistoryDetail();

    CompanyEntity selectStructure();

    CompanyEntity selectStructureDetail();

    CompanyEntity selectCert();

    CompanyEntity selectCertDetail();

    CompanyEntity selectContactUs();

    CompanyEntity selectByCat(@Param("category")Integer category);
}
