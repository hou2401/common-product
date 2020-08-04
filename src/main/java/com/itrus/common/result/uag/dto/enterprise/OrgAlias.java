package com.itrus.common.result.uag.dto.enterprise;

import java.io.Serializable;

import lombok.Data;

/**
 * 企业简称
 * @author wgx52
 *
 */
@Data
public class OrgAlias implements Comparable<OrgAlias>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 企业简称
	 */
	private String orgAlias;

	/**
	 * 审核状态
	 */
	private String ifAudited;

	/**
	 * 企业实名状态
	 */
	private String realName;


	/**
	 * 创建人
	 */
	private String createdBy;

	/**
	 * 企业uuid
	 */
	private Long uuid;

	/**
	 * 父节点id
	 */
	private Long parentUuid;

	@Override
	public int compareTo(OrgAlias o) {
		return this.orgAlias.compareTo(o.orgAlias);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrgAlias other = (OrgAlias) obj;
		if (createdBy == null) {
			if (other.createdBy != null) {
				return false;
			}
		} else if (!createdBy.equals(other.createdBy)) {
			return false;
		}
		if (ifAudited == null) {
			if (other.ifAudited != null) {
				return false;
			}
		} else if (!ifAudited.equals(other.ifAudited)) {
			return false;
		}
		if (orgAlias == null) {
			if (other.orgAlias != null) {
				return false;
			}
		} else if (!orgAlias.equals(other.orgAlias)) {
			return false;
		}
		if (parentUuid == null) {
			if (other.parentUuid != null) {
				return false;
			}
		} else if (!parentUuid.equals(other.parentUuid)) {
			return false;
		}
		if (realName == null) {
			if (other.realName != null) {
				return false;
			}
		} else if (!realName.equals(other.realName)) {
			return false;
		}
		if (uuid == null) {
			if (other.uuid != null) {
				return false;
			}
		} else if (!uuid.equals(other.uuid)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((ifAudited == null) ? 0 : ifAudited.hashCode());
		result = prime * result + ((orgAlias == null) ? 0 : orgAlias.hashCode());
		result = prime * result + ((parentUuid == null) ? 0 : parentUuid.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
}
