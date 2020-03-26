package com.itrus.common.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.params.AuthPersionParams;
import com.itrus.common.params.CertParams;
import com.itrus.common.params.UploadParams;

import cn.com.itrus.atom.sign.api.fss.bean.DownloadResponse;
import cn.com.itrus.atom.sign.api.fss.bean.UploadResponse;
import cn.com.itrus.atom.sign.api.seal.bean.SealParam;
import cn.com.itrus.atom.sign.common.bean.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-2-25 12:04:04
 **/
@Slf4j
@Component
public class CommonRequest {

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
		if(object.get("code") == null || object.get("status") == null){
			return false;
		}
		return   object.getIntValue("code") == 0 || object.getIntValue("status") == 1 ;
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
		JSONObject result = null;
		if(httped()) {
			result = httpRequset.createEllipseSeal(kvs);
		}else {
			result = callApiRequest.createEllipseSeal(kvs);
		}
		return result;
	}

	/**
	 * 创建圆形印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createCircularSeal( SealParam  sealParam) throws Exception {
		JSONObject result = null;
		if(httped()) {
			result= httpRequset.createCircularSeal(sealParam);
		}else {
			result = callApiRequest.createCircularSeal(sealParam);
		}
		return result;
	}

	/**
	 * 创建双行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createDoubleRowSeal(SealParam  sealParam) throws Exception {
		JSONObject result = null;
		if(httped()) {
			throw new Exception("http 方法还未实现");
		}else {
			
			result = callApiRequest.createDoubleRowSeal(sealParam);
		}
		return result;
	}

	/**
	 * 创建单行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject createSingleRowSeal(SealParam sealParam) throws Exception {
		JSONObject result = null;
		if(httped()) {
			throw new Exception("http 方法还未实现");
		}else {
			result =callApiRequest.createSingleRowSeal(sealParam);
		}
		return result;
	}

	/**
	 * 印章透明处理
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject sealLimpid(Object kvs) throws Exception {
		JSONObject result = null;
		if(httped()) {
			throw new Exception("http 方法还未实现");
		}else {
			
			result = callApiRequest.sealLimpid(kvs);
		}
		return result;
	}
	//--------------------------------------------------------------------------------------------------------------------

	/**
	 * 文件存储服务
	 * @throws Exception 
	 */
	//--------------------------------------------------------------------------------------------------------------------
	/**
	 * 文件删除服务
	 * @param
	 * @return
	 * @throws Exception 
	 */
	public JSONObject fileDelete(Long fssId) throws Exception {
		JSONObject result = null;
		if(httped()) {
			return httpRequset.fileDelete(fssId);
		}else {
			result =callApiRequest.fileDelete(fssId);
		}
		return result;
	}
	/**
	 * 文件上传
	 * @param uploadQuery
	 * @return
	 * @throws Exception
	 */
	public Long upload(UploadParams uploadQuery) throws Exception {
		//log.info("upload is uploadQuery = {}",uploadQuery.toString());
		Long ffsId =  upload(uploadQuery.getBizType(), uploadQuery.getFileName(), uploadQuery.getFileBytes(), uploadQuery.getEncryptionType());
		log.info("upload is result ffsId={}",ffsId);
		return ffsId;
	}
	public Long upload(String bizType, String originalFileName, byte[] fileBytes , Integer encryptionType) throws Exception {
		if(httped()) {
			Map<String, Object> cearParam = new HashMap<>();
			cearParam.put("fileBytes", Base64Utils.encodeToString(fileBytes));
			cearParam.put("bizType", bizType);
			cearParam.put("fileName", originalFileName);
			cearParam.put("encryptionType", encryptionType);
			JSONObject uploadBase64 = httpRequset.uploadBase64(cearParam);
			String jsonData = uploadBase64.getString("data");
			JSONObject jsondata = JSON.parseObject(jsonData);
			String fssId = jsondata.getString("fssId");
			return Long.valueOf(fssId);
		}
		JSONObject jsonObject = callApiRequest.uploadBase64(fileBytes,bizType,originalFileName,encryptionType);
		if (jsonObject.getInteger("code") == 0) {
			return jsonObject.getJSONObject("data").getLong("fssId");
		} else {
			log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
			return null;
		}

	}

	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param file 文件
	 * @return 操作结果
	 * @throws Exception 
	 */
	public Result<UploadResponse> upload(String bizType, File file, Integer encryptionType) throws Exception {
		Result<UploadResponse> result = null;
		if(httped()) {
			throw new Exception("http 方法还未实现");
		}else {
			result = callApiRequest.upload(bizType, file, encryptionType);
		}
		return result;
	}

	/***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 * @throws Exception 
	 */
	public JSONObject downloadBase64(Long fssId) throws Exception {
		JSONObject result = null;
		if(httped()) {
			result =  httpRequset.downLoadBase64(fssId);
		}else {
			result = callApiRequest.downloadBase64(fssId);
		}
		return result;
	}
	
	
	/**
	 * 文件流下载接口
	/**
	 * http 下载文件 返回流
	 * @param fssId
	 * @return
	 * @throws Exception
	 */
	public  Result<DownloadResponse> download(Long fssId) throws Exception{
		
		 Result<DownloadResponse>  result = null;
		if( httped() ){
			DownloadResponse  downLoadResponse = new DownloadResponse();
			InputStream is =  httpRequset.downLoad(fssId);
			byte[] bytes = input2byte(is);
			downLoadResponse.setFileBytes( bytes );
			result = new  Result<DownloadResponse>();
			result.setCode(0L);
			result.setData(downLoadResponse);
		}else{
			result = callApiRequest.download(fssId);
		}
		return result;
	}
	
    public static final byte[] input2byte(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
	
	
	//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * 证书服务
	 */
	//-------------------------------------------------------------------------------------------------------------------------

	/**
	 * 申请证书
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject applyCert( CertParams cert ) throws Exception {
		JSONObject result = null;
		if(httped()) {
			result = httpRequset.applyCert(cert);
		}else {
			result = callApiRequest.applyCert(cert);
		}
		return result;

	}

	/**
	 * 更新证书
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	public JSONObject updateCert( Object kvs ) throws Exception {
		JSONObject result = null;
		if(httped()) {
			result =  httpRequset.updateCert(kvs);
		}else {
			result = callApiRequest.updateCert(kvs);
		}
		return result;

	}
	//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * 签章验章服务
	 */
	//-----------------------------------------------------------------------------------------------------------------------

	/**
	 * PDF签章
	 *
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject sign(Object kvs) throws Exception {
		JSONObject result = null;
		if(httped()) {
			result =  httpRequset.sign(kvs);
		}else {
			result = callApiRequest.sign(kvs);
		}
		return result;

	}

	/**
	 * PDF批量签章
	 *
	 * @param kvs
	 * @return
	 * @throws Exception
	 */
	public JSONObject batchSign(Object kvs) throws Exception {
		JSONObject result = null;
		if(httped()) {
			throw new Exception("http 方法还未实现");
		}else {
			result = callApiRequest.batchSign(kvs);
		}
		return result;
	}

	/**
	 * 实名服务，手机号3要素
	 * @param doctorQuery
	 * @return
	 * @throws Exception 
	 */
	public JSONObject auth3(AuthPersionParams authPersionParams) throws Exception {
		return  httpRequset.authPersion(authPersionParams);
	}

}
