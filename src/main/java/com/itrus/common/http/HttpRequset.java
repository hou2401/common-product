package com.itrus.common.http;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpUrlDTO;
import com.itrus.common.exception.EnterpriseAuthException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.params.AuthEnterpriseParams;
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
	public JSONObject authPersionVideo(AuthPersionVideoParams persion) throws Exception {
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
	 * @param uploadQuery
	 * @param uploadImageUrl
	 * @return
	 * @throws Exception
	 */
	public JSONObject sign(Object kvs) throws Exception {
		return http(kvs, httpUrl.getDsvsSign());
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

}
