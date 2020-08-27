package com.itrus.common.result.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 *  获取指定企业下的超管列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFindCompanySuperAdminListRequest {
    private String companyUuid;
}
