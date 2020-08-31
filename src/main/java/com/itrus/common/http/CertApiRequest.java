package com.itrus.common.http;

import com.itrus.common.request.cert.CertUpdateRequest;
import com.itrus.common.request.ra.CertConfigRequest;
import com.itrus.common.request.ra.TimeStampRequest;
import com.itrus.common.response.cert.ApplyCertResult;
import com.itrus.common.response.cert.CertUpdateResult;
import com.itrus.common.response.ra.CertConfigResponse;
import com.itrus.common.response.ra.RaResult;
import com.itrus.common.response.ra.TimeStampResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.com.itrus.atom.sign.common.bean.Result;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

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

	/**
	 * 新建RA证书配置
	 *
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/web/ra/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<String> RaAdd(CertConfigRequest obj);

	/**
	 * 查询RA证书配置
	 *
	 * @param raCode
	 * @return
	 */
	@RequestMapping(value = "/web/ra/getByRaCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<CertConfigResponse> GetByRaCode(@RequestPart("raCode") String raCode);


	/**
	 * 更新RA证书配置
	 *
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/web/ra/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<String> RaUpdate(CertConfigRequest obj);


	/**
	 * 根据唯一标识删除区块链服务配置
	 *
	 * @param raCode
	 * @return
	 */
	@RequestMapping(value = "/web/ra/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<String> RaDelete(@RequestPart("raCode") String raCode);

	/**
	 * 查询区块链服务配置列表
	 *
	 * @param enterpriseId 必选 企业唯一标识
	 * @param productId    可选 产品唯一标识
	 * @return
	 */
	@RequestMapping(value = "/web/ra/getList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<List<CertConfigResponse>> RaGetList(@RequestPart("enterpriseId") String enterpriseId, @RequestPart("productId") String productId);


	/**
	 * 新增时间戳配置
	 *
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/web/tsa/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<String> tsaAdd(TimeStampRequest obj);

	/**
	 * 根据企业唯一标识查询时间戳配置详情，只返回最后一次添加的一条
	 *
	 * @param enterpriseId 必填 企业唯一标识
	 * @param productId    可选 产品唯一标识
	 * @return
	 */
	@RequestMapping(value = "/web/tsa/getTsaConfig", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<TimeStampResponse> tsaGetTsaConfig(@RequestPart("enterpriseId") String enterpriseId, @RequestPart("productId") String productId);

	/**
	 * 根据tsaCode查询时间戳配置是否已存在
	 *
	 * @param tsaCode 必选 时间戳代码
	 * @return
	 */

	@RequestMapping(value = "/web/tsa/getByTsaCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<TimeStampResponse> tsaGetByTsaCode(@RequestPart("tsaCode") String tsaCode);

	/**
	 * 根据tsaCode更新时间戳配置
	 *
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/web/tsa/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<String> tsaUpdate(TimeStampRequest obj);

	/**
	 * 根据tsaCode删除时间戳服务配置
	 *
	 * @param tsaCode 必填 时间戳代码
	 * @return
	 */
	@RequestMapping(value = "/web/tsa/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	RaResult<String> tsaDelete(@RequestPart("tsaCode") String tsaCode);

}
