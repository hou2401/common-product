package com.itrus.common.params.uag.enterprise;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "请求UAG部门实体类")
@ToString
@Data
public class CreateEnterpriseParams implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员账号
	 */
	private String manager;
	
	/**
	 * 企业全称
	 */
	private String orgName;
	
	/**
	 * 企业简称
	 */
	private String orgAlias;
	
	/**
	 * 统一社会信用编码
	 */
	private String orgCode;
	
	/**
	 * 可选
	 *如果携带该参数则表示在企业下创建子企业或子公司
	 */
	private Long parentUuid;

	public CreateEnterpriseParams(String manager, String orgName, String orgAlias, String orgCode) {
		super();
		this.manager = manager;
		this.orgName = orgName;
		this.orgAlias = orgAlias;
		this.orgCode = orgCode;
	}

	public CreateEnterpriseParams() {
		super();
	}
    
}
