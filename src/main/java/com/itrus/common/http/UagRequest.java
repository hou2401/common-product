package com.itrus.common.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.response.atom.RegisterResult;
import com.itrus.common.result.uag.request.UagResult;

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
    *
    * @api {post} account/userRegister 用户注册
    * @apiVersion 2.0.0
    * @apiParam {Object} obj 注册参数.
    * @apiName userRegister
    * @apiGroup 账号服务（account）
    * @apiSuccess (Success 0x0000) {JSONObject} json.
	*/
    public UagResult<RegisterResult> userRegister(Object obj) throws Exception {
    	
        return uagApiRequest.userRegister(obj);

    }

    /**
     * 用户实名
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userUpdateAuth(Object obj) throws Exception {
        return uagApiRequest.userUpdateAuth(obj);
    }
    
    /**
     * 用户详情
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userShowUser(Object obj) throws Exception {
    	return uagApiRequest.userShowUser(obj);
    }
    
    /**
     * api-企业创建
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> orgRegister(Object obj) throws Exception {
    	return uagApiRequest.orgRegister(obj);
    }
    
    /**
     * api-企业添加成员
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userAdd(Object obj) throws Exception {
    	return uagApiRequest.userAdd(obj);
    }
    
    /**
     * api-查看企业成员信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userShowInCompany(Object obj) throws Exception {
    	return uagApiRequest.userShowInCompany(obj);
    }
    
    /**
     * api-查看用户已加入的企业
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userFindJoinCompanys(Object obj) throws Exception {
    	return uagApiRequest.userFindJoinCompanys(obj);
    }
    
    /**
     * api-通过uuid集合获取用户信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userSearchByUuids(Object obj) throws Exception {
    	return uagApiRequest.userSearchByUuids(obj);
    }
    
    /**
     * 查询全网指定用户信息
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userSearchAll(Object obj) throws Exception {
    	return uagApiRequest.userSearchAll(obj);
    }
    
    /**
     * 创建外部联系人-个人
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> externalAddPersonal(Object obj) throws Exception {
    	return uagApiRequest.externalAddPersonal(obj);
    }
    
    /**
     * 创建外部联系人-企业
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> externalAddCompany(Object obj) throws Exception {
    	return uagApiRequest.externalAddCompany(obj);
    }
    
    /**
     * 批量创建外部联系人-个人
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> externalApiAddPersonal(Object obj) throws Exception {
    	return uagApiRequest.externalApiAddPersonal(obj);
    }
    
    /**
     * 批量创建外部联系人-企业
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> externalApiAddCompany(Object obj) throws Exception {
    	return uagApiRequest.externalApiAddCompany(obj);
    }
    
    /**
     * 加载企业树
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> orgLoadTree(Object obj) throws Exception {
    	return uagApiRequest.orgLoadTree(obj);
    }
    
    /**
     * 获取企业下的超管列表
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> userFindCompanySuperAdminList(Object obj) throws Exception {
    	return uagApiRequest.userFindCompanySuperAdminList(obj);
    }
    
    /**
     * 企业详情
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public UagResult<JSONObject> orgShow(Object obj) throws Exception {
    	return uagApiRequest.orgShow(obj);
    }
    
    

    


}
