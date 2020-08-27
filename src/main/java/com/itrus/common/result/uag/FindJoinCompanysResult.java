package com.itrus.common.result.uag;

import java.io.Serializable;

import com.itrus.common.result.uag.dto.enterprise.user.UserInfoAll;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class FindJoinCompanysResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserInfoAll userInfo;
	

}
