/**
 * projectName: chunjiang
 * fileName: FilterVO.java
 * packageName: com.jiehui.chunjiang.vo
 * date: 2021-09-14 13:20
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.vo;


import com.jiehui.chunjiang.entity.FilterEntity;
import lombok.Data;

import java.util.List;

@Data
public class FilterVO {
    private FilterEntity filterEntity; //
    private List<FilterEntity> filterEntityList;
}
