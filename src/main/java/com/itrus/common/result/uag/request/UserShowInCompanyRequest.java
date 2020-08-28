package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查看成员详情
 */
@ToString
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserShowInCompanyRequest extends EntBase {
	public UserShowInCompanyRequest(String userId, String companyUuid) {
		this.setUuid(userId);
		this.setCompanyUuid(companyUuid);
	}
}
