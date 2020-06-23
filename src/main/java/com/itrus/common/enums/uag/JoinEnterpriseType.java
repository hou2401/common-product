package com.itrus.common.enums.uag;

import lombok.Getter;

/**
 * 
 * 企业审核状态
 * @author wgx52
 *
 */
@Getter
public enum JoinEnterpriseType{
	/**
	 * 0 企业
	 * 2部门
	 */
	JOINT_ENTERPRISE("0","加入企业"),
	JOINT_DEPT("2","加入部门");
	
	private String code;
	private String name;
	
	private JoinEnterpriseType(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
