package com.itrus.common.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;
import cn.com.itrus.atom.sign.common.bean.Result;

/**
 * 签章验章原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@Component
@FeignClient(value = "${http.dsvs}") //value:被调用的服务在注册中心的名称
public interface DsvsApiRequest {
	
	/**
	 * PDF签章
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dsvs/sign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> sign(Object obj);
	
	/**
	 * PDF批量签章
	 *
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dsvs/batchSign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> batchSign(Object obj);
	
	/**
     * PDF验章
     *
     * @param kvs 不能是map对象
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/dsvs/verifyBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> verifyBase64(Object obj);

}
