/**
 * projectName: chunjiang
 * fileName: APIController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-05-09 10:00
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller.en;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.R;
import com.jiehui.chunjiang.common.wxpusher.client.WxPusher;
import com.jiehui.chunjiang.common.wxpusher.client.bean.Message;
import com.jiehui.chunjiang.common.wxpusher.client.bean.MessageResult;
import com.jiehui.chunjiang.common.wxpusher.client.bean.Result;
import com.jiehui.chunjiang.entity.CompanyEntity;
import com.jiehui.chunjiang.entity.CustomerinfoEntity;
import com.jiehui.chunjiang.entity.GoodsEntity;
import com.jiehui.chunjiang.entity.NewsEnEntity;
import com.jiehui.chunjiang.service.CustomerinfoService;
import com.jiehui.chunjiang.service.GoodsCategoryService;
import com.jiehui.chunjiang.service.GoodsService;
import com.jiehui.chunjiang.service.NewsEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("en/api")
public class APIEnController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private CustomerinfoService customerinfoService;

    @RequestMapping("/detail")
    public String detail(){
        return "detail";
    }

    @RequestMapping("/product")
    public R product(@RequestParam(value = "ids[]") String[] ids){
        IPage<GoodsEntity> goods = goodsService.selectPageCategoryVo(new Page<GoodsEntity>(1, 12), "2");
        return R.ok().put("goods", goods);
    }

    @RequestMapping("/contact")
    public R contact(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "tel") String tel, @RequestParam(value = "yourwords") String yourwords){

        CustomerinfoEntity customerinfoEntity = new CustomerinfoEntity();
        customerinfoEntity.setIname(name);
        customerinfoEntity.setEmail(email);
        customerinfoEntity.setPhone(tel);
        customerinfoEntity.setContent(yourwords);
        customerinfoEntity.setIsread(false);
        customerinfoEntity.setDt(new Date());
        customerinfoService.save(customerinfoEntity);

        Message message = new Message();
        message.setAppToken("AT_58LWSlcErVIwyD8EDRdGdGqlThNvXpbN");
        message.setContentType(Message.CONTENT_TYPE_TEXT);
        message.setContent("公司官网收到新的客户咨询，请及时查看！");
        message.setUid("UID_3jXRWZjHwlyZseBe7bsSRQMlNuYP");
        message.setUrl("http://www.chunjiangshoes.com/index.html");//可选参数
        Result<List<MessageResult>> result = WxPusher.send(message);
        return R.ok();
    }

    @Autowired
    private NewsEnService newsEnService;

    @RequestMapping("/news")
    public R news(@RequestParam(value = "page") String pageIndex, ModelMap modelMap){


        Map<String, Object> params = new HashMap<>();

        params.put("page", pageIndex);
        params.put("limit", "15");


        PageUtils page = newsEnService.queryPage(params);

                Collections.sort((List<NewsEnEntity>)page.getList(), new Comparator<NewsEnEntity>() {

            @Override
            public int compare(NewsEnEntity o1, NewsEnEntity o2) {
                if (o1.getUpdated().after(o2.getUpdated())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        if (pageIndex.equals("1")) {
            for ( int i = 0; i < 3; i++) {
                page.getList().remove( 0);
            }
        }
        for(int i=0; i<page.getList().size(); i++){
            String strDateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            ((NewsEnEntity)page.getList().get(i)).setDt(sdf.format(((NewsEnEntity)page.getList().get(i)).getUpdated()));
            String yearMonth = ((NewsEnEntity)page.getList().get(i)).getDt().substring(0,7);
            ((NewsEnEntity)page.getList().get(i)).setYearMonth(yearMonth);
            String day = ((NewsEnEntity)page.getList().get(i)).getDt().substring(8);
            if (day.startsWith("0")) {
                day = day.substring(1);
            }
            ((NewsEnEntity)page.getList().get(i)).setDay(day);
        }
        // modelMap.put("page", page.getList());
        if (pageIndex.equals("1")) {
            if (page.getList().size() < 12) {
                return R.ok().put("news", page.getList()).put("more", false);
            } else {
                return R.ok().put("news", page.getList()).put("more", true);
            }
        }else {
            if (page.getList().size() < 15) {
                return R.ok().put("news", page.getList()).put("more", false);
            } else {
                return R.ok().put("news", page.getList()).put("more", true);
            }
        }

    }

}
