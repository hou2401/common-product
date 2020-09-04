package com.itrus.common.result.uag.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiBatchAddCompanyRequest {

    /**
     * 企业信息集合 必选
     */
    private List<ExternalAddCompanyRequest> orgInfoList;
    /**
     * 要添加外部联系人关系的节点唯一标识 必选
     */
    private String companyUuid;
	public ExternalApiBatchAddCompanyRequest( ExternalAddCompanyRequest orgInfoList, String companyUuid) {
		super();
		this.orgInfoList = new ArrayList<>();
		this.orgInfoList.add(orgInfoList);
		this.companyUuid = companyUuid;
	}
    
    
    

}
