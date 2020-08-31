package com.itrus.common.http;

import com.itrus.common.response.fcs.GetTotalPagesResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import cn.com.itrus.atom.sign.common.bean.Result;

/**
 * 整合版公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@FeignClient(value = "${http.fcs}") //value:被调用的服务在注册中心的名称
public interface FcsApiRequest {
	
	/***
	 * word文档转换pdf（支持doc/docx）
	 * @param data 文件byte数组
	 * @return 转换后的PDF文件的base64编码
	 * @throws Exception    
	 */
	@RequestMapping(value = "fcs/front/word2pdf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> word2Pdfs(Object obj);
	
	/***
	 * pdf转png
	 * @param data 文件存储标识
	 * @return 文件内容
	 * @throws Exception
	 */
	@RequestMapping(value = "/fcs/front/pdf2png", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> pdf2png(Object obj);

	/***
	 * excel表格转换pdf（支持xls/xlsx）
	 * @param data 文件byte数组
	 * @return 转换后的PDF文件的base64编码
	 * @throws Exception
	 */
	@RequestMapping(value = "/fcs/front/excel2pdf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> excel2Pdfs(Object obj);
	
	/***
	 * 图片转换pdf（支持jpg/jpeg/png）
	 * @param data 文件byte数组
	 * @return 转换后的PDF文件的base64编码
	 * @throws Exception  
	 */
	@RequestMapping(value = "/fcs/front/image2pdf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> image2Pdfs(Object obj);

	/***
	 * 生成缩略图
	 * @param file 文件
	 * @return 操作结果
	 */
	@RequestMapping(value = "/fcs/front/generateThumbnail", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<String> generateThumbnail(@RequestPart(value = "file") MultipartFile file,@RequestPart(value = "pages")String pages,
			@RequestPart(value = "scale")Float scale, @RequestPart(value = "dpi")Float dpi);
	
	/***
	 * 获取文件总页数
	 * @param file 文件
	 * @return 操作结果
	 */
	@RequestMapping(value = "/fcs/front/getTotalPages", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<GetTotalPagesResult> getTotalPages(@RequestPart(value = "file") MultipartFile file);

}
