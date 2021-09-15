package com.jiehui.chunjiang.controller.en;

import com.alibaba.druid.support.json.JSONUtils;
import com.jiehui.chunjiang.entity.CompanyEnEntity;
import com.jiehui.chunjiang.entity.CompanyEntity;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import com.jiehui.chunjiang.service.CompanyEnService;
import com.jiehui.chunjiang.service.CompanyService;
import com.jiehui.chunjiang.service.SampleimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 12:32:19
 */
@Controller
@RequestMapping("/en")
public class CompanyEnController {
    @Autowired
    private CompanyEnService companyService;

    @Autowired
    private SampleimageService sampleimageService;

    @RequestMapping("/aboutus")
    public String aboutus(ModelMap modelMap){

        CompanyEnEntity intro = companyService.selectIntro();
        modelMap.put("intro", intro.getContent());

        CompanyEnEntity history = companyService.selectHistory();
        modelMap.put("history", history.getContent());

        CompanyEnEntity introItems = companyService.selectIntroItems();
        modelMap.put("introItems", JSONUtils.parse(introItems.getContent()));

        CompanyEnEntity structure =  companyService.selectStructure();
        modelMap.put("structure", structure.getContent());

        CompanyEnEntity cert = companyService.selectCert();
        modelMap.put("cert", cert.getContent());

        SampleimageEntity headimage = sampleimageService.selectAboutImage();
        modelMap.put("headimag", headimage.getUrl());

        return "en/aboutus";
    }


    @RequestMapping("/intro")
    public String intro(ModelMap modelMap){

        SampleimageEntity headimage = sampleimageService.selectAboutImage();
        modelMap.put("headimag", headimage.getUrl());

        modelMap.put("navbread", "ABOUT Us");

        CompanyEnEntity intro = companyService.selectIntroDetail();
        if (intro != null) {
            modelMap.put("content", intro.getContent());
        } else {
            modelMap.put("content", "");
        }

        return "en/company";
    }

    @RequestMapping("/history")
    public String history(ModelMap modelMap){

        SampleimageEntity headimage = sampleimageService.selectAboutImage();
        modelMap.put("headimag", headimage.getUrl());

        modelMap.put("navbread", "COMPANY HISTORY");

        CompanyEnEntity intro = companyService.selectHistoryDetail();
        if (intro != null) {
            modelMap.put("content", intro.getContent());
        } else {
            modelMap.put("content", "");
        }

        return "en/company";
    }

    @RequestMapping("/cert")
    public String cert(ModelMap modelMap){

        SampleimageEntity headimage = sampleimageService.selectAboutImage();
        modelMap.put("headimag", headimage.getUrl());

        modelMap.put("navbread", "QUALIFICATION CERTIFICATION");

        CompanyEnEntity intro = companyService.selectCertDetail();
        if (intro != null) {
            modelMap.put("content", intro.getContent());
        } else {
            modelMap.put("content", "");
        }


        return "en/company";
    }


}
