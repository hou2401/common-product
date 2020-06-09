package com.itrus.common.result.uag.enterprise;

import java.io.Serializable;
import java.util.Map;

import com.itrus.common.result.uag.UagResult;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class EnterpriseResult extends UagResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 企业全称
	 */
	private Map<String,Object> enterpriseMap;
	
	
	public Map<String,Object>  getEnterpriseMap(){
		enterpriseMap = (Map<String,Object>) super.getData();
		return enterpriseMap;
	}
	
}
