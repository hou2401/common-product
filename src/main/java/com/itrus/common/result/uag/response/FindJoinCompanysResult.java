package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.CompanyInfo;

/**
 * @author yuying
 * 查询用户已加入企业
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindJoinCompanysResult implements Serializable {
    /**
     * 公司信息列表
     */
    List<CompanyInfo> companyList;
}
