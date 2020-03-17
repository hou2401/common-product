package com.itrus.common.dto;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource(value = {"classpath:config/HttpUrlDTO.properties"})
public class HttpUrlDTO {
	
	@Autowired
	private HttpDTO httpDTO;

	/**
	 * 创建椭圆印章
	 */
	@Value("${http.url.seal.createEllipseSeal}")
	private String createEllipseSeal;

	/**
	 * 创建圆形印章
	 */
	@Value("${http.url.seal.createCircularSeal}")
	private String createCircularSeal;


	/**
	 * 创建双行人名印章
	 */
	@Value("${http.url.seal.createDoubleRowSeal}")
	private String createDoubleRowSeal;
	/**
	 * 创建单行人名印章
	 */
	@Value("${http.url.seal.createSingleRowSeal}")
	private String createSingleRowSeal;
	/**
	 * 印章透明处理
	 */
	@Value("${http.url.seal.sealLimpid}")
	private String sealLimpid;

	/**
	 * 上传文件
	 */
	@Value("${http.url.file.upload}")
	private String fileUpload;

	/**
	 * 文件base64上传
	 */
	@Value("${http.url.file.uploadBase64}")
	private String fileUploadBase64;

	/**
	 * #文件删除
	 */
	@Value("${http.url.file.delete}")
	private String fileDelete;

	/**
	 * 文件下载
	 */
	@Value("${http.url.file.download}")
	private String fileDownload;

	@Value("${http.url.file.downloadBase64}")
	private String fileDownloadBase64;

	/**
	 * ####################证书服务#####################
	 */
	/**
	 * 证书申请
	 */
	@Value("${http.url.cert.apply}")
	private String certApply;
	/**
	 * 证书查询
	 */
	@Value("${http.url.cert.get}")
	private String certGet;
	/**
	 * 证书吊销
	 */
	@Value("${http.url.cert.revoke}")
	private String certRevoke;
	/**
	 * 证书更新
	 */
	@Value("${http.url.cert.update}")
	private String certUpdate;

	/**
	##################签章验章######################
	 * 
	 */
	/**
	 * PDF签章
	 */
	@Value("${http.url.dsvs.sign}")
	private String dsvsSign;
	/**
	 * PDF批量签章
	 */
	@Value("${http.url.dsvs.batchSign}")
	private String dsvsBatchSign;
	/**
	 * PDF验章
	 */
	@Value("${http.url.dsvs.verifyBase64}")
	private String dsvsVerifyBase64;

	/**
	##################文档生产服务######################
	 * 
	 */
	/**
	 * PDF模板填充
	 */
	@Value("${http.url.dgs.pdfFill}")
	private String pdfFill;
	/**
	 * PDF创建
	 */
	@Value("${http.url.dgs.pdfCreate}")
	private String pdfCreate;
	
	
	public String getCreateEllipseSeal() throws HttpException {
		return httpDTO.getUrl()+createEllipseSeal;
	}
	public String getCreateCircularSeal() throws HttpException {
		return httpDTO.getUrl()+createCircularSeal;
	}
	public String getCreateDoubleRowSeal() throws HttpException {
		return httpDTO.getUrl()+createDoubleRowSeal;
	}
	public String getCreateSingleRowSeal() throws HttpException {
		return httpDTO.getUrl()+createSingleRowSeal;
	}
	public String getSealLimpid() throws HttpException {
		return httpDTO.getUrl()+sealLimpid;
	}
	public String getFileUpload() throws HttpException {
		return httpDTO.getUrl()+fileUpload;
	}
	public String getFileUploadBase64() throws HttpException {
		return httpDTO.getUrl()+fileUploadBase64;
	}
	public String getFileDelete() throws HttpException {
		return httpDTO.getUrl()+fileDelete;
	}
	public String getFileDownload() throws HttpException {
		return httpDTO.getUrl()+fileDownload;
	}
	public String getFileDownloadBase64() throws HttpException {
		return httpDTO.getUrl()+fileDownloadBase64;
	}
	public String getCertApply() throws HttpException {
		return httpDTO.getUrl()+certApply;
	}
	public String getCertGet() throws HttpException {
		return httpDTO.getUrl()+certGet;
	}
	public String getCertRevoke() throws HttpException {
		return httpDTO.getUrl()+certRevoke;
	}
	public String getCertUpdate() throws HttpException {
		return httpDTO.getUrl()+certUpdate;
	}
	public String getDsvsSign() throws HttpException {
		return httpDTO.getUrl()+dsvsSign;
	}
	public String getDsvsBatchSign() throws HttpException {
		return httpDTO.getUrl()+dsvsBatchSign;
	}
	public String getDsvsVerifyBase64() throws HttpException {
		return httpDTO.getUrl()+dsvsVerifyBase64;
	}
	public String getPdfFill() throws HttpException {
		return httpDTO.getUrl()+pdfFill;
	}
	public String getPdfCreate() throws HttpException {
		return httpDTO.getUrl()+pdfCreate;
	}
	
}
