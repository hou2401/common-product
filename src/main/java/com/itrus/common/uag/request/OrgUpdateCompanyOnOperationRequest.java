package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 *企业更新-运营管理
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
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
