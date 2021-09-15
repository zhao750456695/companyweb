package com.jiehui.chunjiang.controller;


import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.R;
import com.jiehui.chunjiang.entity.InfoEntity;
import com.jiehui.chunjiang.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-12 16:10:26
 */
@RestController
@RequestMapping("generator/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = infoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InfoEntity info = infoService.getById(id);

        return R.ok().put("info", info);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InfoEntity info){
		infoService.save(info);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InfoEntity info){
		infoService.updateById(info);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		infoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
