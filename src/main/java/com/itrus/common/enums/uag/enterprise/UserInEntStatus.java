package com.itrus.common.enums.uag.enterprise;

import lombok.Getter;

/**
 * 用户在企业的状态
 * @author wgx52
 *
 */
@Getter
public enum UserInEntStatus{
	/**
	 * 未加入
	 */
	NO_JOIN("0", "未加入"),
	/**
	 * 在职
	 */
	JOINED("1", "在职"),
	/**
	 * 已拒绝
	 */
	REFUSE("2", "已拒绝"),
	/**
	 * 异常
	 */
	EXCEPTION("3", "异常"),
	/**
	 * 离职
	 */
	LEAVE("4", "离职");

	private String code;
	private String name;

	private UserInEntStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
