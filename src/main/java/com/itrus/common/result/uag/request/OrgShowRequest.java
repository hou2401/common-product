package com.itrus.common.result.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 运营平台-企业详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgShowRequest {
    /**
     * 企业唯一标识 必选
     */
    private String companyUuid;
    /**
     * 当前登录人员唯一标识 必选
     */
    private String uuid;
}
