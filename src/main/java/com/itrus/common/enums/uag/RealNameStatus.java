package com.itrus.common.enums.uag;

import lombok.Getter;

/**
 * 实名状态
 * @author wgx52
 *
 */
@Getter
public enum RealNameStatus{
	/**
	 *未实名（默认）
	 */
	NO("0", "未实名（默认）"),
	/**
	 *已实名
	 */
	YES("1", "已实名")
	;
	
	private String code;
	private String name;

	private RealNameStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
