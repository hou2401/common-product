package com.itrus.common.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgLoadTreeRequest {
    /**
     * 节点唯一标识
     */
    private Long uuid;
    /**
     * 节点类型
     */
    private String type;
}
