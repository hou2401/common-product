package com.itrus.common.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;
import cn.com.itrus.atom.sign.common.bean.Result;

/**
 * 文档生成服务原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@Component
@FeignClient(value = "${http.dgs}") //value:被调用的服务在注册中心的名称
public interface DgsApiRequest {

	/**
	 * PDF模板填充
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/dgs/pdfFill", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> pdfFill(Object obj);
	
	/**
	 * PDF模板创建
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/dgs/pdfCreate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> pdfCreate(Object obj);
	
	/**
	 * 添加文字水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dgs/pdfTextMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> pdfTextMark(Object obj);
	
	/**
	 * 添加图片水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dgs/pdfImageMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> pdfImageMark(Object obj);
	
	/**
	 * 添加二维码水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dgs/pdfQrCodeMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> pdfQrCodeMark(Object obj);


	/**
	 * 添加文字和二维码水印
	 * @param kvs 不能是map对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dgs/pdfTextAndQrCodeMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> pdfTextAndQrCodeMark(Object obj);
	
}
