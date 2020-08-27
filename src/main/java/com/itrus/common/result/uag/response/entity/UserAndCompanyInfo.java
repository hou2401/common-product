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
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UserInfo{
        /**
         * 手机号
         */
        private String phone;
        /**
         * 用户唯一标识
         */
        private String uuid;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class CompanyInfo{
        /**
         * 企业全称
         */
        private String orgName;
        /**
         * 企业唯一标识
         */
        private String uuid;
    }


}
