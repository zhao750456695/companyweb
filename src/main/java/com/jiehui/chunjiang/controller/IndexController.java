/**
 * projectName: chunjiang
 * fileName: IndexController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-03 20:46
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jiehui.chunjiang.common.utils.GetHtmlMeta;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.*;
import com.jiehui.chunjiang.service.*;
import com.jiehui.chunjiang.vo.HomeGoodsVO;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import com.jiehui.chunjiang.vo.IndexBigPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
//
    @Autowired
    private WebimagesService webimagesService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SampleimageService sampleimageService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private HomeProductsService homeProductsService;

    @RequestMapping("/index")
    public String index1(ModelMap modelMap){
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


        // ==================== 轮播图
        List<WebimagesEntity> webimagesEntityList = webimagesService.selectBigPicture();
        webimagesEntityList.sort(Comparator.comparing(WebimagesEntity::getCategory));
        List<IndexBigPicture> bigPictures = new ArrayList<>();
        for (int i = 0; i < webimagesEntityList.size(); i++){
            if (webimagesEntityList.get(i).getCategory() == 1) {
                IndexBigPicture bigPicture = new IndexBigPicture();
                String[] urlStr = webimagesEntityList.get(i).getUrl().split("\\.");
                if (urlStr[urlStr.length-1].equals("mp4")) {
                    bigPicture.setIsVideo(true);
                    bigPicture.setIsImg(false);
                }else {
                    bigPicture.setIsVideo(false);
                    bigPicture.setIsImg(true);
                }
//                bigPicture.setBigTitle(webimagesEntityList.get(i).getBigTitle());
//                bigPicture.setSmallTitle(webimagesEntityList.get(i).getSmallTitle());
//                bigPicture.setLink(webimagesEntityList.get(i).getLink());
                bigPicture.setUrl(webimagesEntityList.get(i).getUrl());
                bigPictures.add(bigPicture);
            }
        }
        modelMap.put("list", bigPictures);
        // =======================================================

        // =========== 关于春江
        // 简介
        // 数据表 tb_company，category 1
        CompanyEntity companyEntity = companyService.selectIntro();
        String intro = companyEntity.getContent();
        JSONObject introObject = JSONObject.parseObject(intro);
        String bigTitle = introObject.getString("bigtitle");
        String smallTitle = introObject.getString("smalltitle");
        String content = introObject.getString("desc");

        // 偷懒使用selectTechImage()，categoryid是16
        SampleimageEntity sampleimg = sampleimageService.selectIndexTechImage();
        modelMap.put("bigTitle", bigTitle);
        modelMap.put("smallTitle", smallTitle);
        modelMap.put("content", content);
        modelMap.put("introimg", sampleimg.getUrl());

        // 数据
        List<IndexEntity> aboutNums = new ArrayList<>();
        aboutNums = indexService.selectAboutNums();

        modelMap.put("aboutlist1", aboutNums);
        // =======================================================

        // ================ 动态
        List<NewsEntity> newsEntityList1 = new ArrayList<>();
        newsEntityList1 = newsService.selectThreeNews();
        List<NewsEntity> newsEntityList = newsEntityList1.subList(0, 2);
        for(int i=0; i<newsEntityList.size(); i++){
            String strDateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            newsEntityList.get(i).setDt(sdf.format(newsEntityList.get(i).getUpdated()));
        }
        modelMap.put("newsList", newsEntityList);
        // ===================================================================


        // ==================== 产品
        // 获取分类
        List<HomeProductsEntity> homeProductsEntities = homeProductsService.getAll();
        List<HomeGoodsVO> homeGoodsVOList = new ArrayList<>();
        // 获取商品
        for (int i=0; i<homeProductsEntities.size(); i++) {
            HomeGoodsVO goodsVO = new HomeGoodsVO();
            goodsVO.setCat(homeProductsEntities.get(i).getLabel());
            List<GoodsEntity> goodsEntities = new ArrayList<>();
            String cats = homeProductsEntities.get(i).getProducts();
            String[] pid = cats.split(",");
            for (int j=0; j<pid.length; j++) {
               GoodsEntity goods = goodsService.getById(Long.parseLong(pid[j]));
               goodsEntities.add(goods);
            }
            goodsVO.setGoodsList(goodsEntities);
            homeGoodsVOList.add(goodsVO);
        }

        modelMap.put("productList", homeGoodsVOList);
        modelMap.put("productList1", homeGoodsVOList.get(0));
        modelMap.put("productList2", homeGoodsVOList.get(1));
        modelMap.put("productList3", homeGoodsVOList.get(2));
        modelMap.put("productList4", homeGoodsVOList.get(3));
//        modelMap.put("productList1", goodsList);
//        modelMap.put("productList2", goodsList);
//        modelMap.put("productList2", goodsList);
        // ==================================================

        // ==================== 荣誉资质
        List<WebimagesEntity> cert = webimagesService.selectPictureByCat(3);
        modelMap.put("certs", cert);
        // ===================================

        // ==================== 合作伙伴
        List<WebimagesEntity> partner = webimagesService.selectPictureByCat(88);
        modelMap.put("partners", partner);
        // =================================

        // =================== 安全鞋资讯
        List<InfoEntity> infos = infoService.getInfo();
        List<InfoEntity> infosl= new ArrayList<>();
        List<InfoEntity> infosr = new ArrayList<>();
        if (infos.size() > 2) {
            int num = infos.size() / 2;
            infosl = infos.subList(0, num);
            infosr = infos.subList(num, infos.size()-1);
        } else {
            infosl = infos;
        }
        modelMap.put("infosl", infosl);
        modelMap.put("infoslr", infosr);
        // =================================================

        return "index1";
    }


    @RequestMapping("/index8")
    public String index(ModelMap modelMap) throws ParseException {

        GetHtmlMeta getHtmlMeta = new GetHtmlMeta();
        HtmlMetaVO htmlMetaVO = getHtmlMeta.getHtmlMetaZH();
        modelMap.put("title", htmlMetaVO.getTitle());
        modelMap.put("websiteName", htmlMetaVO.getWebsiteName());
        modelMap.put("iconUrl", htmlMetaVO.getIconUrl());
        modelMap.put("description", htmlMetaVO.getDescription());
        modelMap.put("keywords", htmlMetaVO.getKeyWords());


        List<WebimagesEntity> webimagesEntityList = webimagesService.selectBigPicture();
        webimagesEntityList.sort(Comparator.comparing(WebimagesEntity::getCategory));
        List<IndexBigPicture> bigPictures = new ArrayList<>();
        for (int i = 0; i < webimagesEntityList.size(); i++){
            IndexBigPicture bigPicture = new IndexBigPicture();
            String[] urlStr = webimagesEntityList.get(i).getUrl().split("\\.");
            if (urlStr[urlStr.length-1].equals("mp4")) {
                bigPicture.setIsVideo(true);
                bigPicture.setIsImg(false);
            }else {
                bigPicture.setIsVideo(false);
                bigPicture.setIsImg(true);
            }
            bigPicture.setBigTitle(webimagesEntityList.get(i).getBigTitle());
            bigPicture.setSmallTitle(webimagesEntityList.get(i).getSmallTitle());
            bigPicture.setLink(webimagesEntityList.get(i).getLink());
            bigPicture.setUrl(webimagesEntityList.get(i).getUrl());
            bigPictures.add(bigPicture);
        }
        modelMap.put("list", bigPictures);

        List<NewsEntity> newsEntityList = new ArrayList<>();
        newsEntityList = newsService.selectThreeNews();
        for(int i=0; i<newsEntityList.size(); i++){
            String strDateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            newsEntityList.get(i).setDt(sdf.format(newsEntityList.get(i).getUpdated()));
        }
        modelMap.put("newsList", newsEntityList);

        // 关于公司
        IndexEntity about = new IndexEntity();
        about = indexService.selectAbout();

        modelMap.put("abouth1", about.getH1());
        modelMap.put("abouth2", about.getH2());

        List<IndexEntity> aboutItems = new ArrayList<>();
        aboutItems = indexService.selectAboutItems();

        modelMap.put("aboutlist", aboutItems);

        List<IndexEntity> aboutNums = new ArrayList<>();
        aboutNums = indexService.selectAboutNums();

        modelMap.put("aboutlist1", aboutNums);

        // 公司动态
        IndexEntity dynamic = new IndexEntity();
        dynamic = indexService.selectNews();

        modelMap.put("dynamic", dynamic);

        IndexEntity product = new IndexEntity();
        product = indexService.selectProduct();

        modelMap.put("product", product);

        IndexEntity tech = new IndexEntity();
        tech = indexService.selectTech();

        modelMap.put("tech", tech);

        // 产品
        List<GoodsEntity> goodsList = goodsService.selectHomeGoods();

        modelMap.put("productList", goodsList);

        return "index";
    }


    @RequestMapping("/contactus")
    public String contactus(ModelMap modelMap){
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
//        CompanyEntity companyEntity = companyService.selectContactUs();
//        String contact = companyEntity.getContent();
//        JSONObject jsonObject = JSONObject.parseObject(contact);
//        String address = jsonObject.getString("address");
//        String phone = jsonObject.getString("phone");
//        String mail = jsonObject.getString("mail");
//        String fax = jsonObject.getString("fax");
//        String web = jsonObject.getString("web");
//        modelMap.put("address", address);
//        modelMap.put("phone", phone);
//        modelMap.put("mail", mail);
//        modelMap.put("fax", fax);
//        modelMap.put("web", web);
        return "contactus";
    }


}
