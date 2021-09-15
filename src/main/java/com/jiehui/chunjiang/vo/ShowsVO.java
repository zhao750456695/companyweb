/**
 * projectName: chunjiang
 * fileName: ShowsVO.java
 * packageName: com.jiehui.chunjiang.vo
 * date: 2021-09-15 12:19
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiehui.chunjiang.entity.ShowimageEntity;
import lombok.Data;

import java.util.List;
@Data
@TableName("tb_shows")
public class ShowsVO {
    /**
     * ddd
     */
    private String title;
    /**
     * 发布日期
     */
    private String updated;
    /**
     * 描述
     */
    private String descri;
    /**
     * 内容
     */
    private String content;
    /**
     *
     */
    @TableId
    private Integer id;

    @TableField(exist = false)
    private List<ShowimageEntity> urls;
}
