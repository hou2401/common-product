package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptInfo {
    private String deptName;

    private Integer uuid;

    private String deptType;

    private Integer orderNum;

    private Integer parentUuid;

    private String parentType;

    private Integer companyUuid;

    private String creatorName;

    private String path;
}
