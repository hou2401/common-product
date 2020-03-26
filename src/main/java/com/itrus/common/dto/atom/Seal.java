package com.itrus.common.dto.atom;

import lombok.Data;
import lombok.ToString;

/**
 * 印章相关url
 * @author wen_guoxing
 *
 */
@Data
@ToString
public class Seal {

	/**
	 * 创建椭圆印章
	 */
	private String createEllipseSeal;

	/**
	 * 创建圆形印章
	 */
	private String createCircularSeal;

	/**
	 * 创建双行人名印章
	 */
	private String createDoubleRowSeal;
	/**
	 * 创建单行人名印章
	 */
	private String createSingleRowSeal;
	/**
	 * 印章透明处理
	 */
	private String sealLimpid; 
	
}
