package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  批量导入用户实体类
 * </p>
 *
 * @author hzq
 * @since 2020/6/2
 */
@Data
@ToString
public class ImportUserParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 部门
     */
    private String deptName;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 公司邮箱
     */
    private String companyEmail;
    /**
     * 成员编号
     */
    private String code;
}
