package com.itrus.common.http;

import java.util.List;

import com.itrus.common.result.uag.request.*;
import com.itrus.common.result.uag.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.result.uag.UagResult;
import com.itrus.common.result.uag.response.entity.BatchAddCompanyErrorResponse;
import com.itrus.common.result.uag.response.entity.BatchAddCompanySuccessResponse;
import com.itrus.common.result.uag.response.entity.BatchAddPersonalErrorResponse;
import com.itrus.common.result.uag.response.entity.BatchAddPersonalSuccessResponse;
import com.itrus.common.result.uag.response.entity.UserInfoCompany;
import com.itrus.common.utils.PublicUtil;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-27 11:33:15
 **/
@Component
public class UagRequest {

    @Autowired
    private UagApiRequest uagApiRequest;

    /**
     * 3.1 个人账号注册
     *
     * @api {post} account/userRegister 用户注册 已经弃用
     * @apiVersion 2.0.0
     * @apiParam {Object} obj 注册参数.
     * @apiName userRegister
     * @apiGroup 账号服务（account）
     * @apiSuccess (Success 0x0000) {JSONObject} json.
     */
//    public UagResult<UUIDResult> userRegister(UserRegisterRequest obj) throws Exception {
//
//        return uagApiRequest.userRegister(obj);
//
//    }

    /**
     * 3.59 openApi-个人账号注册并实名
     *
     * @api {post} account/userRegister 用户注册并实名
     * @apiVersion 2.0.0
     * @apiParam {Object} obj 注册参数.
     * @apiName userRegister
     * @apiGroup 账号服务（account）
     * @apiSuccess (Success 0x0000) {JSONObject} json.
     */
    public UagResult<UUIDResult> userRegisterAndAuth(UserRegisterAndAuthRequest obj) throws Exception {

        return uagApiRequest.userRegisterAndAuth(obj);

    }

    /**
     * 3.5 个人账号实名接口
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userUpdateAuth(UserUpdateAuthRequest obj) throws Exception {
        return uagApiRequest.userUpdateAuth(obj);
    }

    /**
     * 3.3 个人详情
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<ShowUserResult> userShowUser(UserShowUserRequest obj) throws Exception {
        return uagApiRequest.userShowUser(obj);
    }

    /**
     * 3.6 个人申请企业认证
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<UUIDResult> orgRegister(OrgRegisterRequest obj) throws Exception {
        return uagApiRequest.orgRegister(obj);
    }

    /**
     * 3.20 添加成员
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userAdd(UserAddRequest obj) throws Exception {
        return uagApiRequest.userAdd(obj.getUuid(),obj);
    }

    /**
     * 3.23 查看成员详情
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<UserInfoCompany> userShowInCompany(UserShowInCompanyRequest obj) throws Exception {
        return uagApiRequest.userShowInCompany(obj);
    }

    /**
     * 3.30 查询用户已加入企业
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<FindJoinCompanysResult> userFindJoinCompanys(UserFindJoinCompanysRequest obj) throws Exception {
        return uagApiRequest.userFindJoinCompanys(obj);
    }

    /**
     * 3.34 通过uuid集合获取用户信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<SearchByUuidsResult> userSearchByUuids(UserSearchByUuidsRequest obj) throws Exception {
        return uagApiRequest.userSearchByUuids(obj);
    }

    /**
     * 3.35 查询全网指定用户信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<SearchAllResult> userSearchAll(UserSearchAllRequest obj) throws Exception {
        return uagApiRequest.userSearchAll(obj);
    }

    /**
     * 3.36 创建外部联系人-个人
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<BatchAddPersonalSuccessResponse> externalAddPersonal(ExternalAddPersonalRequest obj) throws Exception {
    	
    	ExternalApiAddPersonalRequest externalApiAddPersonalRequest = new ExternalApiAddPersonalRequest(obj);
    	UagResult<ExternalApiAddPersonalResult> externalApiAddPersonal = this.externalApiAddPersonal(externalApiAddPersonalRequest);
    	UagResult<BatchAddPersonalSuccessResponse> success = new UagResult<>();
    	if( externalApiAddPersonal.isOk() ) {
    		
    		ExternalApiAddPersonalResult data = externalApiAddPersonal.getData();
    		if(PublicUtil.isEmpty(data)) {
    			throw new Exception("用户中心无data值");
    		}
    		List<BatchAddPersonalSuccessResponse> successList = data.getSuccessList();
    		List<BatchAddPersonalErrorResponse> errorList = data.getErrorList();
    		if(PublicUtil.isEmpty(successList) && PublicUtil.isNotEmpty(errorList) ) {
    			BatchAddPersonalErrorResponse batchAddCompanyErrorResponse = errorList.get(0);
    			success.setCode(batchAddCompanyErrorResponse.getCode());
    			success.setMsg(batchAddCompanyErrorResponse.getMessage());
    		}else {
                success.setCode(0);
            }
    		success.setData(successList.get(0));
    	}
        return success;
    }


    /**
     * 3.54 openApi-批量创建外部联系人-个人
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<ExternalApiAddPersonalResult> externalApiAddPersonal(ExternalApiAddPersonalRequest obj) throws Exception {
        return uagApiRequest.externalApiAddPersonal(obj);
    }
    /**
     * 3.37 创建外部联系人-企业
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<BatchAddCompanySuccessResponse> externalAddCompany(ExternalAddCompanyRequest obj) throws Exception {
    	
    	ExternalApiBatchAddCompanyRequest externalApiBatchAddCompanyRequest = 
    			new ExternalApiBatchAddCompanyRequest(obj);

    	UagResult<ExternalApiAddCompanyResult> externalApiAddCompany = this.externalApiAddCompany(externalApiBatchAddCompanyRequest);
    	UagResult<BatchAddCompanySuccessResponse> success = new UagResult<>();
    	success.setCode(UagResult.GET_CODE);
		ExternalApiAddCompanyResult data = externalApiAddCompany.getData();
		if(PublicUtil.isEmpty(data)) {
			throw new Exception("用户中心无data值");
		}
		List<BatchAddCompanySuccessResponse> successList = data.getSuccessList();
		List<BatchAddCompanyErrorResponse> errorList = data.getErrorList();
		if(PublicUtil.isEmpty(successList) && PublicUtil.isNotEmpty(errorList) ) {
			BatchAddCompanyErrorResponse batchAddCompanyErrorResponse = errorList.get(0);
			success.setCode(batchAddCompanyErrorResponse.getCode());
			success.setMsg(batchAddCompanyErrorResponse.getMessage());
			return success;
		}
		success.setData(successList.get(0));
    	return success;
    }

    /**
     * 3.55 openApi-批量创建外部联系人-企业
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<ExternalApiAddCompanyResult> externalApiAddCompany(ExternalApiBatchAddCompanyRequest obj) throws Exception {
        return uagApiRequest.externalApiAddCompany(obj);
    }

    /**
     * 3.50 加载企业下全量节点信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject orgLoadTree(OrgLoadTreeRequest obj) throws Exception {
        return uagApiRequest.orgLoadTree(obj);
    }

    /**
     * 3.52 获取指定企业下的超管列表
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<UserFindCompanySuperAdminListResult> userFindCompanySuperAdminList(UserFindCompanySuperAdminListRequest obj) throws Exception {
        return uagApiRequest.userFindCompanySuperAdminList(obj);
    }

    /**
     * 企业详情
     *  3.53 企业平台-企业详情适用
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<OrgShowResult> orgShow(OrgShowRequest obj) throws Exception {
        return uagApiRequest.orgShow(obj);
    }

    /**
     *  openApi-通过uuid集合获取指定企业下用户信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject searchByUuidsInCompany(UserSearchByUuidsRequest obj) throws Exception {
        return uagApiRequest.searchByUuidsInCompany(obj);
    }
}
