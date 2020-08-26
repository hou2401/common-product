package com.itrus.common.request.uag;

import com.itrus.common.request.uag.base.UserBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
public class ApiAddPersonalRequest extends UserBase {
    /**
     * 标识给哪个企业/个人创建外部
     */
    private String uuid;
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
