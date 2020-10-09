package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndCompanyInfo {

    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 企业信息
     */
    private CompanyInfo companyInfo;




}
