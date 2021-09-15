/**
 * projectName: chunjiang
 * fileName: IndexController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-03 20:46
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller.en;

import com.alibaba.fastjson.JSONObject;
import com.jiehui.chunjiang.entity.*;
import com.jiehui.chunjiang.service.*;
import com.jiehui.chunjiang.vo.IndexBigPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/en")
public class IndexEnController {
//
    @Autowired
    private WebimagesEnService webimagesService;

    @Autowired
    private NewsEnService newsService;

    @Autowired
    private IndexEnService indexService;

    @Autowired
    private GoodsEnService goodsService;

    @Autowired
    private CompanyEnService companyService;

    @Autowired
    private SampleimageService sampleimageService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) throws ParseException {
        List<WebimagesEnEntity> webimagesEntityList = webimagesService.selectBigPicture();
        webimagesEntityList.sort(Comparator.comparing(WebimagesEnEntity::getCategory));
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

        List<NewsEnEntity> newsEntityList = new ArrayList<>();
        newsEntityList = newsService.selectThreeNews();
        for(int i=0; i<newsEntityList.size(); i++){
            String strDateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            newsEntityList.get(i).setDt(sdf.format(newsEntityList.get(i).getUpdated()));
        }
        modelMap.put("newsList", newsEntityList);

        // 关于公司
        IndexEnEntity about = new IndexEnEntity();
        about = indexService.selectAbout();

        modelMap.put("abouth1", about.getH1());
        modelMap.put("abouth2", about.getH2());

        List<IndexEnEntity> aboutItems = new ArrayList<>();
        aboutItems = indexService.selectAboutItems();

        modelMap.put("aboutlist", aboutItems);

        List<IndexEnEntity> aboutNums = new ArrayList<>();
        aboutNums = indexService.selectAboutNums();

        modelMap.put("aboutlist1", aboutNums);

        // 公司动态
        IndexEnEntity dynamic = new IndexEnEntity();
        dynamic = indexService.selectNews();

        modelMap.put("dynamic", dynamic);

        IndexEnEntity product = new IndexEnEntity();
        product = indexService.selectProduct();

        modelMap.put("product", product);

        IndexEnEntity tech = new IndexEnEntity();
        tech = indexService.selectTech();

        modelMap.put("tech", tech);

        // 产品
        List<GoodsEnEntity> goodsList = goodsService.selectHomeGoods();
        modelMap.put("productList", goodsList);

        SampleimageEntity techimag = sampleimageService.selectIndexTechImage();
        modelMap.put("techimag", techimag.getUrl());

        return "en/index";
    }


    @RequestMapping("/contactus")
    public String contactus(ModelMap modelMap){
        CompanyEnEntity companyEntity = companyService.selectContactUs();
        String contact = companyEntity.getContent();
        JSONObject jsonObject = JSONObject.parseObject(contact);
        String address = jsonObject.getString("address");
        String phone = jsonObject.getString("phone");
        String mail = jsonObject.getString("mail");
        String fax = jsonObject.getString("fax");
        String web = jsonObject.getString("web");
        modelMap.put("address", address);
        modelMap.put("phone", phone);
        modelMap.put("mail", mail);
        modelMap.put("fax", fax);
        modelMap.put("web", web);

        SampleimageEntity headimage = sampleimageService.selectContactImage();
        modelMap.put("headimag", headimage.getUrl());

        return "en/contactus";
    }

}
