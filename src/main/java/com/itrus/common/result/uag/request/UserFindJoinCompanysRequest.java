package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.UserBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查询用户已加入企业
 */
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
public class UserFindJoinCompanysRequest extends UserBase {

}
