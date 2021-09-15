package com.jiehui.chunjiang.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-12 16:10:26
 */
@Data
@TableName("tb_info")
public class InfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布日期
	 */
	private String updated;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 
	 */
	@TableId
	private Integer id;

}
