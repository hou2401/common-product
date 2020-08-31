package com.itrus.common.http;

import cn.com.itrus.atom.sign.common.bean.Result;
import com.itrus.common.request.dsvs.DsvsBatchSignRequest;
import com.itrus.common.request.dsvs.DsvsKeywordCoordinateRequest;
import com.itrus.common.request.dsvs.DsvsSignRequest;
import com.itrus.common.request.dsvs.DsvsVerifyBase64Request;
import com.itrus.common.response.dsvs.DsvsKeywordCoordinatesResult;
import com.itrus.common.response.dsvs.DsvsSignResult;
import com.itrus.common.response.dsvs.DsvsVerifyBase64Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 签章验章原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@FeignClient(value = "${http.dsvs}") //value:被调用的服务在注册中心的名称
public interface DsvsApiRequest {
	
	/**
	 * PDF签章
	 *
	 * @param obj 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dsvs/sign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<DsvsSignResult> sign(DsvsSignRequest obj);
	
	/**
	 * PDF批量签章
	 *
	 * @param obj 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dsvs/batchSign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<DsvsSignResult> batchSign(DsvsBatchSignRequest obj);
	
	/**
     * PDF验章
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/dsvs/verifyBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<DsvsVerifyBase64Result> verifyBase64(DsvsVerifyBase64Request obj);
	/**
	 * 获取关键字坐标
	 *
	 * @param obj 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dsvs/getKeywordCoordinates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<DsvsKeywordCoordinatesResult> getKeywordCoordinates(DsvsKeywordCoordinateRequest obj);
}
