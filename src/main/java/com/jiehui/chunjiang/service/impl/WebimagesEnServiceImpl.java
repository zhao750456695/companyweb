package com.jiehui.chunjiang.service.impl;

import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.common.utils.Query;
import com.jiehui.chunjiang.dao.WebimagesEnDao;
import com.jiehui.chunjiang.entity.WebimagesEnEntity;
import com.jiehui.chunjiang.service.WebimagesEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;





@Service("webimagesEnService")
public class WebimagesEnServiceImpl extends ServiceImpl<WebimagesEnDao, WebimagesEnEntity> implements WebimagesEnService {

    @Autowired
    private WebimagesEnDao webimagesEnDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebimagesEnEntity> page = this.page(
                new Query<WebimagesEnEntity>().getPage(params),
                new QueryWrapper<WebimagesEnEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<WebimagesEnEntity> selectBigPicture() {
        return webimagesEnDao.selectBigPicture();
    }

}