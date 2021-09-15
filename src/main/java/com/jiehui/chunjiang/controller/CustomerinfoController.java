package com.jiehui.chunjiang.controller;

import com.jiehui.chunjiang.common.utils.R;
import com.jiehui.chunjiang.entity.CustomerinfoEntity;
import com.jiehui.chunjiang.service.CustomerinfoService;
import org.apache.http.entity.ContentType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-03 18:38:37
 */
@RestController
@RequestMapping("generator/customerinfo")
public class CustomerinfoController {
    @Autowired
    private CustomerinfoService customerinfoService;



    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:customerinfo:save")
    public R save(@RequestBody CustomerinfoEntity customerinfo){
		customerinfoService.save(customerinfo);


        return R.ok();
    }


}
