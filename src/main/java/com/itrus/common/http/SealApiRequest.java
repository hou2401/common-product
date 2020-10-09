package com.itrus.common.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itrus.common.request.atom.*;

import cn.com.itrus.atom.sign.common.bean.Result;

/**
 * 印章服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@FeignClient(value = "${http.seal}") //value:被调用的服务在注册中心的名称
public interface SealApiRequest {
	
	/**
	 * 创建椭圆印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	
	//value:被调用的服务接口路径
	@RequestMapping(value = "/seal/front/createEllipseSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Result<String> createEllipseSeal(CreateCircularSealRequest obj);

	/**
	 * 创建圆形印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	//value:被调用的服务接口路径
	@RequestMapping(value = "/seal/front/createCircularSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Result<String> createCircularSeal(CreateCircularSealRequest obj);
	
	/**
	 * 创建三角章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/createTriangleSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> createTriangleSeal(CreateCircularSealRequest obj);

	/**
	 * 创建双行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	//value:被调用的服务接口路径
	@RequestMapping(value = "/seal/front/createDoubleRowSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Result<String> createDoubleRowSeal(CreateDoubleRowSealRequest obj);

	/**
	 * 创建单行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/createSingleRowSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Result<String> createSingleRowSeal(CreateSingleRowSealRequest obj);

	/**
	 * 印章透明处理
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/sealLimpid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> sealLimpid(SealLimpidRequest obj);
	
}
