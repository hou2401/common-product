package com.itrus.common.result.uag.response;

import com.itrus.common.result.uag.response.entity.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * 运营平台-企业详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgShowResult implements Serializable {

    private static final long serialVersionUID = -4607706574659630218L;
    /**
     * 企业信息
     */
    private CompanyInfo companyInfo;
}
