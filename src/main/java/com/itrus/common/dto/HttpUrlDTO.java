package com.itrus.common.dto;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.itrus.common.dto.atom.Cert;
import com.itrus.common.dto.atom.Dgs;
import com.itrus.common.dto.atom.Dsvs;
import com.itrus.common.dto.atom.File;
import com.itrus.common.dto.atom.Seal;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Component
@ConfigurationProperties(prefix = "callapiurl")
@PropertySource(value = {"classpath:config/CallApiPartUrlDTO.properties"})
public class HttpUrlDTO {
	
	@Autowired
	private HttpDTO httpDTO;

	/**
	 * 印章相关url集合
	 */
	private Seal seal;

	/**
	 * 文件处理相关的url地址
	 */
	private File file;

	/**
	 * ####################证书服务#####################
	 */
	private Cert cert;
	
	/**
	##################签章验章######################
	 * 
	 */
	private Dsvs dsvs;
	
	/**
	##################文档生产服务######################
	 * 
	 */
	private Dgs dgs;
	
	
	public String getCreateEllipseSeal() throws HttpException {
		return httpDTO.getUrl()+seal.getCreateCircularSeal();
	}
	public String getCreateCircularSeal() throws HttpException {
		return httpDTO.getUrl()+seal.getCreateCircularSeal();
	}
	public String getCreateDoubleRowSeal() throws HttpException {
		return httpDTO.getUrl()+seal.getCreateDoubleRowSeal();
	}
	public String getCreateSingleRowSeal() throws HttpException {
		return httpDTO.getUrl()+seal.getCreateSingleRowSeal();
	}
	public String getSealLimpid() throws HttpException {
		return httpDTO.getUrl()+seal.getSealLimpid();
	}
	public String getFileUpload() throws HttpException {
		return httpDTO.getUrl()+file.getUpload();
	}
	public String getFileUploadBase64() throws HttpException {
		return httpDTO.getUrl()+file.getUploadBase64();
	}
	public String getFileDelete() throws HttpException {
		return httpDTO.getUrl()+file.getDelete();
	}
	public String getFileDownload() throws HttpException {
		return httpDTO.getUrl()+file.getDownload();
	}
	public String getFileDownloadBase64() throws HttpException {
		return httpDTO.getUrl()+file.getDownloadBase64();
	}
	public String getCertApply() throws HttpException {
		return httpDTO.getUrl()+cert.getApply();
	}
	public String getCertGet() throws HttpException {
		return httpDTO.getUrl()+cert.getGet();
	}
	public String getCertRevoke() throws HttpException {
		return httpDTO.getUrl()+cert.getRevoke();
	}
	public String getCertUpdate() throws HttpException {
		return httpDTO.getUrl()+cert.getUpdate();
	}
	public String getDsvsSign() throws HttpException {
		return httpDTO.getUrl()+dsvs.getSign();
	}
	public String getDsvsBatchSign() throws HttpException {
		return httpDTO.getUrl()+dsvs.getBatchSign();
	}
	public String getDsvsVerifyBase64() throws HttpException {
		return httpDTO.getUrl()+dsvs.getVerifyBase64();
	}
	public String getPdfFill() throws HttpException {
		return httpDTO.getUrl()+dgs.getPdfFill();
	}
	public String getPdfCreate() throws HttpException {
		return httpDTO.getUrl()+dgs.getPdfCreate();
	}
	
}
