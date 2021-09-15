package com.jiehui.chunjiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiehui.chunjiang.dao.CustomerinfoDao;
import com.jiehui.chunjiang.entity.CustomerinfoEntity;
import com.jiehui.chunjiang.service.CustomerinfoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerinfoService")
public class CustomerinfoServiceImpl extends ServiceImpl<CustomerinfoDao, CustomerinfoEntity> implements CustomerinfoService {

}