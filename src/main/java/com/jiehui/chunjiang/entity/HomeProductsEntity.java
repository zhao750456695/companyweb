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
 * @date 2021-09-14 21:42:08
 */
@Data
@TableName("tb_home_products")
public class HomeProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String label;
	/**
	 * 
	 */
	private String products;
	/**
	 * 
	 */
	private Integer category;

}
