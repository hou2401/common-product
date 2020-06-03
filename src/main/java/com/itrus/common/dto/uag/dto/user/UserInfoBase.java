package com.itrus.common.dto.uag.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户与企业信息
 * 组合实体
 * @author wgx52
 *
 */
@Data
public class UserInfoBase implements Comparable<UserInfoBase>, Serializable{
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
	 * 用户状态，正常/冻结
	 */
	private String satate;
	
	/**
	 * 是否实名 0 未实名 1 已实名
	 */
	private String realName;
	
	/**
	 * 真实姓名
	 */
	private String displayName;
	
	/**
	 * 证件号
	 */
	private String idCardNum;
	
	/**
	 * 证件类型
	 * 证件类型，与idCardNum同时存在。0-居民身份证，1-护照，2-港澳居民来往内地通行证，3-台湾居民内地通行证
	 */
	private String idCardType;
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 默认企业超管，用户是某个企业的超管，下面uuid，是管理某个企业的uuid
	 */
	private Long defaultOrganizationUuid;
	
	/**
	 * 标识用户上次登录的企业唯一标识，如果上次登录是个人身份，该属性无值
	 */
	private String lastLogon;
	
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
	 * 扩展属性，json字符串
	 */
	private String ext;
	
	@Override
	public int compareTo(UserInfoBase o) {
		return this.displayName.compareTo(o.displayName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoBase other = (UserInfoBase) obj;
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
		if (ext == null) {
			if (other.ext != null)
				return false;
		} else if (!ext.equals(other.ext))
			return false;
		if (idCardNum == null) {
			if (other.idCardNum != null)
				return false;
		} else if (!idCardNum.equals(other.idCardNum))
			return false;
		if (idCardType == null) {
			if (other.idCardType != null)
				return false;
		} else if (!idCardType.equals(other.idCardType))
			return false;
		if (lastLogon == null) {
			if (other.lastLogon != null)
				return false;
		} else if (!lastLogon.equals(other.lastLogon))
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
		result = prime * result + ((defaultOrganizationUuid == null) ? 0 : defaultOrganizationUuid.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ext == null) ? 0 : ext.hashCode());
		result = prime * result + ((idCardNum == null) ? 0 : idCardNum.hashCode());
		result = prime * result + ((idCardType == null) ? 0 : idCardType.hashCode());
		result = prime * result + ((lastLogon == null) ? 0 : lastLogon.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
		result = prime * result + ((orgUuid == null) ? 0 : orgUuid.hashCode());
		result = prime * result + ((passWd == null) ? 0 : passWd.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + ((satate == null) ? 0 : satate.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}


}
