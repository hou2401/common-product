package com.itrus.common.http;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.params.uag.BetchImportParams;
import com.itrus.common.params.uag.DeptParams;
import com.itrus.common.params.uag.EntListParams;
import com.itrus.common.params.uag.EntLoadTreeParams;
import com.itrus.common.params.uag.EntSearchInfoParams;
import com.itrus.common.params.uag.GrantAuthParams;
import com.itrus.common.params.uag.JoinEnterpriseParams;
import com.itrus.common.params.uag.JoinToEntParams;
import com.itrus.common.params.uag.ReJoinEnterpriseParams;
import com.itrus.common.params.uag.RemoveUserParams;
import com.itrus.common.params.uag.SearchOneNodeParams;
import com.itrus.common.params.uag.SwicthParams;
import com.itrus.common.params.uag.UagOrgParams;
import com.itrus.common.params.uag.UserDimissionParams;
import com.itrus.common.params.uag.UserListParams;
import com.itrus.common.params.uag.UserParams;
import com.itrus.common.params.uag.UserSearchInfoParams;
import com.itrus.common.params.uag.user.RegisterParams;
import com.itrus.common.result.uag.user.RegisterResult;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-2-25 12:04:04
 **/
@Component
public class UagRequest {

    @Autowired
    private HttpDTO http;

    @Autowired
    private HttpRequset httpRequset;

    @Autowired
    private CallApiRequest callApiRequest;

    /**
     *	 公共请求对象
     *
     * @return 返回实例
     */
	/*public static CommonRequest getInstance() {
        return REQUEST;
    }*/

    /**
     * 是否是http调用模式
     *
     * @return
     * @throws HttpException
     */
    private boolean httped() throws HttpException {
        return http.httped();
    }

    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * UAG组织架构服务
     */
    //-----------------------------------------------------------------------------------------------------------------------

    /**
     * 用户注册
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    /**
    *
    * @api {post} account/userRegister 用户注册
    * @apiVersion 2.0.0
    * @apiParam {Object} obj 注册参数.
    * @apiName userRegister
    * @apiGroup 账号服务（account）
    * @apiSuccess (Success 0x0000) {JSONObject} json.
	*/
    public RegisterResult userRegister(RegisterParams obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.userRegister(obj);
            } else {
                result = callApiRequest.userRegister(obj);
            }
            if (result != null) {
                break;
            }
        }
        // 直接转换成对象，方便后续使用
        RegisterResult overResult = null;
        if( result != null ) {
        	overResult = JSONObject.toJavaObject(result, RegisterResult.class);
        }
        return overResult;

    }

    /**
     * 用户更新
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    /**
    *
    * @api {post} account/userUpdate 用户更新
    * @apiVersion 2.0.0
    * @apiUse UserParams 
    * @apiName userRegister
    * @apiGroup 账号服务（account）
    * @apiSuccess (Success 0x0000) {JSONObject} json.
	*/
    public JSONObject userUpdate(UserParams userParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.userUpdate(userParams);
            } else {
                result = callApiRequest.userUpdate(userParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 用户详细信息查询
     *
     * @param userSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject userSearchInfo(UserSearchInfoParams userSearchInfoParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.userSearchInfo(userSearchInfoParams);
            } else {
                result = callApiRequest.userSearchInfo(userSearchInfoParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 用户更新/重置/忘记密码
     *
     * @param updateUtsNodeParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject resetPassWd(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.resetPassWd(obj);
            } else {
                result = callApiRequest.resetPassWd(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 创建企业
     *
     * @param adminAuthParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entAdd(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entAdd(obj);
            } else {
                result = callApiRequest.entAdd(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 更新企业
     *
     * @param adminAuthParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entUpdate(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entUpdate(obj);
            } else {
                result = callApiRequest.entUpdate(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }
    /**
     * 更新企业基本信息
     *
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entUpdateBase(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entUpdateBase(obj);
            } else {
                result = callApiRequest.entUpdateBase(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 删除企业 ---慎用
     *
     * @param adminAuthParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entDelete(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entDelete(obj);
            } else {
                result = callApiRequest.entDelete(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 企业详细信息查询
     *
     * @param entSearchInfoParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entSearchInfo(EntSearchInfoParams entSearchInfoParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entSearchInfo(entSearchInfoParams);
            } else {
                result = callApiRequest.entSearchInfo(entSearchInfoParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }


    /**
     * 创建部门
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject deptAdd(DeptParams deptParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.deptAdd(deptParams);
            } else {
                result = callApiRequest.deptAdd(deptParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 更新部门
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject deptUpdate(DeptParams deptParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.deptUpdate(deptParams);
            } else {
                result = callApiRequest.deptUpdate(deptParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 查询部门详情信息
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject deptSearchInfo(DeptParams deptParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.deptSearchInfo(deptParams);
            } else {
                result = callApiRequest.deptSearchInfo(deptParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 部门删除
     *
     * @param uagOrgParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject deptDelete(DeptParams deptParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.deptDelete(deptParams);
            } else {
                result = callApiRequest.deptDelete(deptParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 查询企业下一级节点信息
     *
     * @param searchOneNodeParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entSearchOneNode(SearchOneNodeParams searchOneNodeParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entSearchOneNode(searchOneNodeParams);
            } else {
                result = callApiRequest.entSearchOneNode(searchOneNodeParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 查询部门下一级节点信息
     *
     * @param searchOneNodeParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject deptSearchOneNode(SearchOneNodeParams searchOneNodeParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.deptSearchOneNode(searchOneNodeParams);
            } else {
                result = callApiRequest.deptSearchOneNode(searchOneNodeParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 查询企业下全部节点信息
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entAll(UagOrgParams uagOrgParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entAll(uagOrgParams);
            } else {
                result = callApiRequest.entAll(uagOrgParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }


    /**
     * 加载企业树
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject entLoadTree(EntLoadTreeParams entLoadTreeParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.entLoadTree(entLoadTreeParams);
            } else {
                result = callApiRequest.entLoadTree(entLoadTreeParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }


    /**
     * 查询部门下全部节点信息
     *
     * @param uagOrgParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject deptAll(UagOrgParams uagOrgParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.deptAll(uagOrgParams);
            } else {
                result = callApiRequest.deptAll(uagOrgParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 查询当前用户加入的企业列表
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject findJoinCompanys(EntListParams entListParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.findJoinCompanys(entListParams);
            } else {
                result = callApiRequest.findJoinCompanys(entListParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 批量导入
     *
     * @param betchImportParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject betchImport(BetchImportParams betchImportParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.betchImport(betchImportParams);
            } else {
                result = callApiRequest.betchImport(betchImportParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 移除邀约用户
     *
     * @param removeUserParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject removeUser(RemoveUserParams removeUserParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.removeUser(removeUserParams);
            } else {
                result = callApiRequest.removeUser(removeUserParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 用户切换企业
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject switchEnterprise(SwicthParams swicthParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.switchEnterprise(swicthParams);
            } else {
                result = callApiRequest.switchEnterprise(swicthParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 企业邀请用户
     *
     * @param joinEnterpriseParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject joinEnterprise(JoinEnterpriseParams joinEnterpriseParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.joinEnterprise(joinEnterpriseParams);
            } else {
                result = callApiRequest.joinEnterprise(joinEnterpriseParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 编辑企业成员邀请信息，重新发起邀请
     *
     * @param reJoinEnterpriseParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject reJoinEnterprise(ReJoinEnterpriseParams reJoinEnterpriseParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.reJoinEnterprise(reJoinEnterpriseParams);
            } else {
                result = callApiRequest.reJoinEnterprise(reJoinEnterpriseParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 口令认证(密码登录)
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject passwdAuth(Object object) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.passwdAuth(object);
            } else {
                result = callApiRequest.passwdAuth(object);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 获取短信验证码
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject getVerificationCode(Object object) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.getVerificationCode(object);
            } else {
                result = callApiRequest.getVerificationCode(object);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 验证短信验证码
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject verifySmsCodeAuth(Object object) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.verifySmsCodeAuth(object);
            } else {
                result = callApiRequest.verifySmsCodeAuth(object);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 退出单点登录
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject logout(Object object) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.logout(object);
            } else {
                result = callApiRequest.logout(object);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 添加扩展属性
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject extendedAdd(Object object) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.extendedAdd(object);
            } else {
                result = callApiRequest.extendedAdd(object);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 查询当前节点下uuid集合
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject findChildUuidList(Object object) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.findChildUuidList(object);
            } else {
                result = callApiRequest.findChildUuidList(object);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 用户授权接口
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject grantAuth(GrantAuthParams authParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.grantAuth(authParams);
            } else {
                result = callApiRequest.grantAuth(authParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 根据手机号或uuid集合查询用户信息
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject findUserInfoByUuidList(UserListParams params) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.findUserInfoByUuidList(params);
            } else {
                result = callApiRequest.findUserInfoByUuidList(params);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 全量查询企业和用户信息
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject findAllEnterpriseAndUser(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.findAllEnterpriseAndUser(obj);
            } else {
                result = callApiRequest.findAllEnterpriseAndUser(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }


    /**
     * 全量查询企业和用户信息
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject findSuperManagerForCompany(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.findSuperManagerForCompany(obj);
            } else {
                result = callApiRequest.findSuperManagerForCompany(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 实名用户接口
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject updateAuth(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.updateAuth(obj);
            } else {
                result = callApiRequest.updateAuth(obj);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 用户同意加入企业
     *
     * @param object 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject joinToEnterprise(JoinToEntParams joinToEntParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.joinToEnterprise(joinToEntParams);
            } else {
                result = callApiRequest.joinToEnterprise(joinToEntParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 更新用户企业内信息
     *
     * @param userParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject updateUserInfoInEnterprise(UserParams userParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.updateUserInfoInEnterprise(userParams);
            } else {
                result = callApiRequest.updateUserInfoInEnterprise(userParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 员工从指定企业离职接口
     *
     * @param userDimissionParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject userDimission(UserDimissionParams userDimissionParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.userDimission(userDimissionParams);
            } else {
                result = callApiRequest.userDimission(userDimissionParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }
    
    
    /**
     * 员工从指定企业离职接口
     *
     * @param userDimissionParams 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject userDelete(UserParams userParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.userDelete(userParams);
            } else {
                result = callApiRequest.userDelete(userParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

}
