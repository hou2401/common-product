package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 * 公司关系信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationInfo implements Serializable {
    /**
     * 父企业
     */
    private ParentSubInfo parentOrg;
    /**
     * 子企业列表
     */
    private List<ParentSubInfo> subInfo;

}
