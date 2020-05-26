package com.itrus.common.result.uag.enterprise;

import java.io.Serializable;

import lombok.Data;

/**
 * 企业简称
 * @author wgx52
 *
 */
@Data
public class OrgAlias implements Serializable{

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
}
