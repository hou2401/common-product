package com.itrus.common.params.uag.enterprise;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;


/**
 * @apiDefine CreateEnterpriseParams 请求UAG部门实体类
 * 
 * @apiParam {String} manager 管理员账号.
 * @apiParam {String} orgName 企业全称.
 * @apiParam {String} orgAlias 企业简称.
 * @apiParam {String} orgCode 统一社会信用编码.
 * @apiParam {String} parentUuid 如果携带该参数则表示在企业下创建子企业或子公司（可选）.
 * @apiParam {String} email 用户个人邮箱.
 * @apiParam {String} realName  用户实名状态 0 未实名 1 已实名.
 */
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
	
	/**
	 * 是否实名
	 */
	private String realName; 

	public CreateEnterpriseParams(String manager, String orgName, String orgAlias, String orgCode, String realName) {
		super();
		this.manager = manager;
		this.orgName = orgName;
		this.orgAlias = orgAlias;
		this.orgCode = orgCode;
		this.realName = realName;
	}
	
	public CreateEnterpriseParams() {
		super();
	}
    
}
