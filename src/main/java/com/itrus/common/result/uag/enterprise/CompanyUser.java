package com.itrus.common.result.uag.enterprise;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户与企业信息
 * 组合实体
 * @author wgx52
 *
 */
@Data
public class CompanyUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码  ？？？ 加密的吗？天威云 md5加密
	 */
	private String passWd;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 个人邮箱
	 */
	private String email;
	
	/**
	 * 实名状态
	 */
	private String realName;
	
	/**
	 * 真实姓名
	 */
	private String displayName;
	
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 状态
	 */
	private String joinState;
	
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 成员编号
	 */
	private String code;
	
	/**
	 * 公司邮箱
	 */
	private String companyEmail;
}
