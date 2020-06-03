package com.itrus.common.params.uag;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@ApiModel(description = "请求UAG查询加载企业树实体")
@ToString
@Data
public class EntLoadTreeParams {
    /**
     * 组织id 公司/部门
     */
    private Long uuid;

    /**
     * 用户在UAG存储用户名 -本地手机号或者邮箱号
     */
    private String manager;

    /**
     * 用户姓名
     */
    private String displayName;

    /**
     * 默认需要显示超级管理员
     * true显示
     */
    private Boolean ifRoot;

    /**
     * 加入状态
     */
    private String[] joinState;

    /**
     * 查询节点类型  用户/部门/公司
     */
    private String[] nodeType;  // 查询节点类型   1：用户  2：部门 3：公司

    /**
     * 审核条件   待审核/审核通过/审核拒绝 --check_status
     */
    private String[] ifAudited;   // 审核状态 1：审核通过  3：待审核  4：审核拒绝  不填默认查询全部

    /**
     * 用户认证状态
     */
    private String realName;  // 可选 0未实名 1已实名

    public EntLoadTreeParams() {
    }

    public EntLoadTreeParams(Long uuid, String manager, String[] nodeType) {
        this.uuid = uuid;
        this.manager = manager;
        this.nodeType = nodeType;
    }

    public EntLoadTreeParams(Long uuid, String manager, Boolean ifRoot, String[] joinState, String[] ifAudited, String realName) {
        this.uuid = uuid;
        this.manager = manager;
        this.ifRoot = ifRoot;
        this.joinState = joinState;
        this.ifAudited = ifAudited;
        this.realName = realName;
    }

    public EntLoadTreeParams(Long uuid, String manager, String[] joinState, String[] ifAudited, String realName) {
        this.uuid = uuid;
        this.manager = manager;
        this.joinState = joinState;
        this.ifAudited = ifAudited;
        this.realName = realName;
    }
}
