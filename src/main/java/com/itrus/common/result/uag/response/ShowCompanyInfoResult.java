package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.itrus.common.result.uag.response.entity.CompanyInfo;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowCompanyInfoResult implements Serializable {
    private CompanyInfo companyInfo;
}
