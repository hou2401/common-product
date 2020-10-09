package com.itrus.common.enums.uag.user;

import lombok.Getter;

/**
 * 个人实名结果
 * @author han_yanhui
 *
 */
@Getter
public enum UserAuthTrsultType{
	/**
	 * 未实名(默认)
	 */
	NO_AUTH("0", "未实名"),
	/**
	 * 已实名
	 */
	AUTHED("1", "已实名"),
	/**
	 * 实名中
	 */
	AUTHING("2", "实名中");
	
	String code;
	
	private String name;

	private UserAuthTrsultType(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
