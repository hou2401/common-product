package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiAddPersonalRequest extends UserBase {
    /**
     * 标识给哪个企业/个人创建外部
     */
    private Long uuid;
    /**
     * 节点类型
     */
    private String type;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 实名状态
     */
    private String authResult;
}
