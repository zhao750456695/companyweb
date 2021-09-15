package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.RecruitEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
@Mapper
public interface RecruitDao extends BaseMapper<RecruitEntity> {
	List<RecruitEntity> selectOrderByDate();
}
