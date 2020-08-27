package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.CompanyInfo;
import com.itrus.common.response.uag.entity.UserInfoCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
