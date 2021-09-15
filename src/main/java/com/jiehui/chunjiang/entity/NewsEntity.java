package com.jiehui.chunjiang.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-20 19:52:16
 */
@Data
@TableName("tb_news")
public class NewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private Date updated;
	/**
	 * 
	 */
	private String author;
	/**
	 * 
	 */
	private String descri;
	/**
	 * 
	 */
	private String content;

	private String cover;

	@TableField(exist = false)
	private String dt;

	@TableField(exist = false)
	private String day;

	@TableField(exist = false)
	private String yearMonth;
}
