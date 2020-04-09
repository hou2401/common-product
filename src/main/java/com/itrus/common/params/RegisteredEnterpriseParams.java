package com.itrus.common.params;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisteredEnterpriseParams {
	/**
	 * 企业名称
	 * 必填项
	 */
	private String orgName;
	
	/**
	 * 企业别名，非必填项，如果不传则和企业名称相同
	 */
	private String orgAliases;
	
	/**
	 * 统一社会信用代码，必填项
	 */
	private String orgCode;
	
	/**
	 * 邮箱
	 * (账号属性 如果email或telephonenum必须存在一项，优先使用telephonenum)非必填项
	 */
	private String email;
	
	/**
	 * 手机号
	 * (账号属性 如果email或telephonenum必须存在一项，优先使用telephonenum)非必填项
	 */
	private String telephonenum;
	
	
	/**
	 * 密码，必填项
	 */
	private String passwd;
	
	
	/**
	 * 实名认证状态
	 * 请求POST参数,(1表示已认证，2表示未认证，3表示认证未通过，4表示联系人已离职，5表示待审核) 
	 */
	private String realName;
	
	
	/**
	 * 审核状态
	 * 扩展字段 "ifAudited"请求POST参数,(1表示审核通过，3表示待审核，4表示审核拒绝) 
	 */
	private String ifAudited;


	public RegisteredEnterpriseParams(String orgName, String orgAliases, String orgCode, String email,
			String telephonenum, String passwd, String realName, String ifAudited) {
		super();
		this.orgName = orgName;
		this.orgAliases = orgAliases;
		this.orgCode = orgCode;
		this.email = email;
		this.telephonenum = telephonenum;
		this.passwd = passwd;
		this.realName = realName;
		this.ifAudited = ifAudited;
	}


	public RegisteredEnterpriseParams() {
		super();
	}
	
}
