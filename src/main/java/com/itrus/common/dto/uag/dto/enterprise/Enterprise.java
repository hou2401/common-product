package com.itrus.common.dto.uag.dto.enterprise;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.itrus.common.dto.uag.dto.user.UserInfoAll;
import com.itrus.common.utils.PublicUtil;

import lombok.Data;

@Data
public class Enterprise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 企业全称
	 */
	private String orgName;
	
	/**
	 * 企业信用代码
	 */
	private String orgCode;
	
	
	/**
	 * 简称集合实体
	 */
	private TreeSet<OrgAlias> orgAliasSet;
	
	/**
	 * 企业用户集合
	 */
	private TreeSet<UserInfoAll> userInfoAllSet;
	
	
	private Map<String,UserInfoAll> userInfoAllMap;
	
	
	/**
	 * list转成map
	 * @return
	 */
	public Map<String,UserInfoAll> getCompanyUserMap(){
		if( PublicUtil.isNotEmpty(userInfoAllSet.isEmpty()) ){
			userInfoAllMap = new HashMap<>(userInfoAllSet.size());
			for (UserInfoAll userInfoAll : userInfoAllSet) {
				userInfoAllMap.put(userInfoAll.getIdCardNum(), userInfoAll);
			}
		}
		return userInfoAllMap;
	}
}
