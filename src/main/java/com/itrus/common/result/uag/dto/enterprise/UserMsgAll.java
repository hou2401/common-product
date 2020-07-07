package com.itrus.common.result.uag.dto.enterprise;

import com.itrus.common.result.uag.dto.enterprise.user.UserInfoAll;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserMsgAll
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 15:33 2020/7/6
 * @Modified By:
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserMsgAll extends UserInfoAll implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    List<UserCompanyInfo> companys;

}
