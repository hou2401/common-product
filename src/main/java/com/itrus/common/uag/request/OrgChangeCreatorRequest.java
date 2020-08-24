package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 变更企业主管理员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgChangeCreatorRequest extends EntBase {
    /**
     * 新主管理员手机号码
     */
    private String phone;
}
