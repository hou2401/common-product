package com.itrus.common.result.uag.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 运营平台-企业详情
 */
@Data
@NoArgsConstructor
public class OrgShowRequest {
    /**
     * 企业唯一标识 必选
     */
    private String companyUuid;
    /**
     * 当前登录人员唯一标识 可选
     */
    private String uuid;
    
    /**
     * 参数来源
     */
    private String formHeader = "false";

	public OrgShowRequest(String companyUuid, String uuid) {
		super();
		this.companyUuid = companyUuid;
		this.uuid = uuid;
	}
}
