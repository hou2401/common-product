package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.CompanyList;
import com.itrus.common.result.uag.response.entity.RealInfo;
import com.itrus.common.result.uag.response.entity.UserInfo;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class showUserResult implements Serializable {
    private UserInfo userInfo;

    private RealInfo realInfo;

    private Integer companyCount;

    private List<CompanyList> companyList;
}
