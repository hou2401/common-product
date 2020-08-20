package com.itrus.common.enums.uag.account;

import lombok.Getter;

/**
 * 账号来源
 * @author wgx52
 *
 */
@Getter
public enum AccountSource{
	/**
	 * SaaS（默认）
	 */
	SAAS(0, "SaaS（默认）"),
	/**
	 *Api
	 */
	API(1, "Api");

	private int code;
	private String name;

	private AccountSource(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
