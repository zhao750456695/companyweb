package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.CompanyEnEntity;
import com.jiehui.chunjiang.entity.CompanyEntity;


import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:56:12
 */
public interface CompanyEnService extends IService<CompanyEnEntity> {

    PageUtils queryPage(Map<String, Object> params);

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

