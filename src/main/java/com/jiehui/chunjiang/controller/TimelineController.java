package com.jiehui.chunjiang.controller;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.R;
import com.jiehui.chunjiang.entity.TimelineEntity;
import com.jiehui.chunjiang.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-13 21:25:35
 */
@RestController
@RequestMapping("generator/timeline")
public class TimelineController {
    @Autowired
    private TimelineService timelineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = timelineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{year}")
    public R info(@PathVariable("year") String year){
		TimelineEntity timeline = timelineService.getById(year);

        return R.ok().put("timeline", timeline);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TimelineEntity timeline){
		timelineService.save(timeline);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TimelineEntity timeline){
		timelineService.updateById(timeline);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] years){
		timelineService.removeByIds(Arrays.asList(years));

        return R.ok();
    }

}
