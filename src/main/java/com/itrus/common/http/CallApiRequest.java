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
import com.itrus.common.params.AdminAuthParams;
import com.itrus.common.params.CreateUtsNodeParams;
import com.itrus.common.params.UagOrgParams;
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
	 * 企业注册
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject createAdmin(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCreateAdmin(), kvs , new ApiUser());
	}
	/**
	 * 新增节点
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	public JSONObject createUtsNode(CreateUtsNodeParams createUtsNodeParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCreateUtsNode(), createUtsNodeParams , new ApiUser());
	}
	
	/**
	 * 更新节点
	 * @param kvs
	 * @return
	 */
	public JSONObject updateUtsNode(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getUpdateUtsNode(), kvs , new ApiUser());
	}
	/**
	 * 升级用户为管理员
	 * @param kvs
	 * @return
	 */
	public JSONObject upgradeAdmin(AdminAuthParams adminAuthParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getUpgradeAdmin(), adminAuthParams , new ApiUser());
	}
	/**
	 * 取消管理员权限
	 * @param kvs
	 * @return
	 */
	public JSONObject cancelAdminAuth(AdminAuthParams adminAuthParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getCancelAdminAuth(), adminAuthParams , new ApiUser());
	}
	/**
	 * 删除节点
	 * @param kvs
	 * @return
	 */
	public JSONObject deleteUtsNode(AdminAuthParams adminAuthParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getDeleteUtsNode(), adminAuthParams , new ApiUser());
	}
	/**
	 * 重命名节点
	 * @param kvs
	 * @return
	 */
	public JSONObject renameUtsNode(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getRenameUtsNode(), kvs , new ApiUser());
	}
	/**
	 * 移动节点
	 * @param kvs
	 * @return
	 */
	public JSONObject movingUtsNode(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getMovingUtsNode(), kvs , new ApiUser());
	}
	/**
	 * 根据节点类型查找当前节点下所有节点数据
	 * @param kvs
	 * @return
	 */
	public JSONObject findAllSubLevelUser(UagOrgParams uagOrgParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getFindAllSubLevelUser(), uagOrgParams , new ApiUser());
	}
	/**
	 *  查询节点下所有一级节点
	 * @param kvs
	 * @return
	 */
	public JSONObject findAllOneLevelNode(UagOrgParams uagOrgParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getFindAllOneLevelNode(), uagOrgParams , new ApiUser());
	}
	/**
	 *  查询当前节点下所有下一级节点或加载权限树
	 * @param kvs
	 * @return
	 */
	public JSONObject findAllOneLevelChildren(UagOrgParams uagOrgParams) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getFindAllOneLevelChildren(), uagOrgParams , new ApiUser());
	}
	/**
	 *  重置用户密码
	 * @param kvs
	 * @return
	 */
	public JSONObject resetNodePassword(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getResetNodePassword(), kvs , new ApiUser());
	}
	/**
	 *  判断当前用户是否根节点下用户
	 * @param kvs
	 * @return
	 */
	public JSONObject verfyUserExistRootNode(Object kvs) throws Exception {
		return (JSONObject) getApiService().callApi(callApiUrlDTO.getVerfyUserExistRootNode(), kvs , new ApiUser());
	}
	/**
	 * 删除根节点
	 * @param object
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject deleteRootChild(Object kvs) throws Exception {
		return  (JSONObject) getApiService().callApi(callApiUrlDTO.getDeleteRootChild(), kvs , new ApiUser());
	}
}
