package com.jiehui.chunjiang.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jiehui.chunjiang.common.utils.GetHtmlMeta;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.R;
import com.jiehui.chunjiang.entity.CompanyEntity;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import com.jiehui.chunjiang.entity.TimelineEntity;
import com.jiehui.chunjiang.entity.WebimagesEntity;
import com.jiehui.chunjiang.service.CompanyService;
import com.jiehui.chunjiang.service.SampleimageService;
import com.jiehui.chunjiang.service.TimelineService;
import com.jiehui.chunjiang.service.WebimagesService;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import com.jiehui.chunjiang.vo.PeerVO;
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
 * @date 2021-04-24 12:32:19
 */
@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private WebimagesService webimagesService;

    @Autowired
    private TimelineService timelineService;

    @Autowired
    private SampleimageService sampleimageService;

    @RequestMapping("/aboutus")
    public String aboutus(ModelMap modelMap){
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
        // =========== 简介
        // 轮播图，webimage 2
        List<WebimagesEntity> introImages = webimagesService.selectPictureByCat(2);
        modelMap.put("introImages", introImages);
        // 简介 company 1
        CompanyEntity intro = companyService.selectByCat(1);

        JSONObject introObject = JSONObject.parseObject(intro.getContent());
        String bigTitle = introObject.getString("bigtitle");
        String smallTitle1 = introObject.getString("smalltitle1");
        String content1 = introObject.getString("desc1");
        String smallTitle2 = introObject.getString("smalltitle2");
        String content2 = introObject.getString("desc2");
        String smallTitle3 = introObject.getString("smalltitle3");
        String content3 = introObject.getString("desc3");

        List<PeerVO> peerVOList = new ArrayList<>();
        PeerVO p1 = new PeerVO();
        PeerVO p2 = new PeerVO();
        PeerVO p3 = new PeerVO();
        p1.setTitle(smallTitle1);
        p1.setContent(content1);
        p2.setTitle(smallTitle2);
        p2.setContent(content2);
        p3.setTitle(smallTitle3);
        p3.setContent(content3);

        peerVOList.add(p1);
        peerVOList.add(p2);
        peerVOList.add(p3);

        modelMap.put("bigTitle", bigTitle);
        modelMap.put("peerList", peerVOList);

        // 企业文化 company 3 4 5
        // 上面三图标3
        // 简述和图片4
        // 详情5
        CompanyEntity three = companyService.selectByCat(3);
        JSONObject threeObject = JSONObject.parseObject(three.getContent());
        String smallTitle11 = threeObject.getString("smalltitle1");
        String content11 = threeObject.getString("desc1");
        String smallTitle21 = threeObject.getString("smalltitle2");
        String content21 = threeObject.getString("desc2");
        String smallTitle31 = threeObject.getString("smalltitle3");
        String content31 = threeObject.getString("desc3");

        List<PeerVO> peerVOList1 = new ArrayList<>();
        PeerVO tp1 = new PeerVO();
        PeerVO tp2 = new PeerVO();
        PeerVO tp3 = new PeerVO();
        tp1.setTitle(smallTitle11);
        tp1.setContent(content11);
        tp2.setTitle(smallTitle21);
        tp2.setContent(content21);
        tp3.setTitle(smallTitle31);
        tp3.setContent(content31);

        peerVOList1.add(tp1);
        peerVOList1.add(tp2);
        peerVOList1.add(tp3);

        modelMap.put("three", peerVOList1);

        CompanyEntity cultrue = companyService.selectByCat(4);
        JSONObject cultrueObject = JSONObject.parseObject(cultrue.getContent());
        String cbigTitle = cultrueObject.getString("bigtitle");
        String csmallTitle1 = cultrueObject.getString("smalltitle");
        String ccontent1 = cultrueObject.getString("desc");
        String url = cultrueObject.getString("url");

        PeerVO cp = new PeerVO();
        cp.setTitle(csmallTitle1);
        cp.setContent(ccontent1);

        modelMap.put("cultrueBigTitle", cbigTitle);
        modelMap.put("cultruePicture", url);
        modelMap.put("cultruePeer", cp);

        // 企业历史 company6
        CompanyEntity history = companyService.selectByCat(6);
        modelMap.put("history", history.getContent());
        // 时间轴
        List<TimelineEntity> timelineEntities = timelineService.selectByOrder();
        modelMap.put("timeline", timelineEntities);

        // 企业架构 company 7
        CompanyEntity structure =  companyService.selectByCat(7);
        JSONObject structureObject = JSONObject.parseObject(structure.getContent());
        String structurec = structureObject.getString("structure");
        String structurep = structureObject.getString("url");

        modelMap.put("structureContent", structurec);
        modelMap.put("structurePicture", structurep);

        // 企业认证
        // company 8 9
        List<WebimagesEntity> cer = webimagesService.selectPictureByCat(3);
        modelMap.put("certs", cer);
        CompanyEntity cert = companyService.selectByCat(8);
        modelMap.put("cert", cert.getContent());

        return "aboutus";
    }

    @RequestMapping("/intro")
    public String intro(ModelMap modelMap){
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
        // ===============
        modelMap.put("navbread", "公司介绍");

        CompanyEntity intro = companyService.selectByCat(2);
        modelMap.put("content", intro.getContent());

        return "company";
    }

    @RequestMapping("/cultrue")
    public String history(ModelMap modelMap){
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

        modelMap.put("navbread", "企业文化");

        CompanyEntity intro = companyService.selectByCat(9);
        modelMap.put("content", intro.getContent());

        return "company";
    }

    @RequestMapping("/cert")
    public String cert(ModelMap modelMap){
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

        modelMap.put("navbread", "资历认证");

        CompanyEntity intro = companyService.selectByCat(9);
        modelMap.put("content", intro.getContent());

        return "company";
    }

}
