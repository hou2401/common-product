package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 变更企业主管理员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrgChangeCreatorRequest extends EntBase {
    /**
     * 新主管理员手机号码
     */
    private String phone;
}
