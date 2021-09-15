package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.InfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-12 16:10:26
 */
@Mapper
public interface InfoDao extends BaseMapper<InfoEntity> {
    List<InfoEntity> getInfo();
}
