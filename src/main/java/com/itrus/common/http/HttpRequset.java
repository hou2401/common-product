package com.itrus.common.http;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpUrlDTO;
import com.itrus.common.exception.PersionException;
import com.itrus.common.params.AuthPersionParams;
import com.itrus.common.utils.HttpTools;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HttpRequset {

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
     * 实名认证
     * @param doctorQuery
     * @return
     * @throws Exception
     */
    public JSONObject auth(AuthPersionParams persion) throws Exception {
    	long start = 0L;
    	if (log.isDebugEnabled()) {
        	start = System.currentTimeMillis();
    	}
        HttpTools.ResponseEntity responseEntity = 
        		HttpTools.post(	 persion.getUrl(), persion.getData() );
        if (responseEntity.isOk()) {
        	if (log.isDebugEnabled()) {
        		log.debug("调用[实名认证接口]结果：{}，耗时：{}", responseEntity.getContent(), System.currentTimeMillis() - start);
        	}
        	return JSON.parseObject(responseEntity.getContent());
		} else {
			// TODO：Http调用失败处理
			log.error(responseEntity.getMessage());
			throw new PersionException(responseEntity.getMessage());
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
	private InputStream downhttp(Object obj, String url2) throws Exception {
		URL url = new URL(url2);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
