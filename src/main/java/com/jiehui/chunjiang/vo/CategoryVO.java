/**
 * projectName: chunjiang
 * fileName: CategoryVO.java
 * packageName: com.jiehui.chunjiang.vo
 * date: 2021-05-08 15:49
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.vo;

import com.jiehui.chunjiang.entity.GoodsCategoryEntity;

import java.util.List;

// 传给thymeleaf的分类对象
public class CategoryVO {
    private Long id;

    private Long parentId;

    private String categoryName;

    private List<GoodsCategoryEntity> categoryVOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<GoodsCategoryEntity> getCategoryVOS() {
        return categoryVOS;
    }

    public void setCategoryVOS(List<GoodsCategoryEntity> categoryVOS) {
        this.categoryVOS = categoryVOS;
    }


}
