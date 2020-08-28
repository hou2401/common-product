package com.itrus.common.result.uag.request;

import com.itrus.common.result.uag.entity.OrgInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddCompanyRequest {

    /**
     * 企业信息集合 必选
     */
    private List<OrgInfo> orgInfoList;
    /**
     * 要添加外部联系人关系的节点唯一标识 必选
     */
    private String uuid;
    /**
     * 要添加外部联系人关系的节点类型 必选
     * 0 企业（默认）
     * 1 部门
     * 2 用户
     * 3 全部
     */
    private String type;
}
