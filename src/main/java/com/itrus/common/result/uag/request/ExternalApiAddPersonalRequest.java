package com.itrus.common.result.uag.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * openApi-批量创建外部联系人-个人
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddPersonalRequest {

    /**
     * 用户信息集合 必选
     */
    private List<ExternalAddPersonalRequest> userInfoList;
    /**
     * 要添加外部联系人关系的节点唯一标识 必选
     */
    private String companyUuid;
    /**
     * 要添加外部联系人关系的节点类型 必选
     * 0 企业
     * 1 部门
     * 2 用户
     * 3 全部
     */
    private String type;
	public ExternalApiAddPersonalRequest(ExternalAddPersonalRequest obj) {
		super();
		this.userInfoList = new ArrayList<>();
		this.userInfoList.add(obj);
		this.companyUuid = obj.getCompanyUuid();
	}
    
    
}
