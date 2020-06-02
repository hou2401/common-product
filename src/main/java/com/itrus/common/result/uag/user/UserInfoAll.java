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
		return this.idCard.compareTo(o.idCard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoAll other = (UserInfoAll) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (defaultOrganizationUuid == null) {
			if (other.defaultOrganizationUuid != null)
				return false;
		} else if (!defaultOrganizationUuid.equals(other.defaultOrganizationUuid))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (joinState == null) {
			if (other.joinState != null)
				return false;
		} else if (!joinState.equals(other.joinState))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgType == null) {
			if (other.orgType != null)
				return false;
		} else if (!orgType.equals(other.orgType))
			return false;
		if (orgUuid == null) {
			if (other.orgUuid != null)
				return false;
		} else if (!orgUuid.equals(other.orgUuid))
			return false;
		if (passWd == null) {
			if (other.passWd != null)
				return false;
		} else if (!passWd.equals(other.passWd))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		if (satate == null) {
			if (other.satate != null)
				return false;
		} else if (!satate.equals(other.satate))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((defaultOrganizationUuid == null) ? 0 : defaultOrganizationUuid.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + ((joinState == null) ? 0 : joinState.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
		result = prime * result + ((orgUuid == null) ? 0 : orgUuid.hashCode());
		result = prime * result + ((passWd == null) ? 0 : passWd.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + ((satate == null) ? 0 : satate.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
}
