package com.itrus.common.result.uag.dto.enterprise.user;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户与企业信息
 * 组合实体
 * @author wgx52
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserInfoAll extends UserInfoBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 企业关联关系表中的数据库id
	 */
	private Long id;
	
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
	
	/**
	 * 公司统一社会信用代码
	 */
	private String companyOrgCode;
	
	/**
	 * 公司扩展属性json
	 */
	private String companyExt;

	/**
	 * 用户注册时间
	 */
	private String createTime;

}
