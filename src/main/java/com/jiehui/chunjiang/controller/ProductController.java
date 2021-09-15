/**
 * projectName: chunjiang
 * fileName: ProductController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-08 20:15
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehui.chunjiang.common.utils.GetHtmlMeta;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.*;
import com.jiehui.chunjiang.service.*;
import com.jiehui.chunjiang.vo.CategoryVO;
import com.jiehui.chunjiang.vo.FilterVO;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsimagesService goodsimagesService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping("/detail")
    public String detail(@RequestParam(value = "code", defaultValue = "1") String code, ModelMap modelMap){
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
        GoodsEntity goodsEntity = goodsService.selectGoodsByCode(code);
        modelMap.put("goods", goodsEntity);

        // 参数和产品亮点
        String params = goodsEntity.getParams();
        if (!params.equals("")) {
            String[] paramsArray = params.split("@");
            modelMap.put("params", paramsArray);
        } else {
            modelMap.put("params", new ArrayList<>());
        }

        String brilliant = goodsEntity.getBrilliant();
        if (!brilliant.equals("")) {
            String[] brilliantArray = brilliant.split("@");
            modelMap.put("brilliant", brilliantArray);
        } else {
            modelMap.put("brilliant", new ArrayList<>());
        }

        List<GoodsimagesEntity> headImages =  goodsimagesService.selectGoodsHeadImagesByCode(code);
        modelMap.put("headImages", headImages);

        List<GoodsimagesEntity> detailImages = goodsimagesService.selectGoodsDetailImagesByCode(code);
        modelMap.put("detailImages", detailImages);

        return "detail";
    }

    @Autowired
    private FilterService filterService;

    @Autowired
    private WebimagesService webimagesService;

    @Autowired
    private SampleimageService sampleimageService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/product")
    public String product(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "filterIds", defaultValue = "[]") String[] filterIds, ModelMap modelMap){
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
        List<FilterEntity> filterEntities = filterService.queryFilterList();

        List<FilterVO> filterVOS = new ArrayList<>();
        // 组成 vo list
        for (int i=0; i<filterEntities.size(); i++) {
            if (filterEntities.get(i).getParentId() == 0) {
                FilterVO filterVO = new FilterVO();
                List<FilterEntity> filters = new ArrayList<>();
                filterVO.setFilterEntity(filterEntities.get(i));
                for (int j=0; j<filterEntities.size(); j++) {
                    if (filterEntities.get(i).getId() == filterEntities.get(j).getParentId()) {
                        filters.add(filterEntities.get(j));
                    }
                }
                filterVO.setFilterEntityList(filters);
                filterVOS.add(filterVO);
            }
        }

        modelMap.put("filterVOList", filterVOS);

        // 构造商品
        Map<String, Object> params = new HashMap<>();
        if(filterIds[0].equals("[]")){
            params.put("page", pn.toString());
            params.put("limit", "12");
            PageUtils page =  goodsService.queryPage(params);
            modelMap.put("ids", 0);
            modelMap.put("page", page);
        } else {
            // 筛选的商品
            ArrayList<String> filterIdList = new ArrayList<>();
            for (int m = 0; m < filterIds.length; m++) {
                if(!filterService.getById(Long.parseLong(filterIds[m])).getParentId().equals((long)0)){
                    // 只筛选二级分类
                    filterIdList.add(filterIds[m]);
                }
            }
            IPage<GoodsEntity> goods = goodsService.queryGoodsInFilter(new Page<GoodsEntity>(pn, 12), filterIdList);
            PageUtils page = new PageUtils(goods.getRecords(), (int) goods.getTotal(), (int) goods.getSize(), (int) goods.getCurrent());
            modelMap.put("page", page);
        }

        modelMap.put("filtersArray", filterIds);

//        List<GoodsCategoryEntity> goodsCategoryEntityList = goodsCategoryService.queryGoodsCategoryList();
//
//        List<CategoryVO> categoryVOSList = new ArrayList<>();
        // 最简单的二层分类
//        for(int i = 0; i < goodsCategoryEntityList.size(); i ++) {
//            if (goodsCategoryEntityList.get(i).getParentId().equals(Long.parseLong("0")) ){
//                // 找出最顶层的分类
//                CategoryVO categoryVO = new CategoryVO();
//                categoryVO.setParentId(goodsCategoryEntityList.get(i).getParentId());
//                categoryVO.setId(goodsCategoryEntityList.get(i).getId());
//                categoryVO.setCategoryName(goodsCategoryEntityList.get(i).getLabel());
//                categoryVO.setCategoryVOS(new ArrayList<>());
//                for (int j = 0; j < goodsCategoryEntityList.size(); j ++) {
//                    if (goodsCategoryEntityList.get(j).getParentId().equals(categoryVO.getId())) {
//                        categoryVO.getCategoryVOS().add(goodsCategoryEntityList.get(j));
//                    }
//                }
//                categoryVOSList.add(categoryVO);
//            }
//        }
//
//        modelMap.put("categoryList", categoryVOSList);

        return "product";
    }

}
