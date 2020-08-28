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
 *  个人详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class showUserResult implements Serializable {

    private static final long serialVersionUID = 1081961762680292556L;
    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 认证信息
     */
    private RealInfo realInfo;
    /**
     * 公司总数
     */
    private Integer companyCount;
    /**
     * 公司列表
     */
    private List<CompanyList> companyList;
}
