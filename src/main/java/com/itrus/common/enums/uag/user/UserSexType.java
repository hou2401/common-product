package com.itrus.common.enums.uag.user;

import lombok.Getter;

/**
 * 性别类型
 * @author wgx52
 *
 */
@Getter
public enum UserSexType{
	/**
	 * 男（默认）
	 */
	MAN("0", "男（默认）"),
	/**
	 * 女
	 */
	WOMAN("1", "女");
	
	private String code;
	private String name;

	private UserSexType(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
