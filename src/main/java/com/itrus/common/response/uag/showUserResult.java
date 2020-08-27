package com.itrus.common.response.uag;

import com.itrus.common.response.entity.CompanyList;
import com.itrus.common.response.entity.RealInfo;
import com.itrus.common.response.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

    private int companyCount;

    private List<CompanyList> companyList;
}
