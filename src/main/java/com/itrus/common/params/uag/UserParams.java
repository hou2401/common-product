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
     * 身份证号
     */
    private String idCard;

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
    private String passwd;

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

}
