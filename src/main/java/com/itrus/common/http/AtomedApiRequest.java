package com.itrus.common.http;

import cn.com.itrus.atom.sign.common.bean.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 整合版公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@Component
@FeignClient(value = "${http.atomed}") //value:被调用的服务在注册中心的名称
public interface AtomedApiRequest {
	
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
	
	//value:被调用的服务接口路径
	@RequestMapping(value = "/seal/front/createEllipseSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> createEllipseSeal(Object obj);

	/**
	 * 创建圆形印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/createCircularSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> createCircularSeal(Object obj);
	
	/**
	 * 创建三角章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/createTriangleSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> createTriangleSeal(Object obj);

	/**
	 * 创建双行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/createDoubleRowSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> createDoubleRowSeal(Object obj);

	/**
	 * 创建单行人名印章
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/createSingleRowSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> createSingleRowSeal(Object obj);

	/**
	 * 印章透明处理
	 *
	 * @param kvs 请求参数
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/seal/front/sealLimpid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> sealLimpid(Object obj);
	//--------------------------------------------------------------------------------------------------------------------

	/**
	 * 文件存储服务
	 * @throws Exception 
	 */
	//--------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/fss/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> fileDelete(Object obj);
	
	/***
	 * 上传文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * @param originalFileName 原文件名称，必须带扩展名
	 * @param
	 * @return 操作结果
	 * @throws Exception 
	 */
	@RequestMapping(value = "/fss/uploadBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> uploadBase64(Object obj);

	/***
	 * 上传文件
	 * @param file 文件
	 * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
	 * | encryptionType | Integer | 可选 | 加密类型：<br />1. 不加密（默认） 
	 * @return 操作结果
	 */
	@RequestMapping(value = "/fss/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<JSONObject> upload(@RequestPart(value = "file") MultipartFile file,@RequestPart(value = "bizType")String bizType,
			@RequestPart(value = "encryptionType")Integer encryptionType);
	
	/***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 * @throws Exception 
	 */
	@RequestMapping(value = "/fss/downloadBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> downLoadBase64(Object obj);

	/***
	 * 下载文件
	 * @param fssId 文件存储标识
	 * @return 文件内容
	 * @throws Exception 
	 */
	@RequestMapping(value = "/fss/download", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity download(Object obj);

	//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * 证书服务
	 */
	//-------------------------------------------------------------------------------------------------------------------------

	/**
	 * 申请证书
	 *
	 * @param kvs 不能是map对象
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/cert/apply", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> applyCert(Object obj);

	/**
	 * 更新证书
	 *
	 * @param kvs 不能是map对象
	 * @return 返回创建结果
	 * @throws Exception 抛出异常
	 */
	@RequestMapping(value = "/cert/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<JSONObject> updateCert(Object obj);
	
	//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * 签章验章服务
	 */
	//-----------------------------------------------------------------------------------------------------------------------

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

    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 文档生成服务
     */
    //-----------------------------------------------------------------------------------------------------------------------

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
	@RequestMapping(value = "/dgs/pdfCreate", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<JSONObject> pdfCreate(@RequestPart(value = "file") MultipartFile file,@RequestPart(value = "styleType")Integer styleType,
			@RequestPart(value = "pageSize")Integer pageSize);


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
