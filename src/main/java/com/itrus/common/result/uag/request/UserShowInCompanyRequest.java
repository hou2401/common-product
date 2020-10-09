package com.itrus.common.result.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 查看成员详情
 */
@ToString
@Data
@AllArgsConstructor
public class UserShowInCompanyRequest {
    /**
     * 必选 账号唯一标识
     */
    private String uuid;
    /**
     * 必选 企业唯一标识
     */
    private String companyUuid;

}
