package com.itrus.common.enums.uag.enterprise;

import lombok.Getter;

/**
 * 企业证件类型
 * @author wgx52
 *
 */
@Getter
public enum EnterpriseCardType{
	
	/**
	 * 统一社会信用代码证
	 */
	UNIFIED_SOCIAL_CREDIT_CODE_CERTIFICATE("1", "统一社会信用代码证"),
	/**
	 * 组织机构代码证
	 */
	ORGANIZATION_CODE("2", "组织机构代码证"),
	/**
	 * 工商营业执照号
	 */
	ENTERPRISE_BUSINESS_LICENSE("3", "工商营业执照号");

	private String code;
	private String name;

	private EnterpriseCardType(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
