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
	 * 在职（默认）
	 */
	NORMAL("0", "在职（默认）"),
	/**
	 * 公司级部门
	 */
	DIMISSION("1", "离职");

	private String code;
	private String name;

	private UserInEntStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
