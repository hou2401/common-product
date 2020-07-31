package com.itrus.common.params.uag;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 扩展字段实体类
 * @author wgx52
 *
 */
@ToString
@Data
@AllArgsConstructor
public class ExtParams implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	
	/**
	 * 扩展属性名称
	 */
	private String name;

	/**
	 * 扩展属性值
	 */
	private String value;
	
	
	/**
	 * 扩展属性默认值
	 */
	private String defaultValue;

}
