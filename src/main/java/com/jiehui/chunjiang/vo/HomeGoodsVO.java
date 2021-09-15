/**
 * projectName: chunjiang
 * fileName: HomeGoodsVO.java
 * packageName: com.jiehui.chunjiang.vo
 * date: 2021-09-13 16:30
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.vo;

import com.jiehui.chunjiang.entity.GoodsEntity;
import lombok.Data;

import java.util.List;

@Data
public class HomeGoodsVO {

    private String cat;
    private List<GoodsEntity> goodsList;
}
