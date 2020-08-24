package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 添加/更新/删除部门
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptAddAndUpdateAndDeleteRequest extends EntBase {
     /**
     * 部门名称
     */
     private String deptName;
     /**
     * 上级节点唯一标识
     */
     private Long parentUuid;
     /**
     * 0 企业（默认） 1 部门 2 用户 3 全部
     */
     private String parentType;
     /**
     * 0 普通部门（默认） 1 公司级部门
     */
     private String deptType;
     /**
     *指定部门唯一标识
     */
     private Long deptUuid;
     /**
     *原上级节点唯一标识
     */
     private Long sourceUuid;
     /**
     *0 企业（默认） 1 部门 2 用户 3 全部
     */
     private String  sourceType;

}
