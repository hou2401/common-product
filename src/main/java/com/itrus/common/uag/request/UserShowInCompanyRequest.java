package com.itrus.common.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 查看成员详情
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShowInCompanyRequest {
    /**
     *账号唯一标识
     */
    private Long uuid;
    /**
     * 企业唯一标识
     */
    private Long companyUuid;
}
