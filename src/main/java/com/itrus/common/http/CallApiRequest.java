package com.itrus.common.http;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.itrus.api.common.ApiResponseHandler;
import com.itrus.api.common.ApiService;
import com.itrus.api.common.ApiUser;
import com.itrus.common.config.TWConfig;
import com.itrus.common.dto.CallApiUrlDTO;
import com.itrus.common.params.sign.PdfVerify;
import com.itrus.common.params.uag.DeptParams;
import com.itrus.common.params.uag.EntListParams;
import com.itrus.common.params.uag.EntLoadTreeParams;
import com.itrus.common.params.uag.GrantAuthParams;
import com.itrus.common.params.uag.JoinToEntParams;
import com.itrus.common.params.uag.SwicthParams;
import com.itrus.common.params.uag.UagOrgParams;
import com.itrus.common.params.uag.UserListParams;
import com.itrus.common.params.uag.UserParams;
import com.itrus.common.utils.BeanUtil;

import cn.com.itrus.atom.sign.api.constants.FSSConstants;
import cn.com.itrus.atom.sign.api.fss.bean.DownloadResponse;
import cn.com.itrus.atom.sign.api.fss.bean.UploadResponse;
import cn.com.itrus.atom.sign.common.bean.Result;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-2-25 12:04:04
 **/
@Slf4j
@Component
public class CallApiRequest {
	
	@Autowired
	private CallApiUrlDTO callApiUrlDTO;

	@Autowired
	private  WebApplicationContext webApplicationConnect;
	
	private HttpServletRequest getRequest() {
		return new MockHttpServletRequest(webApplicationConnect.getServletContext());
	}
	/**
	 * getApiService()
	 * @return
	 */
	public ApiService getApiService() {
		// apphome 中获取
		ApiService apiService  =  (ApiService) getRequest().getServletContext().getAttribute("__apiservice__");
		if( apiService == null ) {
			// apiservice 中获取
			apiService = TWConfig.getApiServiceServlet().new ApiServiceImpl();
		}
		return apiService;
	}

	/**
	 * 
	 * 印章服务
	 * 
	 */
	//--------------------------------------------------------------------------------------------------------------------
	/**
	 * 创建椭圆印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createEllipseSeal(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCreateEllipseSeal(), BeanUtil.toMap(kvs), new ApiUser());
	}

	/**
	 * 创建圆形印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createCircularSeal(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCreateCircularSeal(), BeanUtil.toMap(kvs), new ApiUser());
	}

	/**
	 * 创建双行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createDoubleRowSeal(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCreateDoubleRowSeal(), BeanUtil.toMap(kvs), new ApiUser());
	}

	/**
	 * 创建单行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createSingleRowSeal(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCreateSingleRowSeal(), BeanUtil.toMap(kvs), new ApiUser());
	}

	/**
	 * 印章透明处理
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject sealLimpid(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getSealLimpid(), BeanUtil.toMap(kvs), new ApiUser());
	}
	//--------------------------------------------------------------------------------------------------------------------

	/**
	 * 文件存储服务
	 * @throws Exception 
	 */
	//--------------------------------------------------------------------------------------------------------------------

	public JSONObject fileDelete(Long fssId) throws Exception {
		Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getFileDelete(), params, new ApiUser());
	}

	/***
	 * 上传文件
	 * @param file 文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * | encryptionType | Integer | 可选 | 加密类型：<br />1. 不加密（默认） 
	 * @return 操作结果
	 */
	public Result<UploadResponse> upload(String bizType, File file, Integer encryptionType) {
		okhttp3.RequestBody fileBody = okhttp3.RequestBody.create(MediaType.parse("application/octet-stream"), file);
		return upload(bizType, file.getName(), fileBody, encryptionType);
	}

	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param originalFileName 原文件名称，必须带扩展名
	 * @param fileBytes 文件内容
	 * @return 操作结果
	 */
	public Result<UploadResponse> upload(String bizType, String originalFileName, byte[] fileBytes, Integer encryptionType) {
		okhttp3.RequestBody fileBody = okhttp3.RequestBody.create(MediaType.parse("application/octet-stream"), fileBytes);
		if(originalFileName == null) {
			originalFileName = "anonymous.file";
		}
		return upload(bizType, originalFileName, fileBody,encryptionType);
	}

	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param originalFileName 原文件名称，必须带扩展名
	 * @param fileBytes 文件内容
	 * @return 操作结果
	 */
	public Result<UploadResponse> upload(byte[] fileBytes,String bizType, String originalFileName, Integer encryptionType) {
		okhttp3.RequestBody fileBody = okhttp3.RequestBody.create(MediaType.parse("application/octet-stream"), fileBytes);
		if(originalFileName == null) {
			originalFileName = "anonymous.file";
		}
		return upload(bizType, originalFileName, fileBody,encryptionType);
	}


	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param originalFileName 原文件名称，必须带扩展名
	 * @param
	 * @return 操作结果
	 * @throws Exception 
	 */
	public JSONObject uploadBase64(byte[] fileBytes,String bizType, String originalFileName, Integer encryptionType) throws Exception {
		Map<String, Object> cearParam = new HashMap<>();
		cearParam.put("fileBytes", Base64Utils.encodeToString(fileBytes));
		cearParam.put("bizType", bizType);
		cearParam.put("fileName", originalFileName);
		cearParam.put("encryptionType", encryptionType);
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getFileUploadBase64(), cearParam, new ApiUser());
	}


	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param originalFileName 原文件名称，必须带扩展名
	 * @param fileBody 文件体
	 * @return 操作结果
	 */
	public Result<UploadResponse> upload(String bizType, String originalFileName, okhttp3.RequestBody fileBody, Integer encryptionType) {
		okhttp3.MultipartBody body = new okhttp3.MultipartBody.Builder()
				.setType(okhttp3.MultipartBody.FORM)
				.addFormDataPart("bizType", bizType == null ? "" : bizType)
				.addFormDataPart("file", originalFileName, fileBody)
				.addFormDataPart("encryptionType", encryptionType == null ? "" : String.valueOf(encryptionType) )
				.build();
		Request request = new Request.Builder().post(body).url("http://a.b.c").build();
		Result<UploadResponse> result;
		try {
			result = (Result<UploadResponse>) getApiService().callApi(callApiUrlDTO.getFileUpload(), request, new ApiUser(),
					new ApiResponseHandler<Result<UploadResponse>>() {
				@Override
				public Result<UploadResponse> handleResponse(Response response) {
					if (response.code() == 200) {
						try {
							return JSON.parseObject(response.body().string(),
									new TypeReference<Result<UploadResponse>>() {});
						} catch (IOException e) {
							log.error("upload error", e);
							return Result.createFailResult("upload error: " + e.getMessage());
						}
					}
					throw new RuntimeException(response.body().toString());
				}
			});
		} catch (Exception e) {
			log.error("upload error", e);
			return Result.createFailResult("upload error: " + e.getMessage());
		}
		return result;
	}



	/***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 */
	public Result<DownloadResponse> download(Long fssId) {
		Map<String, Long> request = new Hashtable<>();
		request.put("fssId", fssId);
		Result<DownloadResponse> result;
		try {
			result = getApiService().callApi(callApiUrlDTO.getFileDownload(), request, new ApiUser(),
					new ApiResponseHandler<Result<DownloadResponse>>() {
				@Override
				public Result<DownloadResponse> handleResponse(Response response) {
					try {
						String downloadSuccess = response.header(FSSConstants.HEADER_DOWNLOAD_SUCCESS);
						if("true".equals(downloadSuccess)) {
							String filename = response.header("Content-Disposition");
							if (filename.startsWith("attachment;filename=")) {
								filename = filename.replace("attachment;filename=", "");
							}
							DownloadResponse downloaRresponse = new DownloadResponse();
							downloaRresponse.setFileBytes(response.body().bytes());
							downloaRresponse.setFileName(filename);
							return Result.createSuccessResult(downloaRresponse);
						} else {
							return JSON.parseObject(response.body().string(), new TypeReference<Result<DownloadResponse>>() {});
						}
					} catch (Exception e) {
						log.error("download error", e);
						return Result.createFailResult("下载失败: " + e.getMessage());
					}
				}
			});
			return result;
		} catch (Exception e) {
			log.error("download error", e);
			return Result.createFailResult("download error: " + e.getMessage());
		}
	}
	
	/***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 * @throws Exception 
	 */
	public JSONObject downloadBase64(Long fssId) throws Exception {
		Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getFileDownloadBase64(), params, new ApiUser());
	}


	/***
	 * word文档转换pdf（支持doc/docx）
	 * @param data 文件byte数组
	 * @return 转换后的PDF文件的base64编码
	 * @throws Exception
	 */
	public JSONObject word2Pdfs(byte[] data) throws Exception {
		Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getWord2Pdfs(), params, new ApiUser());
	}
	/***
	 * excel表格转换pdf（支持xls/xlsx）
	 * @param data 文件byte数组
	 * @return 转换后的PDF文件的base64编码
	 * @throws Exception
	 */
	public JSONObject excel2Pdfs(byte[] data) throws Exception {
		Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getExcel2Pdfs(), params, new ApiUser());
	}
	/***
	 * 图片转换pdf（支持jpg/jpeg/png）
	 * @param data 文件byte数组
	 * @return 转换后的PDF文件的base64编码
	 * @throws Exception
	 */
	public JSONObject image2Pdfs(byte[] data) throws Exception {
		Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getImagePdfs(), params, new ApiUser());
	}



	/***
	 * 下载文件
	 * @param data 文件存储标识
	 * @return 文件内容
	 * @throws Exception
	 */
	public JSONObject pdf2png(byte[] data) throws Exception {
		Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getPdf2png(), params, new ApiUser());
	}


	//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * 证书服务
	 */
	//-------------------------------------------------------------------------------------------------------------------------

	/**
	 * 申请证书
	 *
	 * @param kvs 不能是map对象
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject applyCert(Object kvs ) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCertApply(), BeanUtil.toMap(kvs), new ApiUser());
	}

	/**
	 * 更新证书
	 *
	 * @param kvs 不能是map对象
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject updateCert( Object kvs ) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCertUpdate(), BeanUtil.toMap(kvs), new ApiUser());
	}

    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 文档生成服务
     */
    //-----------------------------------------------------------------------------------------------------------------------

    public JSONObject pdfFill(Map kvs) throws  Exception{
        return (JSONObject) getApiService().callApi(callApiUrlDTO.getPdfFill(),kvs, new ApiUser());
    }


	//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * 签章验章服务
	 */
	//-----------------------------------------------------------------------------------------------------------------------

	/**
	 * PDF签章
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject sign(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDsvsSign(), BeanUtil.toMap(kvs), new ApiUser());
	}

    /**
     * PDF签章
     *
     * @param kvs 不能是map对象
     * @return
     * @throws Exception
     */
    public JSONObject signMap(Map kvs) throws Exception {
        return (JSONObject) getApiService().callApi(callApiUrlDTO.getDsvsSign(), kvs, new ApiUser());
    }

	/**
	 * PDF批量签章
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject batchSign(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDsvsBatchSign(), BeanUtil.toMap(kvs) , new ApiUser());
	}

	/**
	 * 添加文字水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfTextMark(Object kvs) throws Exception{

		return (JSONObject) getApiService().callApi(callApiUrlDTO.getPdfTextMark(), BeanUtil.toMap(kvs), new ApiUser());
	}
	/**
	 * 添加图片水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfImageMark(Object kvs) throws Exception{

		return (JSONObject) getApiService().callApi(callApiUrlDTO.getPdfImageMark(), BeanUtil.toMap(kvs), new ApiUser());
	}
	/**
	 * 添加二维码水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfQrCodeMark(Object kvs) throws Exception{

		return (JSONObject) getApiService().callApi(callApiUrlDTO.getPdfQrCodeMark(), BeanUtil.toMap(kvs), new ApiUser());
	}
	/**
	 * 添加文字和二维码水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject pdfTextAndQrCodeMark(Object kvs) throws Exception{

		return (JSONObject) getApiService().callApi(callApiUrlDTO.getPdfTextAndQrCodeMark(), BeanUtil.toMap(kvs), new ApiUser());
	}




	
	/**
	 * UAG组织架构服务
	 */
	//-------------------------------------------------------------------------------------------------------------------------

	/**
	 * 用户注册
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject userRegister(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getUserRegister(), kvs , new ApiUser());
	}
	/**
	 * 用户更新
	 *
	 * @param userParams 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject userUpdate(UserParams userParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getUserUpdate(), userParams , new ApiUser());
	}
	/**
	 * 用户详细信息查询
	 *
	 * @param obj 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject userSearchInfo(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getUserSearchInfo(), obj , new ApiUser());
	}
	
	/**
	 * 用户更新/重置/忘记密码
	 * @param kvs
	 * @return
	 */
	public JSONObject resetPassWd(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getResetPassWd(), kvs , new ApiUser());
	}
	/**
	 * 创建企业
	 * @param obj
	 * @return
	 */
	public JSONObject entAdd(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntAdd(), obj , new ApiUser());
	}
	/**
	 * 更新企业
	 * @param obj
	 * @return
	 */
	public JSONObject entUpdate(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntUpdate(), obj , new ApiUser());
	}
	/**
	 * 更新企业基本信息
	 * @param obj
	 * @return
	 */
	public JSONObject entUpdateBase(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntUpdateBase(), obj , new ApiUser());
	}
	/**
	 * 删除企业
	 * @param obj
	 * @return
	 */
	public JSONObject entDelete(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntDelete(), obj , new ApiUser());
	}
	/**
	 * 企业详细信息查询
	 * @param obj
	 * @return
	 */
	public JSONObject entSearchInfo(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntSearchInfo(), obj , new ApiUser());
	}
	/**
	 * 创建部门
	 * @param deptParams
	 * @return
	 */
	public JSONObject deptAdd(DeptParams deptParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDeptAdd(), deptParams , new ApiUser());
	}
	/**
	 * 更新部门
	 * @param deptParams
	 * @return
	 */
	public JSONObject deptUpdate(DeptParams deptParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDeptUpdate(), deptParams , new ApiUser());
	}
	/**
	 * 查询部门详情信息
	 * @param deptParams
	 * @return
	 */
	public JSONObject deptSearchInfo(DeptParams deptParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDeptSearchInfo(), deptParams , new ApiUser());
	}
	/**
	 *  部门删除
	 * @param deptParams
	 * @return
	 */
	public JSONObject deptDelete(DeptParams deptParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDeptDelete(), deptParams , new ApiUser());
	}
	/**
	 *  查询企业下一级节点信息
	 * @param obj
	 * @return
	 */
	public JSONObject entSearchOneNode(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntSearchOneNode(), obj , new ApiUser());
	}
	/**
	 *  查询部门下一级节点信息
	 * @param kvs
	 * @return
	 */
	public JSONObject deptSearchOneNode(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDeptSearchOneNode(), kvs , new ApiUser());
	}
	/**
	 *  查询企业下全部节点信息
	 * @param uagOrgParams
	 * @return
	 */
	public JSONObject entAll(UagOrgParams uagOrgParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getEntAll(), uagOrgParams , new ApiUser());
	}
	/**
	 * 查询部门下全部节点信息
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject deptAll(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getDeptAll(), kvs , new ApiUser());
	}
	/**
	 * 查询当前用户加入的企业列表
	 * @param entListParams
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject findJoinCompanys(EntListParams entListParams) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getFindJoinCompanys(), entListParams , new ApiUser());
	}
	/**
	 * 查询当前用户加入的企业列表
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject betchImport(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getBetchImport(), kvs , new ApiUser());
	}
	/**
	 * 移除邀约用户
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject removeUser(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getRemoveUser(), kvs , new ApiUser());
	}
	/**
	 * 用户切换企业
	 * @param swicthParams
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject switchEnterprise(SwicthParams swicthParams) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getSwitchEnterprise(), swicthParams , new ApiUser());
	}
	/**
	 * 企业邀请用户
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject joinEnterprise(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getJoinEnterprise(), kvs , new ApiUser());
	}

	/**
	 * 重新邀请企业用户
	 * @param kvs
	 * @return
	 * @throws Exception
	 * @throws
	 */
	public JSONObject reJoinEnterprise(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getReJoinEnterprise(), kvs , new ApiUser());
	}
	/**
	 * 口令认证
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject passwdAuth(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getPasswdAuth(), kvs , new ApiUser());
	}
	/**
	 * 获取短信验证码
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject getVerificationCode(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getGetVerificationCode(), kvs , new ApiUser());
	}
	/**
	 * 验证短信验证码
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject verifySmsCodeAuth(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getVerifySmsCodeAuth(), kvs , new ApiUser());
	}
	/**
	 * 退出单点登录
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject logout(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getLogout(), kvs , new ApiUser());
	}
	/**
	 * 添加扩展属性
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject extendedAdd(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getExtendedAdd(), kvs , new ApiUser());
	}
	/**
	 * 查询当前节点下uuid集合
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject findChildUuidList(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getFindChildUuidList(), kvs , new ApiUser());
	}
	/**
	 * 用户授权接口
	 * @param authParams
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject grantAuth(GrantAuthParams authParams) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getGrantAuth(), authParams , new ApiUser());
	}
	/**
	 * 根据手机号或uuid集合查询用户信息
	 * @param params
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject findUserInfoByUuidList(UserListParams params) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getFindUserInfoByUuidList(), params , new ApiUser());
	}
	/**
	 *全量查询企业和用户信息
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject findAllEnterpriseAndUser(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getFindAllEnterpriseAndUser(), kvs , new ApiUser());
	}
	
	/**
	 *获取企业下超管列表
	 * @param kvs
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject findSuperManagerForCompany(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getFindSuperManagerForCompany(), kvs , new ApiUser());
	}

	/**
	 * 加载企业树
	 * @param entLoadTreeParams
	 * @return
	 */
	public JSONObject entLoadTree(EntLoadTreeParams entLoadTreeParams)throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getentLoadTree(), entLoadTreeParams , new ApiUser());

	}
	
	/**
	 * 实名用户接口
	 * @param obj
	 * @return
	 */
	public JSONObject updateAuth(Object obj)throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getUpdateAuth(), obj , new ApiUser());
		
	}
	
	/**
	 * 用户同意加入企业
	 * @param joinToEntParams
	 * @return
	 */
	public JSONObject joinToEnterprise(JoinToEntParams joinToEntParams)throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getJoinToEnterprise(), joinToEntParams , new ApiUser());
		
	}
	
	/**
	 * 更新用户企业内信息
	 * @param obj
	 * @return
	 */
	public JSONObject updateUserInfoInEnterprise(Object obj)throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getUpdateUserInfoInEnterprise(), obj , new ApiUser());
		
	}
	
	/**
	 * 员工从指定企业离职接口
	 * @param obj
	 * @return
	 */
	public JSONObject userDimission(Object obj)throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getUserDimission(), obj , new ApiUser());
		
	}
	/**
	 * 删除用户注册接口
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public JSONObject userDelete(Object obj) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getUserDelete(), obj, new ApiUser());
	}
	/**
	 * PDF批量签章
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject verifyBase64(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDsvsVerifyBase64(), BeanUtil.toMap(kvs) , new ApiUser());
	}
}
