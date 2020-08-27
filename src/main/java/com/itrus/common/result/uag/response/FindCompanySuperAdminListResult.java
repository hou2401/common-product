package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.CompanyInfo;
import com.itrus.common.result.uag.response.entity.UserInfoCompany;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCompanySuperAdminListResult implements Serializable {
    private CompanyInfo companyInfo;
    private List<UserInfoCompany> list;
}
