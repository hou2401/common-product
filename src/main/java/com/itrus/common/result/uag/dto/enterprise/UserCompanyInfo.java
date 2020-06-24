package com.itrus.common.result.uag.dto.enterprise;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName UserCompanyInfo
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 17:35 2020/6/24
 * @Modified By:
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserCompanyInfo extends CompanyInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String displayName;

    private String joinState;


}
