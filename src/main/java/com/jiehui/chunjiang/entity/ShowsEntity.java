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
 * @date 2021-09-09 18:45:26
 */
@Data
@TableName("tb_shows")
public class ShowsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

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
}
