package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.AppBase;

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
public class AppUpdateRequest extends AppBase {
    /**
     * 企业唯一标识
     */
    private Long companyUuid;
}
