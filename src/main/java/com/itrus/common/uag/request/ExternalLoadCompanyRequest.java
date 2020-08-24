package com.itrus.common.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExternalLoadCompanyRequest {
    /**
     * 唯一标识
     */
    private Long uuid;
    /**
     * 节点类型
     */
    private String type;
    /**
     * 输入框里的查询条件
     * （姓名、手机号、邮箱、身份证号码）
     */
    private String conditionText;
    /**
     * 实名结果
     */
    private String authResult;
    /**
     * 状态（含移除）
     */
    private String state;
    /**
     * 来源编码（SaaS 或者AppID）
     */
    private String sourceCode;
    /**
     * 数量
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageIndex;
}
