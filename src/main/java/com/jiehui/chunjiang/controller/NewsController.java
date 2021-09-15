/**
 * projectName: chunjiang
 * fileName: NewsController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-05 20:50
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiehui.chunjiang.common.utils.GetHtmlMeta;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.*;
import com.jiehui.chunjiang.service.*;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import com.jiehui.chunjiang.vo.ShowsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class NewsController {

    @Autowired
    private SampleimageService sampleimageService;

    @Autowired
    private NewsService newsEnService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private WebimagesService webimagesService;

    @RequestMapping("/exbs")
    public String exbs(@RequestParam(value = "pn", defaultValue = "1") Integer pn, ModelMap modelMap){
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
        // 获取展会图片
        // 获取全部展会信息
        Map<String, Object> params = new HashMap<>();
        params.put("page", pn.toString());
        params.put("limit", "3");
        PageUtils page =  showsService.queryPage(params);
        List<ShowsVO> showsVOS = (List<ShowsVO>)page.getList();
        for (int i=0; i<showsVOS.size(); i++) {
            List<ShowimageEntity> showimageEntities = showimageService.getByShowId(showsVOS.get(i).getId());
            showsVOS.get(i).setUrls(showimageEntities);
        }
        modelMap.put("page", page);
        return "exb";
    }

    @Autowired
    private ShowimageService showimageService;

    @Autowired
    private ShowsService showsService;

    @RequestMapping("/news")
    public String news(ModelMap modelMap){
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
//        SampleimageEntity headimage = sampleimageService.selectNewsImage();
//        modelMap.put("headimag", headimage.getUrl());
        // =========================================== 展会风采
        // 最新展会
        // 获取全部展会，得到日期最新的
        List<ShowsVO> shows = showsService.selectOrderByDate();
        modelMap.put("show", shows.get(shows.size()-1));
        // 轮播图
        List<ShowimageEntity> showimageList = showimageService.getByShowId(shows.get(shows.size()-1).getId());
        modelMap.put("showImages", showimageList);

        // 历届展会
        // 轮播图
        List<ShowimageEntity> showimageEntities = showimageService.getByShowId(0);
        modelMap.put("pastShowImages", showimageEntities);

        // ============================================ 公司新闻
        List<NewsEntity> newsEntityList = new ArrayList<>();
        newsEntityList = newsEnService.selectThreeNews();
        for(int i=0; i<newsEntityList.size(); i++){
            String strDateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            newsEntityList.get(i).setDt(sdf.format(newsEntityList.get(i).getUpdated()));
            String yearMonth = newsEntityList.get(i).getDt().substring(0,7);
            newsEntityList.get(i).setYearMonth(yearMonth);
            String day = newsEntityList.get(i).getDt().substring(8);
            if (day.startsWith("0")) {
                day = day.substring(1);
            }
            newsEntityList.get(i).setDay(day);
        }
        modelMap.put("newsList", newsEntityList);

        return "news";
    }

    @RequestMapping("/exb_detail")
    public String exbDetail(@RequestParam("id") Integer id, ModelMap modelMap) {

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

        ShowsVO show = showsService.getById(id);
        String content = show.getContent();
        modelMap.put("content", content);

        String title = show.getTitle();
        modelMap.put("title", title);

        modelMap.put("author", "春江鞋业");

        String dateTime = show.getUpdated();

        modelMap.put("dateTime", dateTime);

        return "newsDetail";
    }

    @RequestMapping("/newsDetail")
    public String newsDetail(@RequestParam("id") Integer id, ModelMap modelMap) {

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

        SampleimageEntity headimage = sampleimageService.selectNewsImage();
        modelMap.put("headimag", headimage.getUrl());

        NewsEntity news = newsEnService.getById(id);
        String content = news.getContent();
        modelMap.put("content", content);

        String title = news.getTitle();
        modelMap.put("title", title);

        String author = news.getAuthor();
        modelMap.put("author", author);

        Date dateTime = news.getUpdated();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String dt = sdf.format(dateTime);
        modelMap.put("dateTime", dt);

        return "newsDetail";
    }

    @Autowired
    private InfoService infoService;

    @RequestMapping("/infoDetail")
    public String infoDetail(@RequestParam("id") Integer id, ModelMap modelMap) {

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

//        SampleimageEntity headimage = sampleimageService.selectNewsImage();
//        modelMap.put("headimag", headimage.getUrl());
        InfoEntity info = infoService.getById(id);
        // NewsEntity news = newsEnService.getById(id);
        String content = info.getContent();
        modelMap.put("content", content);

        String title = info.getTitle();
        modelMap.put("title", title);

        modelMap.put("author", "春江鞋业");

        String dateTime = info.getUpdated();

        modelMap.put("dateTime", dateTime);

        return "newsDetail";
    }

}
