package com.itrus.common.result.uag.dto.enterprise;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class EnterpriseDetail implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 企业uuid
	 */
	private Long uuid;
	
	/**
	 * 用户uuid
	 */
	private Long userUuid;
	
	/**
	 * 企业全称
	 */
	private String orgName;
	
	/**
	 * 企业信用代码
	 */
	private String orgCode;
	
	/**
	 * 简称集合实体
	 */
	private String orgAlias;
	
	/**
	 * 简称集合实体
	 */
	private String ifAudited;
	
	/**
	 * 简称集合实体
	 */
	private String realName;
	
	/**
	 * 简称集合实体
	 */
	private Long parentUuid;
	

}
