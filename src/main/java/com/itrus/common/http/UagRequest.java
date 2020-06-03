package com.itrus.common.http;

import com.itrus.common.params.uag.*;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.params.uag.DeptParams;
import com.itrus.common.params.uag.EntListParams;
import com.itrus.common.params.uag.GrantAuthParams;
import com.itrus.common.params.uag.SwicthParams;
import com.itrus.common.params.uag.UagOrgParams;
import com.itrus.common.params.uag.UserListParams;
import com.itrus.common.params.uag.UserParams;
import lombok.extern.slf4j.Slf4j;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-2-25 12:04:04
 **/
@Slf4j
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
	 * @return
	 * @throws HttpException 
	 */
	private boolean httped() throws HttpException {
		return http.httped();
	}

	/**
	 *     请求是否OK
	 *
	 * @param object json对象
	 */
	public boolean isOk(JSONObject object) {
		if(object.get("code") != null || object.get("status") != null){
			return   object.getIntValue("code") == 0 || object.getIntValue("status") == 1 ;

		}
		return false;

	}

	/**
	 * 获取请求消息
	 *
	 * @param object json对象
	 */
	public String getMsg(JSONObject object) {
		return object.getString("msg") == null ? object.getString("message") : object.getString("msg");
	}

	/**
	 * 获取请求消息
	 *
	 * @param object json对象
	 */
	public int getCode(JSONObject object) {
		return object.getIntValue("code");
	}
	
	
	/**
	 * 获取请求消息
	 *
	 * @param object json对象
	 * @return 
	 */
	public  JSONObject getData (JSONObject object) {
		if( object == null ) {
			return null;
		}
		return (JSONObject) object.get("data");
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
	public JSONObject userRegister( Object obj ) throws Exception {
		log.info("用户注册入参："+JSON.toJSONString(obj));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.userRegister(obj);
			}else {
				result = callApiRequest.userRegister(obj);
			}
			if(result != null) {
				break;
			}
		}
		return result;

	}
	
	/**
	 * 用户更新
	 *
	 * @param obj 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject userUpdate( UserParams userParams ) throws Exception {
		log.info("用户更新入参："+JSON.toJSONString(userParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.userUpdate(userParams);
			}else {
				result = callApiRequest.userUpdate(userParams);
			}
			if(result != null) {
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
	public JSONObject userSearchInfo( UserSearchInfoParams userSearchInfoParams ) throws Exception {
		log.info("用户详细信息入参："+JSON.toJSONString(userSearchInfoParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.userSearchInfo(userSearchInfoParams);
			}else {
				result = callApiRequest.userSearchInfo(userSearchInfoParams);
			}
			if(result != null) {
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
	public JSONObject resetPassWd( Object obj ) throws Exception {
		log.info("用户更新/重置/忘记密码入参："+JSON.toJSONString(obj));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.resetPassWd(obj);
			}else {
				result = callApiRequest.resetPassWd(obj);
			}
			if(result != null) {
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
	public JSONObject entAdd( Object obj ) throws Exception {
		log.info("创建企业入参："+JSON.toJSONString(obj));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.entAdd(obj);
			}else {
				result = callApiRequest.entAdd(obj);
			}
			if( result != null ) {
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
	public JSONObject entUpdate( Object obj ) throws Exception {
		log.info("更新企业入参："+JSON.toJSONString(obj));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.entUpdate(obj);
			}else {
				result = callApiRequest.entUpdate(obj);
			}
			if(result != null) {
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
	public JSONObject entSearchInfo( EntSearchInfoParams entSearchInfoParams ) throws Exception {
		log.info("企业详细信息查询入参："+JSON.toJSONString(entSearchInfoParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.entSearchInfo(entSearchInfoParams);
			}else {
				result = callApiRequest.entSearchInfo(entSearchInfoParams);
			}
			if(result != null) {
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
	public JSONObject deptAdd( DeptParams deptParams ) throws Exception {
		log.info("创建部门入参："+JSON.toJSONString(deptParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.deptAdd(deptParams);
			}else {
				result = callApiRequest.deptAdd(deptParams);
			}
			if(result != null) {
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
	public JSONObject deptUpdate( DeptParams deptParams ) throws Exception {
		log.info("更新部门入参："+JSON.toJSONString(deptParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.deptUpdate(deptParams);
			}else {
				result = callApiRequest.deptUpdate(deptParams);
			}
			if( result != null ) {
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
	public JSONObject deptSearchInfo( DeptParams deptParams ) throws Exception {
		log.info("插叙部门详情信息入参："+JSON.toJSONString(deptParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.deptSearchInfo(deptParams);
			}else {
				result = callApiRequest.deptSearchInfo(deptParams);
			}
			if( result != null) {
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
	public JSONObject deptDelete( DeptParams deptParams ) throws Exception {
		log.info("部门删除入参："+JSON.toJSONString(deptParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.deptDelete(deptParams);
			}else {
				result = callApiRequest.deptDelete(deptParams);
			}
			if(result != null ) {
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
	public JSONObject entSearchOneNode( SearchOneNodeParams searchOneNodeParams ) throws Exception {
		log.info("查询企业下一级节点信息入参："+JSON.toJSONString(searchOneNodeParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.entSearchOneNode(searchOneNodeParams);
			}else {
				result = callApiRequest.entSearchOneNode(searchOneNodeParams);
			}
			if(result != null) {
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
	public JSONObject deptSearchOneNode( SearchOneNodeParams searchOneNodeParams ) throws Exception {
		log.info("查询部门下一级节点信息入参："+JSON.toJSONString(searchOneNodeParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.deptSearchOneNode(searchOneNodeParams);
			}else {
				result = callApiRequest.deptSearchOneNode(searchOneNodeParams);
			}
			if( result != null ) {
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
	public JSONObject entAll( UagOrgParams uagOrgParams ) throws Exception {
		log.info("查询企业下全部节点信息入参："+JSON.toJSONString(uagOrgParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.entAll(uagOrgParams);
			}else {
				result = callApiRequest.entAll(uagOrgParams);
			}
			if(result != null ) {
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
	public JSONObject deptAll( UagOrgParams uagOrgParams ) throws Exception {
		log.info("查询部门下全部节点信息入参："+JSON.toJSONString(uagOrgParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.deptAll(uagOrgParams);
			}else {
				result = callApiRequest.deptAll(uagOrgParams);
			}
			if(result != null ) {
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
	public JSONObject findJoinCompanys( EntListParams entListParams ) throws Exception {
		log.info("查询当前用户加入的企业列表入参："+JSON.toJSONString(entListParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.findJoinCompanys(entListParams);
			}else {
				result = callApiRequest.findJoinCompanys(entListParams);
			}
			if(result != null ) {
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
	public JSONObject betchImport( BetchImportParams betchImportParams ) throws Exception {
		log.info("批量导入入参："+JSON.toJSONString(betchImportParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.betchImport(betchImportParams);
			}else {
				result = callApiRequest.betchImport(betchImportParams);
			}
			if(result != null ) {
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
	public JSONObject removeUser( RemoveUserParams removeUserParams ) throws Exception {
		log.info("批量导入入参："+JSON.toJSONString(removeUserParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.removeUser(removeUserParams);
			}else {
				result = callApiRequest.removeUser(removeUserParams);
			}
			if(result != null ) {
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
	public JSONObject switchEnterprise( SwicthParams swicthParams ) throws Exception {
		log.info("用户切换企业入参："+JSON.toJSONString(swicthParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.switchEnterprise(swicthParams);
			}else {
				result = callApiRequest.switchEnterprise(swicthParams);
			}
			if(result != null ) {
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
	public JSONObject joinEnterprise( JoinEnterpriseParams joinEnterpriseParams ) throws Exception {
		log.info("企业邀请用户入参："+JSON.toJSONString(joinEnterpriseParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.joinEnterprise(joinEnterpriseParams);
			}else {
				result = callApiRequest.joinEnterprise(joinEnterpriseParams);
			}
			if(result != null ) {
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
	public JSONObject passwdAuth( Object object ) throws Exception {
		log.info("口令认证入参："+JSON.toJSONString(object));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.passwdAuth(object);
			}else {
				result = callApiRequest.passwdAuth(object);
			}
			if(result != null ) {
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
	public JSONObject getVerificationCode( Object object ) throws Exception {
		log.info("获取短信验证码入参："+JSON.toJSONString(object));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.getVerificationCode(object);
			}else {
				result = callApiRequest.getVerificationCode(object);
			}
			if(result != null ) {
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
	public JSONObject verifySmsCodeAuth( Object object ) throws Exception {
		log.info("验证短信验证码入参："+JSON.toJSONString(object));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.verifySmsCodeAuth(object);
			}else {
				result = callApiRequest.verifySmsCodeAuth(object);
			}
			if(result != null ) {
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
	public JSONObject logout( Object object ) throws Exception {
		log.info("退出单点登录入参："+JSON.toJSONString(object));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.logout(object);
			}else {
				result = callApiRequest.logout(object);
			}
			if(result != null ) {
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
	public JSONObject extendedAdd( Object object ) throws Exception {
		log.info("添加扩展属性入参："+JSON.toJSONString(object));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.extendedAdd(object);
			}else {
				result = callApiRequest.extendedAdd(object);
			}
			if(result != null ) {
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
	public JSONObject findChildUuidList( Object object ) throws Exception {
		log.info("查询当前节点下uuid集合入参："+JSON.toJSONString(object));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.findChildUuidList(object);
			}else {
				result = callApiRequest.findChildUuidList(object);
			}
			if(result != null ) {
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
	public JSONObject grantAuth( GrantAuthParams authParams ) throws Exception {
		log.info("用户授权接口入参："+JSON.toJSONString(authParams));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.grantAuth(authParams);
			}else {
				result = callApiRequest.grantAuth(authParams);
			}
			if(result != null ) {
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
	public JSONObject findUserInfoByUuidList( UserListParams params ) throws Exception {
		log.info("用户授权接口入参："+JSON.toJSONString(params));
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.findUserInfoByUuidList(params);
			}else {
				result = callApiRequest.findUserInfoByUuidList(params);
			}
			if(result != null ) {
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
	public JSONObject findAllEnterpriseAndUser(Object obj ) throws Exception {
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.findAllEnterpriseAndUser(obj);
			}else {
				result = callApiRequest.findAllEnterpriseAndUser(obj);
			}
			if(result != null ) {
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
	public JSONObject findSuperManagerForCompany(Object obj ) throws Exception {
		JSONObject result = null;
		for (int i = 0; i < http.getRetryCount(); i++) {
			if(httped()) {
				result = httpRequset.findSuperManagerForCompany(obj);
			}else {
				result = callApiRequest.findSuperManagerForCompany(obj);
			}
			if(result != null ) {
				break;
			}
		}
		return result;
		
	}

}
