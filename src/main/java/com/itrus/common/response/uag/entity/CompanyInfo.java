package com.itrus.common.response.uag.entity;

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
public class CompanyInfo implements Serializable {
    private CompanyBaseInfo companyBaseInfo;

    private ManagerInfo managerInfo;

    private AuthInfo authInfo;

    private RelationInfo relationInfo;

    private Object extendAttr;
}
