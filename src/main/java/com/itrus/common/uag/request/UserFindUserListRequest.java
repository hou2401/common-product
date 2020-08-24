package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserFindUserListRequest extends UserBase {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 是否关联企业
     */
    private String isJoinCompany;
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
