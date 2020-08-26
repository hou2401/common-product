package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
public class OrgFindCompanyListRequest extends EntBase{
    /**
     * 个人唯一标识
     */
    private Long userUuid;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 实名状态
     */
    private String authResult;
    /**
     * 最早注册时间
     */
    private String beforeTime;
    /**
     * 最晚注册时间
     */
    private String endTime;
    /**
     * 页码
     */
    private Integer pageIndex;
    /**
     * 数量
     */
    private Integer pageSize;

}
