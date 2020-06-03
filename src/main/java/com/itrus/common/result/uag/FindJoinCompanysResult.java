package com.itrus.common.result.uag;

import com.itrus.common.dto.uag.dto.user.UserInfoAll;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class FindJoinCompanysResult extends UagResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserInfoAll userInfo;
	
	

}
