package com.itrus.common.http;

import com.itrus.common.response.atom.FssDownloadBase64Result;
import com.itrus.common.response.atom.FssUploadBase64Result;
import com.itrus.common.response.atom.FssUploadResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import cn.com.itrus.atom.sign.common.bean.Result;

import java.util.Map;

/**
 * 整合版公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@FeignClient(value = "${http.fss}") //value:被调用的服务在注册中心的名称
public interface FssApiRequest {
	

	@RequestMapping(value = "/fss/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> fileDelete(Object obj);
	
	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param originalFileName 原文件名称，必须带扩展名
	 * @param
	 * @return 操作结果
	 * @throws Exception 
	 */
	@RequestMapping(value = "/fss/uploadBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<FssUploadBase64Result> uploadBase64(Object obj);

	/***
	 * 上传文件
	 * @param file 文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * | encryptionType | Integer | 可选 | 加密类型：<br />1. 不加密（默认） 
	 * @return 操作结果
	 */
	@RequestMapping(value = "/fss/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<FssUploadResult> upload(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "bizType")String bizType,
										  @RequestPart(value = "encryptionType")Integer encryptionType);

	/***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 * @throws Exception 
	 */
	@RequestMapping(value = "/fss/downloadBase64", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<FssDownloadBase64Result> downLoadBase64(Object obj);

	/***
	 * 下载文件
	 * @param obj 文件存储标识
	 * @return 文件内容
	 * @throws Exception
	 */
	@RequestMapping(value = "/fss/download", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity download(Object obj);


    /***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 */
	/*public Result<DownloadResponse> download(Long fssId) {
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
	}*/

}
