package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 *企业更新-运营管理
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrgUpdateCompanyOnOperationRequest extends EntBase {

    /**
     * 手机号
     */
    private  String phone;
    /**
     *状态
     */
    private  String state;

}
