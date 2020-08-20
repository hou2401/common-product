package com.itrus.common.enums.uag.account;

import lombok.Getter;

/**
 * 账号状态
 * @author wgx52
 *
 */
@Getter
public enum AccountStatus{
	/**
	 * 未激活
	 */
	NONACTIVATED(0, "未激活"),
	/**
	 * 正常（默认）
	 */
	NORMAL(1, "正常（默认）"),
	/**
	 * 挂起，禁用
	 */
	FORBIDDEN(2, "挂起");

	private int code;
	private String name;

	private AccountStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
