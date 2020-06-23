package com.itrus.common.params.uag;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    
    /**
     * 是否需要用户确认
     */
    private boolean confirm = false;

	public JoinEnterpriseParams(String manager, String phone, Long uuid, String type, String displayName, String code,
			String companyEmail, boolean confirm) {
		super();
		this.manager = manager;
		this.phone = phone;
		this.uuid = uuid;
		this.type = type;
		this.displayName = displayName;
		this.code = code;
		this.companyEmail = companyEmail;
		this.confirm = confirm;
	}

	public JoinEnterpriseParams(String manager, String phone, Long uuid, String type, String displayName, String code,
			String companyEmail) {
		super();
		this.manager = manager;
		this.phone = phone;
		this.uuid = uuid;
		this.type = type;
		this.displayName = displayName;
		this.code = code;
		this.companyEmail = companyEmail;
	}

}
