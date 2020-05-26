package com.itrus.common.result.uag.enterprise;

import java.util.List;

import lombok.Data;

@Data
public class Enterprise {

	/**
	 * 企业全称
	 */
	private String orgName;
	
	/**
	 * 企业信用代码
	 */
	private String orgCode;
	
	/**
	 * 简称集合实体
	 */
	private List<OrgAlias> orgAliasList;
	
	/**
	 * 企业用户集合
	 */
	private List<CompanyUser> companyUserList;
}
