package com.itrus.common.response.entity;

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

    private int uuid;

    private String deptType;

    private int orderNum;

    private int parentUuid;

    private String parentType;

    private int companyUuid;

    private String creatorName;

    private String path;
}
