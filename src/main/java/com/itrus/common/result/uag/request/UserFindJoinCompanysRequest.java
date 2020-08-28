package com.itrus.common.result.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查询用户已加入企业
 */
@Data
@AllArgsConstructor
@ToString
public class UserFindJoinCompanysRequest {
    /**
     * 必选 用户唯一标识
     */
    private String uuid;

}
