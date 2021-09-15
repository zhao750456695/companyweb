/**
 * projectName: chunjiang
 * fileName: TechController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-09 15:57
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiehui.chunjiang.common.utils.GetHtmlMeta;
import com.jiehui.chunjiang.entity.CompanyEntity;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import com.jiehui.chunjiang.entity.TechimagesEntity;
import com.jiehui.chunjiang.entity.WebimagesEntity;
import com.jiehui.chunjiang.service.CompanyService;
import com.jiehui.chunjiang.service.SampleimageService;
import com.jiehui.chunjiang.service.TechimagesService;
import com.jiehui.chunjiang.service.WebimagesService;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TechController {

    @Autowired
    private TechimagesService techimagesService;

    @Autowired
    private SampleimageService sampleimageService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private WebimagesService webimagesService;
    @RequestMapping("/tech")
    public String tech(@RequestParam(value = "cat", defaultValue = "1") Integer cat, ModelMap modelMap){
        // ================= 通用部分
        // 基本信息
        GetHtmlMeta getHtmlMeta = new GetHtmlMeta();
        HtmlMetaVO htmlMetaVO = getHtmlMeta.getHtmlMetaZH();
        modelMap.put("title", htmlMetaVO.getTitle());
        modelMap.put("websiteName", htmlMetaVO.getWebsiteName());
        modelMap.put("iconUrl", htmlMetaVO.getIconUrl());
        modelMap.put("description", htmlMetaVO.getDescription());
        modelMap.put("keywords", htmlMetaVO.getKeyWords());
        modelMap.put("copyright", htmlMetaVO.getRecord());
        modelMap.put("slogan", htmlMetaVO.getSlogan());
        // 获取logo
        SampleimageEntity headlogo = sampleimageService.selectByCategory(8);
        modelMap.put("headlogo", headlogo.getUrl());
        // 页脚
        // 联系我们
        CompanyEntity conta = companyService.selectByCat(28);
        String contact = conta.getContent();
        JSONObject contactObject = JSONObject.parseObject(contact);
        String address = contactObject.getString("address");
        String phone = contactObject.getString("phone");
        String mail = contactObject.getString("mail");
        String web = contactObject.getString("web");

        modelMap.put("address", address);
        modelMap.put("phone", phone);
        modelMap.put("hotphone", phone.substring(2, phone.length()-1));
        modelMap.put("mail", mail);
        modelMap.put("web", web);

        // 二维码
        // 商城
        List<WebimagesEntity> mall = webimagesService.selectPictureByCat(66);
        modelMap.put("mall", mall.get(0));
        // 其他
        // 9 10 11
        SampleimageEntity s1 = sampleimageService.selectByCategory(9);
        SampleimageEntity s2 = sampleimageService.selectByCategory(10);
        SampleimageEntity s3 = sampleimageService.selectByCategory(11);
        List<SampleimageEntity> icons = new ArrayList<>();
        icons.add(s1);
        icons.add(s2);
        icons.add(s3);
        modelMap.put("icons", icons);
        if (cat.equals(1)) {
            // 制鞋材料 1
            List<TechimagesEntity> materia = techimagesService.selectMTechimagesByCategory();
            modelMap.put("materia", materia);
            modelMap.put("cat", cat);
        }
        if (cat.equals(2)) {
            // 技术规格 2
            List<TechimagesEntity> standard = techimagesService.selectSTechimagesByCategory();
            modelMap.put("standard", standard);
            modelMap.put("cat", cat);
        }
        if (cat.equals(3)) {
            // 实验设备 3
            List<TechimagesEntity> equipment = techimagesService.selectETechimagesByCategory();
            modelMap.put("equipment", equipment);
            modelMap.put("cat", cat);
        }
        return "tech";
    }
}
