package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowCompanyInfoResult implements Serializable {
    private CompanyInfo companyInfo;
}
