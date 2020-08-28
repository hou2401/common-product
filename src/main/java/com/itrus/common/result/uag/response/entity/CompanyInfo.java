package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * 企业信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfo implements Serializable {

    private static final long serialVersionUID = -3781267399818411644L;
    /**
     * 企业基本信息
     */
    private CompanyBaseInfo companyBaseInfo;
    /**
     * 管理员信息
     */
    private ManagerInfo managerInfo;
    /**
     * 实名信息
     */
    private AuthInfo authInfo;
    /**
     * 企业关系信息
     */
    private RelationInfo relationInfo;
    /**
     * 账号扩展属性JSON
     */
    private Object extendAttr;
}
