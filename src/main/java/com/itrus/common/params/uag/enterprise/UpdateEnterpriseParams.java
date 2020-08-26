package com.itrus.common.params.uag.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	private String uuid;
	
	/**
	 * 企业审核状态
	 */
	private String ifAudited;
	

	
	
	public UpdateEnterpriseParams(String manager, String uuid, String ifAudited, String realName){
		super();
		this.setManager(manager);
		this.uuid = uuid;
		this.ifAudited = ifAudited;
		this.setRealName(realName);
	}

	public UpdateEnterpriseParams() {
		super();
	}

	public UpdateEnterpriseParams(String uuid) {
		super();
		this.uuid = uuid;
	}
	
}
