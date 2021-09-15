/**
 * projectName: chunjiang
 * fileName: NewsController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-05 20:50
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller.en;

import com.jiehui.chunjiang.entity.NewsEnEntity;
import com.jiehui.chunjiang.entity.SampleimageEntity;
import com.jiehui.chunjiang.service.NewsEnService;
import com.jiehui.chunjiang.service.SampleimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/en")
public class NewsEnController {

    @Autowired
    private SampleimageService sampleimageService;

    @Autowired
    private NewsEnService newsEnService;

    @RequestMapping("/news")
    public String news(ModelMap modelMap){
        SampleimageEntity headimage = sampleimageService.selectNewsImage();
        modelMap.put("headimag", headimage.getUrl());

        List<NewsEnEntity> newsEntityList = new ArrayList<>();
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

        return "en/news";
    }

    @RequestMapping("/newsDetail")
    public String newsDetail(@RequestParam("id") Integer id, ModelMap modelMap) {

        SampleimageEntity headimage = sampleimageService.selectNewsImage();
        modelMap.put("headimag", headimage.getUrl());

        NewsEnEntity news = newsEnService.getById(id);
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

        return "en/newsDetail";
    }
}
