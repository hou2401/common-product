package com.itrus.common.request.uag;

import com.itrus.common.request.uag.base.EntBase;
import com.itrus.common.request.uag.entity.ExtendAttr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *企业实名信息更新
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrgUpdateRequest extends EntBase {
    /**
     *姓名
     */
    private String displayName;
    /**
     *证件类型
     */
    private String idCardType;
    /**
     *证件号码（与证件类型同时存在）
     */
    private String idCardNum;
    /**
     *认证类型
     */
    private String authType;
    /**
     *认证时间
     */
    private String authTime;
    /**
     *个人认证结果
     */
    private String userAuthResult;
    /**
     *企业认证结果
     */
    private String orgAuthResult;
    /**
     *扩展属性
     */
    private ExtendAttr extendAttr;
}
