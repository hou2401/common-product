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
	 * 公司扩展属性json
	 */
	private String companyExt;


}
