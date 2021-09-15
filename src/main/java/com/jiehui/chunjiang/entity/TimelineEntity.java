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
 * @date 2021-09-13 21:25:35
 */
@Data
@TableName("tb_timeline")
public class TimelineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;

	private String year;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String content;

	private Integer order;

}
