package com.itrus.common.http;

import com.itrus.common.result.uag.UagResult;
import com.itrus.common.result.uag.request.*;
import com.itrus.common.result.uag.request.ExternalApiAddPersonalRequest;
import com.itrus.common.result.uag.response.*;
import com.itrus.common.result.uag.response.entity.UserInfoCompany;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-27 11:19:18
 **/
@FeignClient(value = "${http.uag}") //value:被调用的服务在注册中心的名称
public interface UagApiRequest {


    @RequestMapping(value = "/user/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UUIDResult> userRegister(UserRegisterRequest obj);


    @RequestMapping(value = "/user/updateAuth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<JSONObject> userUpdateAuth(UserUpdateAuthRequest obj);


    @RequestMapping(value = "/user/showUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<ShowUserResult> userShowUser(UserShowUserRequest obj);


    @RequestMapping(value = "/org/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UUIDResult> orgRegister(OrgRegisterRequest obj);


    @RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<JSONObject> userAdd(UserAddRequest obj);


    @RequestMapping(value = "/user/showInCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UserInfoCompany> userShowInCompany(UserShowInCompanyRequest obj);


    @RequestMapping(value = "/user/findJoinCompanys", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<FindJoinCompanysResult> userFindJoinCompanys(UserFindJoinCompanysRequest obj);


    @RequestMapping(value = "/user/searchByUuids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<SearchByUuidsResult> userSearchByUuids(UserSearchByUuidsRequest obj);


    @RequestMapping(value = "/user/searchAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<SearchAllResult> userSearchAll(UserSearchAllRequest obj);


    @RequestMapping(value = "/external/addPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<JSONObject> externalAddPersonal(ExternalAddPersonalRequest obj);


    @RequestMapping(value = "/external/addCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<JSONObject> externalAddCompany(ExternalAddCompanyRequest obj);


    @RequestMapping(value = "/externalApi/addPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<ExternalApiAddPersonalResult> externalApiAddPersonal(ExternalApiAddPersonalRequest obj);


    @RequestMapping(value = "/externalApi/addCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<ExternalApiAddCompanyResult> externalApiAddCompany(ExternalApiAddCompanyRequest obj);


    @RequestMapping(value = "/org/loadTree", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<LoadTreeResult>  orgLoadTree(OrgLoadTreeRequest obj);


    @RequestMapping(value = "/user/findCompanySuperAdminList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<UserFindCompanySuperAdminListResult> userFindCompanySuperAdminList(UserFindCompanySuperAdminListRequest obj);


    @RequestMapping(value = "/org/show", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UagResult<OrgShowResult> orgShow(OrgShowRequest obj);


}
