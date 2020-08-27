package com.itrus.common.result.uag.response.entity;

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
public class ParentList implements Serializable {
    private String employeeCode;

    private String employeePosition;

    private String employeeEmail;

    private String extendAttrCompany;

    private String parentName;

    private String parentType;

    private String parentUuid;

    private String creatorName;
}
