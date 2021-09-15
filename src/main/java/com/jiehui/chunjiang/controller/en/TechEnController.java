/**
 * projectName: chunjiang
 * fileName: TechController.java
 * packageName: com.jiehui.chunjiang.controller
 * date: 2021-04-09 15:57
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.controller.en;

import com.jiehui.chunjiang.entity.SampleimageEntity;
import com.jiehui.chunjiang.entity.TechimagesEntity;
import com.jiehui.chunjiang.service.SampleimageService;
import com.jiehui.chunjiang.service.TechimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/en")
public class TechEnController {

    @Autowired
    private TechimagesService techimagesService;

    @Autowired
    private SampleimageService sampleimageService;

    @RequestMapping("/tech")
    public String tech(@RequestParam(value = "cat", defaultValue = "1") Integer cat, ModelMap modelMap){
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

        SampleimageEntity headimage = sampleimageService.selectTechImage();
        modelMap.put("headimag", headimage.getUrl());

        return "en/tech";
    }
}
