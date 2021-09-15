/**
 * projectName: chunjiang
 * fileName: ProductController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-08 20:15
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller.en;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.*;
import com.jiehui.chunjiang.service.*;
import com.jiehui.chunjiang.vo.CategoryVO;
import com.jiehui.chunjiang.vo.CategoryVOEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/en")
public class ProductEnController {

    @Autowired
    private GoodsEnService goodsService;

    @Autowired
    private GoodsimagesEnService goodsimagesService;

    @Autowired
    private GoodsCategoryEnService goodsCategoryService;

    @Autowired
    private SampleimageService sampleimageService;

    @RequestMapping("/detail")
    public String detail(@RequestParam(value = "code", defaultValue = "1") String code, ModelMap modelMap){
        GoodsEnEntity goodsEntity = goodsService.selectGoodsByCode(code);
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

        List<GoodsimagesEnEntity> headImages =  goodsimagesService.selectGoodsHeadImagesByCode(code);
        modelMap.put("headImages", headImages);

        List<GoodsimagesEnEntity> detailImages = goodsimagesService.selectGoodsDetailImagesByCode(code);
        modelMap.put("detailImages", detailImages);

        SampleimageEntity headimage = sampleimageService.selectProductImage();
        modelMap.put("headimag", headimage.getUrl());

        return "en/detail";
    }

    @RequestMapping("/product")
    public String product(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "ids", defaultValue = "0") String ids, ModelMap modelMap){
        Map<String, Object> params = new HashMap<>();
        if(ids.equals("0")){
            params.put("page", pn.toString());
            params.put("limit", "12");
            PageUtils page =  goodsService.queryPage(params);
            modelMap.put("ids", 0);
            modelMap.put("page", page);
        } else {
            IPage<GoodsEnEntity> goods = goodsService.selectPageCategoryVo(new Page<GoodsEnEntity>(pn, 12), ids);
            // List<?> list, int totalCount, int pageSize, int currPage
            PageUtils page = new PageUtils(goods.getRecords(), (int)goods.getTotal(), (int)goods.getSize(), (int)goods.getCurrent());
            modelMap.put("ids", ids);
            modelMap.put("page", page);
        }


        List<GoodsCategoryEnEntity> goodsCategoryEntityList = goodsCategoryService.queryGoodsCategoryList();

        List<CategoryVOEN> categoryVOSList = new ArrayList<>();
        // 最简单的二层分类
        for(int i = 0; i < goodsCategoryEntityList.size(); i ++) {
            if (goodsCategoryEntityList.get(i).getParentId().equals(Long.parseLong("0")) ){
                // 找出最顶层的分类
                CategoryVOEN categoryVO = new CategoryVOEN();
                categoryVO.setParentId(goodsCategoryEntityList.get(i).getParentId());
                categoryVO.setId(goodsCategoryEntityList.get(i).getId());
                categoryVO.setCategoryName(goodsCategoryEntityList.get(i).getLabel());
                categoryVO.setCategoryVOS(new ArrayList<>());
                for (int j = 0; j < goodsCategoryEntityList.size(); j ++) {
                    if (goodsCategoryEntityList.get(j).getParentId().equals(categoryVO.getId())) {
                        categoryVO.getCategoryVOS().add(goodsCategoryEntityList.get(j));
                    }
                }
                categoryVOSList.add(categoryVO);
            }
        }

        modelMap.put("categoryList", categoryVOSList);

        SampleimageEntity headimage = sampleimageService.selectProductImage();
        modelMap.put("headimag", headimage.getUrl());

        return "en/product";
    }

}
