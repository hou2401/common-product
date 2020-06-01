package com.itrus.common.params.uag.enterprise;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel(description = "请求UAG部门实体类")
@ToString
@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateEnterpriseParams extends CreateEnterpriseParams{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 企业标识
	 */
	private Long uuid;
	
	/**
	 * 企业审核状态
	 */
	private String ifAudited;
	
	/**
	 * 企业实名状态
	 */
	private String realName;
	
	
	public UpdateEnterpriseParams(String manager, Long uuid, String ifAudited, String realName){
		super();
		this.setManager(manager);
		this.uuid = uuid;
		this.ifAudited = ifAudited;
		this.realName = realName;
	}

	public UpdateEnterpriseParams() {
		super();
	}
	
}
