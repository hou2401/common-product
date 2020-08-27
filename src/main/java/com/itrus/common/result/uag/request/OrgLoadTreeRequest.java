package com.itrus.common.result.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 加载企业下全量节点信息
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgLoadTreeRequest {
    /**
     * 节点唯一标识
     */
    private String uuid;
    /**
     * 节点类型
     */
    private String type;
}
