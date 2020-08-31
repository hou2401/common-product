package com.itrus.common.http;

import com.itrus.common.request.cert.CertUpdateRequest;
import com.itrus.common.response.cert.ApplyCertResult;
import com.itrus.common.response.cert.CertUpdateResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.com.itrus.atom.sign.common.bean.Result;
/**
 * 证书原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@FeignClient(value = "${http.cs}") //value:被调用的服务在注册中心的名称
public interface CertApiRequest {
	
	/**
	 * 申请证书
	 *
	 * @param kvs 不能是map对象
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/cert/apply", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<ApplyCertResult> applyCert(Object obj);

	/**
	 * 更新证书
	 *
	 * @param kvs 不能是map对象
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/cert/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<CertUpdateResult> updateCert(CertUpdateRequest obj);

}
