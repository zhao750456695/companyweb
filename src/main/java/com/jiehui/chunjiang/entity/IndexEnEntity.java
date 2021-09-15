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
 * @date 2021-05-06 09:05:25
 */
@Data
@TableName("tb_index")
public class IndexEnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String h1;
	/**
	 * 
	 */
	private String h2;
	/**
	 * 
	 */
	private Integer category;

	private Integer kid;

}
