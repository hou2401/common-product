package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;

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
public class OrgRemoveSubCompanyRequest extends EntBase {
    /**
     * 要移除的下级企业唯一标识
     */
    private Long subCompanyUuid;
}
