package com.itrus.common.response.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leaders implements Serializable {
    private String uuid;

    private String nickName;

    private String displayName;

    private String phone;

    private String email;

    private String state;

    private String idCardType;

    private String idCardNum;

    private String birth;

    private String sex;

    private String extendAttr;

    private List<String> roleName;

    private List<String> deptName;

    private List<String> leaderDeptName;

    private List<ParentList> parentList;
}
