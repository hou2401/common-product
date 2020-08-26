package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 个人账号注册
 */
@ToString
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserRegisterRequest extends UserBase {
}
