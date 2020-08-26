package com.itrus.common.request.uag;

import com.itrus.common.request.uag.base.EntBase;

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
public class OrgAddSubCompanyRequest extends EntBase {
    /**
     * 要添加的下级企业唯一标识
     */
    private Long subCompanyUuid;
}
