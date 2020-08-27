package com.itrus.common.response.uag;

import com.itrus.common.response.entity.UserList;
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
public class showInCompanyResult implements Serializable {
    private String userName;

    private int uuid;

    private String employeeCode;

    private String employeePosition;

    private String employeeEmail;

    private String extendAttrCompany;

    private List<String> roleName;

    private List<String> deptName;

    private List<String> leaderDeptName;
}
