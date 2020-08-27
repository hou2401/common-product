package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.AppBase;

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
public class AppCreateRequest extends AppBase {
    /**
     * 企业唯一标识
     */
    private Long companyUuid;
}
