package com.itrus.common.params.uag;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "请求UAG部门实体类")
@ToString
@Data
public class UserParams {

    /**
     * 用户uuid
     */
    private Long uuid;

    /**
     * 管理员账号
     */
    private String manager;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 真实姓名
     */
    private String displayName;

    /**
     * 证件号
     */
    private String idCardNum;
    
    /**
     * 证件类型
     */
    private String idCardType;

    /**
     * 用户个人邮箱
     */
    private String email;

    /**
     * 用户实名状态 0 未实名 1 已实名
     */
    private String realName;

    /**
     * 用户密码
     */
    private String passWd;

    //-------------------------------组织下用户更新入参-----------------------------------------------------

    /**
     * 公司uuid
     */
    private Long parentUuid;

    /**
     * 目标uuid,迁移到那个组织节点下，组织节点的uuid(公司或部门)
     */
    private Long targetUuid;
    /**
     * 目标组织类型：1公司、2部门
     */
    private String targetType;

    /**
     * 扩展字段
     */
    private UserExtParams ext;
    
    /**
     * 用户激活状态
     */
    private boolean  enabled;


    public UserParams(Long parentUuid, Long uuid, UserExtParams ext, Long targetUuid) {
        super();
        this.parentUuid = parentUuid;
        this.uuid = uuid;
        this.ext = ext;
        this.targetUuid = targetUuid;
    }


    public UserParams() {
        super();
    }
    /***
     * 用户注册
     * @param phone
     * @param passwd
     */
    public UserParams(String phone, String passwd){
    	super();
    	this.phone = phone;
    	this.passWd = passwd;
    	this.enabled = true;
    }
    /***
     * 用户注册
     * @param phone
     * @param passwd
     */
    public UserParams(String phone, String passwd, boolean enabled ){
    	super();
    	this.phone = phone;
    	this.passWd = passwd;
    	this.enabled = enabled;
    }


    /***
     * 用户注册
     * @param uuid
     * @param uuid
     */
    public UserParams(Long uuid, String manager){
        super();
        this.uuid = uuid;
        this.manager = manager;
    }

    /**
     * 用户实名认证
     * @param uuid
     * @param manager
     * @param realName
     */
	public UserParams(Long uuid, String manager, String realName) {
		super();
		this.uuid = uuid;
		this.manager = manager;
		this.realName = realName;
	}
    
    
}
