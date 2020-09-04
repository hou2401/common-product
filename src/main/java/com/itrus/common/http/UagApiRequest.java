package com.itrus.common.http;

import com.itrus.common.result.uag.request.*;
import com.itrus.common.result.uag.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.result.uag.UagResult;
import com.itrus.common.result.uag.response.entity.UserInfoCompany;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-27 11:19:18
 **/
@FeignClient(value = "${http.uag}") //value:被调用的服务在注册中心的名称
public interface UagApiRequest {

// 	已经弃用
//    @RequestMapping(value = "/userApi/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public UagResult<UUIDResult> userRegister(UserRegisterRequest obj);
    
    
    @RequestMapping(value = "/userApi/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UUIDResult> userRegisterAndAuth(UserRegisterAndAuthRequest obj);


    @RequestMapping(value = "/userApi/updateAuth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<JSONObject> userUpdateAuth(UserUpdateAuthRequest obj);


    @RequestMapping(value = "/userApi/showUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<ShowUserResult> userShowUser(UserShowUserRequest obj);


    @RequestMapping(value = "/orgApi/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UUIDResult> orgRegister(OrgRegisterRequest obj);


    @RequestMapping(value = "/userApi/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<JSONObject> userAdd(@RequestHeader(value = "uuid")String uuid,UserAddRequest obj);


    @RequestMapping(value = "/userApi/showInCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UserInfoCompany> userShowInCompany(UserShowInCompanyRequest obj);


    @RequestMapping(value = "/userApi/findJoinCompanys", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<FindJoinCompanysResult> userFindJoinCompanys(UserFindJoinCompanysRequest obj);


    @RequestMapping(value = "/userApi/searchByUuids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<SearchByUuidsResult> userSearchByUuids(UserSearchByUuidsRequest obj);


    @RequestMapping(value = "/userApi/searchAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<SearchAllResult> userSearchAll(UserSearchAllRequest obj);


//    @RequestMapping(value = "/external/addPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public UagResult<JSONObject> externalAddPersonal(ExternalAddPersonalRequest obj);


//    @RequestMapping(value = "/external/addCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public UagResult<JSONObject> externalAddCompany(ExternalAddCompanyRequest obj);


    @RequestMapping(value = "/externalApi/addPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<ExternalApiAddPersonalResult> externalApiAddPersonal(ExternalApiAddPersonalRequest obj);

    @RequestMapping(value = "/externalApi/addCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<ExternalApiAddCompanyResult> externalApiAddCompany(ExternalApiBatchAddCompanyRequest obj);


    @RequestMapping(value = "/orgApi/loadTree", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject  orgLoadTree(OrgLoadTreeRequest obj);


    @RequestMapping(value = "/userApi/findCompanySuperAdminList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UserFindCompanySuperAdminListResult> userFindCompanySuperAdminList(UserFindCompanySuperAdminListRequest obj);


    @RequestMapping(value = "/orgApi/show", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<OrgShowResult> orgShow(OrgShowRequest obj);

    @RequestMapping(value = "/userApi/searchByUuidsInCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject searchByUuidsInCompany(UserSearchByUuidsRequest obj);
}
