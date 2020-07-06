package com.itrus.common.http;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.itrus.common.params.uag.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpUrlDTO;
import com.itrus.common.exception.AuthException;
import com.itrus.common.exception.EnterpriseAuthException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.params.AuthEnterpriseParams;
import com.itrus.common.params.AuthParams;
import com.itrus.common.params.AuthPersionParams;
import com.itrus.common.params.AuthPersionVideoParams;
import com.itrus.common.utils.HttpTools;
import com.itrus.common.utils.HttpUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HttpRequset {
	
	/**
	 * http 请求头设置
	 */
	public static final String CONTENT_SIGNATURE = "Content-Signature";
	public static final String CONTEXT_TYPE = "Content-type";
	public static final String CONTEXT_TYPE_JSON = "application/json";
	/**
	 * appId
	 */
	public static final  String APP_ID = "appId";
	/**
	 * serviceCode
	 */
	public static final  String SERVICE_CODE = "serviceCode";

	@Autowired
	private HttpUrlDTO httpUrl;

	/**
	 *
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public  JSONObject createCircularSeal(Object kvs) throws Exception {
		return http(kvs, httpUrl.getCreateCircularSeal());
	}

	/**
	 *
	 * @param hospitalSeal
	 * @return
	 * @throws Exception
	 */
	public  JSONObject createEllipseSeal(Object kvs) throws Exception {
		return http(kvs, httpUrl.getCreateEllipseSeal());
	}

	/**
	 * 证书申请
	 * @param cert
	 * @return
	 * @throws Exception
	 */
	public JSONObject applyCert(Object kvs) throws Exception {
		return http(kvs, httpUrl.getCertApply());
	}

	/**
	 * 证书更新
	 * @param cert
	 * @return
	 * @throws Exception
	 */
	public JSONObject updateCert(Object kvs) throws Exception {
		return http(kvs, httpUrl.getCertUpdate());
	}

	/**
	 *  视频h5核身功能
	 *  支持熟读
	 * @param doctorQuery
	 * @return
	 * @throws Exception
	 */
	public JSONObject authPersionVideo(AuthPersionVideoParams persion) throws PersionAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(persion.getUrl(), persion.getParams(), persion.getHeader());
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new PersionAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("异常错误:{},入参：persion={},返回结果：{}",e.getMessage(),persion.toString(), doPost,e);
			throw new PersionAuthException(e);
		}
	}


	/**
	 *  个人实名认证   
		不支持视频h5核身功能
	 * @param doctorQuery
	 * @return
	 * @throws PersionAuthException 
	 * @throws Exception
	 */
	public JSONObject authPersion(AuthPersionParams persion) throws PersionAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(persion.getUrl(), persion.getParams(), persion.getHeader());
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new PersionAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("异常错误:{},入参：persion={},返回结果：{}",e.getMessage(),persion.toString(), doPost,e);
			throw new PersionAuthException(e);
		}
	}
	
	/**
	 * 企业实名认证
	 * @param enterprise
	 * @return
	 * @throws EnterpriseAuthException
	 */
	public JSONObject authEnterprise( AuthEnterpriseParams enterprise ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(enterprise.getUrl(), enterprise.getParams(), enterprise.getHeader());
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new PersionAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("异常错误:{},入参：enterprise={},返回结果：{}",e.getMessage(),enterprise.toString(), doPost,e);
			throw new EnterpriseAuthException(e);
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject bankList( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(authParams.getUrl(), new HashMap<>(0), new HashMap<>(0));
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("银行列表查询失败:",e);
			throw new AuthException("银行列表查询失败");
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject provinceList( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authParams.getUrl(), new HashMap<>(0), new HashMap<>(0));
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取银行省份信息失败:",e);
			throw new AuthException("获取银行省份信息失败");
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject cityList( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authParams.getUrl(), authParams.getCityList(), authParams.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取银行城市失败:",e);
			throw new AuthException("获取银行城市失败");
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject branchBankList( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authParams.getUrl(), authParams.getBranchBankList(), authParams.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new AuthException("获取付款银行支行信息失败");
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject payBank( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authParams.getUrl(), authParams.getPayBankParams(), authParams.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new AuthException("获取付款银行支行信息失败");
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject queryPayBank( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authParams.getUrl(), authParams.getQueryAmount(), authParams.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new AuthException("获取付款银行支行信息失败");
		}
	}
	
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	public JSONObject verifyPayBank( AuthParams authParams ) throws AuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authParams.getUrl(), authParams.getQueryAmount(), authParams.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new AuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new AuthException("获取付款银行支行信息失败");
		}
	}
	
	/**
	 * 图片上传
	 *
	 * @param uploadQuery
	 * @param uploadImageUrl
	 * @return
	 * @throws Exception
	 */
	public JSONObject uploadBase64(Object kvs) throws Exception {
		return http(kvs, httpUrl.getFileUploadBase64());
	}

	/**
	 * 文件删除
	 * @param fssId
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject fileDelete(Long fssId) throws Exception {
		Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
		return http(params, httpUrl.getFileDelete());
	}


	/**
	 * 
	 * 文件下载
	 * @param fssId
	 * @param downLoadUrl
	 * @return
	 * @throws Exception
	 */
	public JSONObject downLoadBase64(Long fssId) throws Exception {
		Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
		return http(params, httpUrl.getFileDownloadBase64());
	}

	/**
	 * 签章
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject sign(Object kvs) throws Exception {
		return http(kvs, httpUrl.getDsvsSign());
	}

	/**
	 * pdf生成
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfFill(Object kvs) throws Exception {
		return http(kvs, httpUrl.getPdfFill());
	}

	/**
	 * 添加文本水印
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfTextMark(Object kvs) throws Exception {
		return http(kvs, httpUrl.getPdfTextMark());
	}
	/**
	 * 添加图片水印
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfImageMark(Object kvs) throws Exception {
		return http(kvs, httpUrl.getPdfImageMark());
	}

	/**
	 * 添加二维码水印
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfQrCodeMark(Object kvs) throws Exception {
		return http(kvs, httpUrl.getPdfQrCodeMark());
	}

	/**
	 * 添加文本和二维码水印
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfTextAndQrCodeMark(Object kvs) throws Exception {
		return http(kvs, httpUrl.getPdfTextAndQrCodeMark());
	}




	/**
	 * http json请求
	 * @param obj
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private JSONObject http(Object obj, String url) throws Exception {
		log.info("【http param】 = [{}]" , JSON.toJSONString(obj));
		long start = System.currentTimeMillis();
		HttpTools.HttpData data = HttpTools.HttpData.instance().addHeader("Content-Type", "application/json")
				.setPostEntity(new StringEntity(JSON.toJSONString(obj), "utf-8"));
		HttpTools.ResponseEntity responseEntity = HttpTools.post(url, data);
		if (responseEntity == null || !responseEntity.isOk()) {
			throw new Exception("responseEntity=" + responseEntity);
		}
		JSONObject jsonObject = JSON.parseObject(responseEntity.getContent());
		if (log.isDebugEnabled()) {
			log.debug("调用[证书申请接口]结果：{}，耗时：{}", responseEntity.getContent(), System.currentTimeMillis() - start);
		}
		return jsonObject;
	}

	public InputStream downLoad(Long fssId) throws Exception {
		Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
		return downhttp(params, httpUrl.getFileDownload());
	}

	/**
	 * http  json请求 返回流
	 * @param obj
	 * @param url2
	 * @return
	 * @throws Exception
	 */
	private InputStream downhttp(Object obj, String url) throws Exception {
		URL urll = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.addRequestProperty("Content-Type", "application/json");
		connection.connect();//建立连接
		DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
		outputStream.writeBytes(JSON.toJSONString(obj));
		outputStream.flush();
		outputStream.close();
		return connection.getInputStream();
	}
	
	/**
	 * 用户注册
	 * @param cert
	 * @return
	 * @throws Exception
	 */
	public JSONObject userRegister(Object kvs) throws Exception {
		
		return http(kvs, httpUrl.getUserRegister());
	}
	
	/**
	 * 用户更新
	 * @param cert
	 * @return
	 * @throws Exception
	 */
	public JSONObject userUpdate(UserParams userParams) throws Exception {
		
		return http(userParams, httpUrl.getUserUpdate());
	}

	/**
	 * 用户详细信息查询
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject userSearchInfo(Object obj) throws Exception {
		
		return http(obj, httpUrl.getUserSearchInfo());
	}

	/**
	 * 用户更新/重置/忘记密码
	 * @param kvs
	 * @return
	 */
	public JSONObject resetPassWd(Object kvs) throws Exception {

		return http(kvs, httpUrl.getResetPassWd());
	}

	/**
	 * 创建企业
	 * @param kvs
	 * @return
	 */
	public JSONObject entAdd(Object obj) throws Exception {
		
		return http(obj, httpUrl.getEntAdd());
	}
	
	/**
	 * 更新企业
	 * @param kvs
	 * @return
	 */
	public JSONObject entUpdate(Object obj) throws Exception {
		
		return http(obj, httpUrl.getEntUpdate());
	}
	/**
	 * 更新企业基本信息
	 * @param kvs
	 * @return
	 */
	public JSONObject entUpdateBase(Object obj) throws Exception {
		return http(obj, httpUrl.getEntUpdateBase());
	}
	
	/**
	 * 删除企业
	 * @param kvs
	 * @return
	 */
	public JSONObject entDelete(Object obj) throws Exception {
		
		return http(obj, httpUrl.getEntDelete());
	}
	
	/**
	 * 企业详细信息查询
	 * @param kvs
	 * @return
	 */
	public JSONObject entSearchInfo(Object obj) throws Exception {
		
		return http(obj, httpUrl.getEntSearchInfo());
	}
	
	/**
	 * 创建部门
	 * @param kvs
	 * @return
	 */
	public JSONObject deptAdd(DeptParams deptParams) throws Exception {
		
		return http(deptParams, httpUrl.getDeptAdd());
	}
	
	/**
	 * 更新部门
	 * @param kvs
	 * @return
	 */
	public JSONObject deptUpdate(DeptParams deptParams) throws Exception {
		
		return http(deptParams, httpUrl.getDeptUpdate());
	}
	
	/**
	 * 查询部门详情信息
	 * @param kvs
	 * @return
	 */
	public JSONObject deptSearchInfo(DeptParams deptParams) throws Exception {
		
		return http(deptParams, httpUrl.getDeptSearchInfo());
	}
	
	/**
	 * 部门删除
	 * @param kvs
	 * @return
	 */
	public JSONObject deptDelete(DeptParams deptParams) throws Exception {
		
		return http(deptParams, httpUrl.getDeptDelete());
	}
	
	/**
	 * 查询企业下一级节点信息
	 * @param kvs
	 * @return
	 */
	public JSONObject entSearchOneNode(Object obj) throws Exception {
		
		return http(obj, httpUrl.getEntSearchOneNode());
	}
	
	/**
	 * 查询部门下一级节点信息
	 * @param kvs
	 * @return
	 */
	public JSONObject deptSearchOneNode(Object kvs) throws Exception {
		
		return http(kvs, httpUrl.getDeptSearchOneNode());
	}
	
	/**
	 * 查询企业下全部节点信息
	 * @param kvs
	 * @return
	 */
	public JSONObject entAll(UagOrgParams uagOrgParams) throws Exception {
		
		return http(uagOrgParams, httpUrl.getEntAll());
	}

	/**
	 * 查询部门下全部节点信息
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject deptAll(Object kvs) throws Exception {
		return http(kvs, httpUrl.getDeptAll());
	}
	
	/**
	 * 查询当前用户加入的企业列表
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject findJoinCompanys(EntListParams entListParams) throws Exception {
		return http(entListParams, httpUrl.getFindJoinCompanys());
	}
	
	/**
	 * 批量导入
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject betchImport(Object kvs) throws Exception {
		return http(kvs, httpUrl.getBetchImport());
	}
	
	/**
	 * 移除邀约用户
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject removeUser(Object kvs) throws Exception {
		return http(kvs, httpUrl.getRemoveUser());
	}
	
	/**
	 * 用户切换企业
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject switchEnterprise(SwicthParams swicthParams) throws Exception {
		return http(swicthParams, httpUrl.getSwitchEnterprise());
	}
	
	/**
	 * 企业邀请用户
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject joinEnterprise(Object kvs) throws Exception {
		return http(kvs, httpUrl.getJoinEnterprise());
	}
	/**
	 * 重新邀请企业用户
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject reJoinEnterprise(Object kvs) throws Exception {
		return http(kvs, httpUrl.getReJoinEnterprise());
	}
	
	/**
	 * 口令认证
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject passwdAuth(Object kvs) throws Exception {
		return http(kvs, httpUrl.getPasswdAuth());
	}
	
	/**
	 * 获取短信验证码
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject getVerificationCode(Object kvs) throws Exception {
		return http(kvs, httpUrl.getGetVerificationCode());
	}
	
	/**
	 * 验证短信验证码
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject verifySmsCodeAuth(Object kvs) throws Exception {
		return http(kvs, httpUrl.getVerifySmsCodeAuth());
	}
	
	/**
	 * 退出单点登录
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject logout(Object kvs) throws Exception {
		return http(kvs, httpUrl.getLogout());
	}
	
	/**
	 * 添加扩展属性
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject extendedAdd(Object kvs) throws Exception {
		return http(kvs, httpUrl.getExtendedAdd());
	}
	
	/**
	 * 查询当前节点下uuid集合
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject findChildUuidList(Object kvs) throws Exception {
		return http(kvs, httpUrl.getFindChildUuidList());
	}
	
	/**
	 * 用户授权接口
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject grantAuth(GrantAuthParams authParams) throws Exception {
		return http(authParams, httpUrl.getGrantAuth());
	}
	
	/**
	 *  根据手机号或uuid集合查询用户信息
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject findUserInfoByUuidList(UserListParams params) throws Exception {
		return http(params, httpUrl.getFindUserInfoByUuidList());
	}
	
	/**
	 *  全量查询企业和用户信息
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject findAllEnterpriseAndUser(Object kvs) throws Exception {
		return http(kvs, httpUrl.getFindAllEnterpriseAndUser());
	}

	/**
	 * 全量查询企业和用户信息
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject findSuperManagerForCompany(Object kvs) throws Exception {
		return http(kvs, httpUrl.getFindSuperManagerForCompany());
	}
	
	/**
	 * 加载企业树
	 * @param entLoadTreeParams
	 * @return
	 */
	public JSONObject entLoadTree(EntLoadTreeParams entLoadTreeParams) throws Exception {
		return http(entLoadTreeParams, httpUrl.getentLoadTree());
	}
	
	/**
	 * 实名用户接口
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject updateAuth(Object kvs) throws Exception {
		return http(kvs, httpUrl.getUpdateAuth());
	}
	
	/**
	 * 用户同意加入企业
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject joinToEnterprise(JoinToEntParams joinToEntParams) throws Exception {
		return http(joinToEntParams, httpUrl.getJoinToEnterprise());
	}
	
	/**
	 * 更新用户企业内信息
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject updateUserInfoInEnterprise(Object kvs) throws Exception {
		return http(kvs, httpUrl.getUpdateUserInfoInEnterprise());
	}
	
	
	/**
	 * 员工从指定企业离职接口
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject userDimission(Object kvs) throws Exception {
		return http(kvs, httpUrl.getUserDimission());
	}

	/**
	 * 删除注册用户（已经激活）
	 * @param userParams
	 * @return
	 * @throws Exception 
	 */
	public JSONObject userDelete(Object kvs) throws Exception {
		return http(kvs, httpUrl.userDelete());
	}
	
}
