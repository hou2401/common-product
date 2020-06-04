package com.itrus.common.params.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  邀请用户加入企业成员
 * </p>
 *
 * @author hzq
 * @since 2020/5/28
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JoinEnterpriseParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员账号-手机号
     */
    private String manager;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 部门或者企业uuid
     */
    private Long uuid;
    /**
     * 加入的组织类型，0-企业，2-部门
     */
    private String type;
    /**
     * 真实姓名
     */
    private String displayName;
    /**
     * 成员编号
     */
    private String code;
    /**
     * 公司邮箱
     */
    private String companyEmail;

}
