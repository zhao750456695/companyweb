/**
 * projectName: chunjiang
 * fileName: IndexBigPicture.java
 * packageName: com.jiehui.chunjiang.vo
 * date: 2021-04-28 9:32
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class IndexBigPicture {

    private String url;

    private String bigTitle;

    private String smallTitle;

    private String link;

    private Boolean isVideo;

    private Boolean isImg;
}
