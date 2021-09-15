package com.jiehui.chunjiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiehui.chunjiang.common.utils.GetHtmlMeta;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.R;
import com.jiehui.chunjiang.entity.*;
import com.jiehui.chunjiang.service.CompanyService;
import com.jiehui.chunjiang.service.RecruitService;
import com.jiehui.chunjiang.service.SampleimageService;
import com.jiehui.chunjiang.service.WebimagesService;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
@Controller
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @Autowired
    private SampleimageService sampleimageService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private WebimagesService webimagesService;

    // 招聘
    @RequestMapping("/recruit")
    public String recruit(ModelMap modelMap){
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
        List<RecruitEntity> recruitEntityList = recruitService.selectOrderByDate();
        List<List<RecruitEntity>> reclist = new ArrayList<>();
        List<RecruitEntity> rl = new ArrayList<>();
        for (int i=0; i<recruitEntityList.size(); i++) {
            if ((i+1) % 2 != 0) {
                // 奇数
                rl.add(recruitEntityList.get(i));
                if ((i+1) == recruitEntityList.size()) {
                    reclist.add(rl);
                }
            } else {
                // 偶数
                rl.add(recruitEntityList.get(i));
                reclist.add(rl);
                rl = new ArrayList<>();
            }
        }


        modelMap.put("recruit", reclist);
        return "recruit";
    }

    @RequestMapping("/recruit_detail")
    public String recruitDetail(@RequestParam("id") Integer id, ModelMap modelMap){
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

        RecruitEntity recruit = recruitService.getById(id);
        String content = recruit.getContent();
        modelMap.put("content", content);

        String title = recruit.getTitle();
        modelMap.put("title", title);

        modelMap.put("author", "春江鞋业");

        String dateTime = recruit.getUpdated();

        modelMap.put("dateTime", dateTime);
        return "recruitDetail";
    }

}
