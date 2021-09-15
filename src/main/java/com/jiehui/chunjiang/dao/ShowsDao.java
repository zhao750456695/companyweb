package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jiehui.chunjiang.entity.ShowsEntity;
import com.jiehui.chunjiang.vo.ShowsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
@Mapper
public interface ShowsDao extends BaseMapper<ShowsVO> {
    void insertShowInfo(@Param("show")ShowsEntity show);
    void updateShowById(@Param("show")ShowsEntity show);
    List<ShowsVO> selectOrderByDate();
}
