package com.itrus.common.response.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptList implements Serializable {
    private String deptName;

    private String uuid;

    private String deptType;

    private Integer orderNum;

    private String parentUuid;

    private String parentType;

    private String companyUuid;

    private String creatorName;

    private String path;
}
