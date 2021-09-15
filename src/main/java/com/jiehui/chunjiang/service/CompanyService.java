package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.CompanyEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 12:32:19
 */
public interface CompanyService {

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

    CompanyEntity selectByCat(Integer category);
}

