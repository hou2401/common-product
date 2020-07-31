package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

/**
 * 请求UAG查询加载企业树实体
 * @author wgx52
 *
 */
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
     * 组合查询条件
     */
   private SearchConditionloadTreeParams searchCondition;
    public EntLoadTreeParams() {
    }

    public EntLoadTreeParams(Long uuid, String manager, SearchConditionloadTreeParams searchCondition) {
        this.uuid = uuid;
        this.manager = manager;
        this.searchCondition = searchCondition;
    }
}
