package com.jiehui.chunjiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiehui.chunjiang.common.utils.PageUtils;
import com.jiehui.chunjiang.entity.ShowsEntity;
import com.jiehui.chunjiang.vo.ShowsVO;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
public interface ShowsService extends IService<ShowsVO> {

    PageUtils queryPage(Map<String, Object> params);

    void insertShowInfo(ShowsEntity show);

    void updateShowById(ShowsEntity show);

    List<ShowsVO> selectOrderByDate();
}

