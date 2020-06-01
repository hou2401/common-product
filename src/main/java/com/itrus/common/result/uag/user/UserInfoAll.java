package com.itrus.common.result.uag.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户与企业信息
 * 组合实体
 * @author wgx52
 *
 */
@Data
public class UserInfoAll implements Comparable<UserInfoAll>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户uuid
	 */
	private Long uuid;

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
	 * 用户状态
	 */
	private String satate;
	
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
	 * 默认企业超管，用户是某个企业的超管，下面uuid，是管理某个企业的uuid
	 */
	private Long defaultOrganizationUuid;
	
	/**
	 * 所属部门或企业组织uuid
	 */
	private String orgUuid;
	/**
	 * 所属部门名称或企业简称
	 */
	private String orgName;
	
	/**
	 * 所属上级是部门还是企业", ##"0"代表企业，"2"代表部门
	 */
	private String orgType;
	
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
	
	@Override
	public int compareTo(UserInfoAll o) {
		return 0;
	}
}
