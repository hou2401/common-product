package com.itrus.common.response.entity;

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
public class RelationInfo implements Serializable {
    private ParentOrg parentOrg;

    private List<SubInfo> subInfo;

}
