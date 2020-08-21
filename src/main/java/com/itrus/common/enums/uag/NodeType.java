package com.itrus.common.enums.uag;

import lombok.Getter;

/**
 * 节点类型
 * @author wgx52
 *
 */
@Getter
public enum NodeType{
	/**
	 *企业（默认）
	 */
	ENTERPRISE("0", "企业（默认）"),
	/**
	 * 部门
	 */
	DEPARTMENT("1", "部门"),
	
	/**
	 * 用户
	 */
	USER("2","用户"),
	/**
	 * 全部
	 */
	ALL("3","全部")
	
	;
	
	private String code;
	private String name;

	private NodeType(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
