package com.itrus.common.result.uag.response;

import com.itrus.common.result.uag.response.entity.CompanyInfo;
import com.itrus.common.result.uag.response.entity.UserInfoCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuying
 * 获取指定企业下的超管列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFindCompanySuperAdminListResult implements Serializable {

    /**
     * 企业信息
     */
    private CompanyInfo companyInfo;
    /**
     * 成员信息列表
     */
    private List<UserInfoCompany> userInfoList;
}
