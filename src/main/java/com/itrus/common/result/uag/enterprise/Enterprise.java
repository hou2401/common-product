package com.itrus.common.result.uag.enterprise;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class Enterprise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private Set<OrgAlias> orgAliasList;
	
	/**
	 * 企业用户集合
	 */
	private Set<CompanyUser> companyUserList;
}
