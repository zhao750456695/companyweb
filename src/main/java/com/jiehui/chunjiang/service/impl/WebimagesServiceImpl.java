package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.WebimagesDao;
import com.jiehui.chunjiang.entity.WebimagesEntity;
import com.jiehui.chunjiang.service.WebimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("webimagesService")
public class WebimagesServiceImpl implements WebimagesService {

    @Autowired
    private WebimagesDao webimagesDao;

    @Override
    public List<WebimagesEntity> selectBigPicture() {

        return webimagesDao.selectBigPicture();
    }

    @Override
    public List<WebimagesEntity> selectPictureByCat(Integer cat) {
        return webimagesDao.selectPictureByCat(cat);
    }
}