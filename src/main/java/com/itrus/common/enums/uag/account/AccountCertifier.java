package com.itrus.common.enums.uag.account;

import lombok.Getter;

/**
 * 实名认证方
 * @author han_yanhui
 *
 */
@Getter
public enum AccountCertifier{
	/**
	 * 第三方实名
	 */
	THIRD("0", "第三方实名"),
	/**
	 *天威实名（默认）
	 */
	ITRUS("1", "天威实名（默认）");

	private String code;
	private String name;

	private AccountCertifier(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
