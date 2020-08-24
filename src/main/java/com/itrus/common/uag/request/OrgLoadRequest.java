package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 加载企业一级部门
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgLoadRequest extends EntBase {
    /**
     * 0 全量  1一级（默认）
     */
    private String level;
    /**
     *节点类型
     */
    private String type;
    /**
     *每页数量
     */
    private Integer pageSize;
    /**
     *页码
     */
    private Integer pageNumber;

}
