package com.itrus.common.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *加载指定企业/部门主管列表
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchLeadersRequest {
    /**
     *企业/部门唯一标识
     */
   private Long nodeUuid;
    /**
     * 0 企业（默认） 1 部门 2 用户 3 全部
     */
   private String nodeType;
    /**
     *每页数量
     */
   private Integer pageSize;
    /**
     * 页码
     */
   private Integer pageNumber;
}
