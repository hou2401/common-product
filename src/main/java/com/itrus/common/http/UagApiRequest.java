package com.itrus.common.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.response.atom.RegisterResult;
import com.itrus.common.result.uag.request.UagResult;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-27 11:19:18
 **/
@Component
@FeignClient(value = "${http.uag}") //value:被调用的服务在注册中心的名称
public interface UagApiRequest {


	@RequestMapping(value = "/user/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<RegisterResult> userRegister(Object obj);
	
	
	@RequestMapping(value = "/user/updateAuth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userUpdateAuth(Object obj);
	
	
	@RequestMapping(value = "/user/showUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userShowUser(Object obj);
	
	
	@RequestMapping(value = "/org/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> orgRegister(Object obj);
	
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userAdd(Object obj);
	
	
	@RequestMapping(value = "/user/showInCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userShowInCompany(Object obj);
	
	
	@RequestMapping(value = "/user/findJoinCompanys", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userFindJoinCompanys(Object obj);
	
	
	@RequestMapping(value = "/user/searchByUuids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userSearchByUuids(Object obj);
	
	
	@RequestMapping(value = "/user/searchAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userSearchAll(Object obj);
	
	
	@RequestMapping(value = "/external/addPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> externalAddPersonal(Object obj);
	
	
	@RequestMapping(value = "/external/addCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> externalAddCompany(Object obj);
	
	
	@RequestMapping(value = "/externalApi/addPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> externalApiAddPersonal(Object obj);
	
	
	@RequestMapping(value = "/externalApi/addCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> externalApiAddCompany(Object obj);
	
	
	@RequestMapping(value = "/org/loadTree", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> orgLoadTree(Object obj);
	
	
	@RequestMapping(value = "/user/findCompanySuperAdminList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> userFindCompanySuperAdminList(Object obj);
	
	
	@RequestMapping(value = "/org/show", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UagResult<JSONObject> orgShow(Object obj);


    

}
