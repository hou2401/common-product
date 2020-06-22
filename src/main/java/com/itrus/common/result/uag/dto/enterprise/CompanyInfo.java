package com.itrus.common.result.uag.dto.enterprise;

import com.itrus.common.result.uag.dto.enterprise.user.UserInfoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName CompanyInfo
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 15:37 2020/6/22
 * @Modified By:
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CompanyInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 当前企业的uuid
     */
    private Long uuid;
    /**
     * 当前企业所属的组织id
     */
    private Long parentUuid;
    /**
     * 公司全称
     */
    private String orgName;
    /**
     * 统一信用编码
     */
    private String orgCode;
    /**
     * 企业简称
     */
    private String orgAlias;
    /**
     * 审核状态
     */
    private String ifAudited;
    /**
     * 实名状态
     */
    private String realName;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifyTime;

}
