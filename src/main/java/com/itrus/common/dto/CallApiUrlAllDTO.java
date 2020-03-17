package com.itrus.common.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Component
@PropertySource(value = {"classpath:config/CallApiPartUrlDTO.yml"})
public class CallApiUrlAllDTO {

	/**
	 * 创建椭圆印章
	 */
	@Value("${callApiUrl.seal.createEllipseSeal}")
	private String createEllipseSeal;

	/**
	 * 创建圆形印章
	 */
	@Value("${callApiUrl.seal.createCircularSeal}")
	private String createCircularSeal;


	/**
	 * 创建双行人名印章
	 */
	@Value("${callApiUrl.seal.createDoubleRowSeal}")
	private String createDoubleRowSeal;
	/**
	 * 创建单行人名印章
	 */
	@Value("${callApiUrl.seal.createSingleRowSeal}")
	private String createSingleRowSeal;
	/**
	 * 印章透明处理
	 */
	@Value("${callApiUrl.seal.sealLimpid}")
	private String sealLimpid;

	/**
	 * 上传文件
	 */
	@Value("${callApiUrl.file.upload}")
	private String fileUpload;

	/**
	 * 文件base64上传
	 */
	@Value("${callApiUrl.file.uploadBase64}")
	private String fileUploadBase64;

	/**
	 * #文件删除
	 */
	@Value("${callApiUrl.file.delete}")
	private String fileDelete;

	/**
	 * 文件下载
	 */
	@Value("${callApiUrl.file.download}")
	private String fileDownload;

	@Value("${callApiUrl.file.downloadBase64}")
	private String fileDownloadBase64;

	/**
	 * ####################证书服务#####################
	 */
	/**
	 * 证书申请
	 */
	@Value("${callApiUrl.cert.apply}")
	private String certApply;
	/**
	 * 证书查询
	 */
	@Value("${callApiUrl.cert.get}")
	private String certGet;
	/**
	 * 证书吊销
	 */
	@Value("${callApiUrl.cert.revoke}")
	private String certRevoke;
	/**
	 * 证书更新
	 */
	@Value("${callApiUrl.cert.update}")
	private String certUpdate;

	/**
	##################签章验章######################
	 * 
	 */
	/**
	 * PDF签章
	 */
	@Value("${callApiUrl.dsvs.sign}")
	private String dsvsSign;
	/**
	 * PDF批量签章
	 */
	@Value("${callApiUrl.dsvs.batchSign}")
	private String dsvsBatchSign;
	/**
	 * PDF验章
	 */
	@Value("${callApiUrl.dsvs.verifyBase64}")
	private String dsvsVerifyBase64;

	/**
	##################文档生产服务######################
	 * 
	 */
	/**
	 * PDF模板填充
	 */
	@Value("${callApiUrl.dgs.pdfFill}")
	private String pdfFill;
	/**
	 * PDF创建
	 */
	@Value("${callApiUrl.dgs.pdfCreate}")
	private String pdfCreate;
	
}
