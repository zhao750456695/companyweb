package com.jiehui.chunjiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehui.chunjiang.entity.FilterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FilterDao extends BaseMapper<FilterEntity> {
	List<FilterEntity> queryFilterList();

	List<FilterEntity> queryFilterListEN();

	FilterEntity queryFilterById(@Param("id")Integer id);

    List<FilterEntity> queryFilterByParentId(@Param("parentId")Integer parentId);

	void insertParentFilter(@Param("parentFilter")FilterEntity parentFilter);

	void deleteFilterItems(@Param("parentId")Long parentId);

	void updateParentFilter(@Param("parentId")Long parentId, @Param("label")String label, @Param("id")Long id);

	void deleteFilterById(@Param("id")Long id);
}
