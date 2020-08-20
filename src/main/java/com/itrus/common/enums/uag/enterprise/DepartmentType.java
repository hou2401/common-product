package com.itrus.common.enums.uag.enterprise;

import lombok.Getter;

/**
 * 部门类型
 * @author wgx52
 *
 */
@Getter
public enum DepartmentType{
	/**
	 * 普通部门（默认）
	 */
	common(0, "普通部门（默认）"),
	/**
	 * 公司级部门
	 */
	ROOT(1, "公司级部门");

	private int code;
	private String name;

	private DepartmentType(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
