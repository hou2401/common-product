package com.itrus.common.enums.uag;

import lombok.Getter;

/**
 * 查询深度
 * @author wgx52
 *
 */
@Getter
public enum QueryType{
	/**
	 *全量
	 */
	ALL("0", "全量"),
	/**
	 * 一级（默认）
	 */
	ONE("1", "一级（默认）")
	;
	
	private String code;
	private String name;

	private QueryType(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
