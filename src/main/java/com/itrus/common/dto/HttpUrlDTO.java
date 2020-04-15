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
import com.itrus.common.dto.atom.Uag;

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
	
	/**
	##################UAG组织架构服务######################
	 * 
	 */
	private Uag uag;
	
	
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
	public String getPdfTextMark() throws HttpException {
		return httpDTO.getUrl()+dgs.getPdfTextMark();
	}
	public String getPdfImageMark() throws HttpException {
		return httpDTO.getUrl()+dgs.getPdfImageMark();
	}
	public String getPdfQrCodeMark() throws HttpException {
		return httpDTO.getUrl()+dgs.getPdfQrCodeMark();
	}
	public String getPdfTextAndQrCodeMark() throws HttpException {
		return httpDTO.getUrl()+dgs.getPdfTextAndQrCodeMark();
	}


	public String getCreateAdmin() throws HttpException {
		return httpDTO.getUrl()+uag.getCreateAdmin();
	}
	public String getCreateUtsNode() throws HttpException {
		return httpDTO.getUrl()+uag.getCreateUtsNode();
	}
	public String getUpdateUtsNode() throws HttpException {
		return httpDTO.getUrl()+uag.getUpdateUtsNode();
	}
	public String getUpgradeAdmin() throws HttpException {
		return httpDTO.getUrl()+uag.getUpgradeAdmin();
	}
	public String getCancelAdminAuth() throws HttpException {
		return httpDTO.getUrl()+uag.getCancelAdminAuth();
	}
	public String getDeleteUtsNode() throws HttpException {
		return httpDTO.getUrl()+uag.getDeleteUtsNode();
	}
	public String getRenameUtsNode() throws HttpException {
		return httpDTO.getUrl()+uag.getRenameUtsNode();
	}
	public String getMovingUtsNode() throws HttpException {
		return httpDTO.getUrl()+uag.getMovingUtsNode();
	}
	public String getFindAllSubLevelUser() throws HttpException {
		return httpDTO.getUrl()+uag.getFindAllSubLevelUser();
	}
	public String getFindAllOneLevelNode() throws HttpException {
		return httpDTO.getUrl()+uag.getFindAllOneLevelNode();
	}
	public String getFindAllOneLevelChildren() throws HttpException {
		return httpDTO.getUrl()+uag.getFindAllOneLevelChildren();
	}
	public String getResetNodePassword() throws HttpException {
		return httpDTO.getUrl()+uag.getResetNodePassword();
	}
	public String getVerfyUserExistRootNode() throws HttpException {
		return httpDTO.getUrl()+uag.getVerfyUserExistRootNode();
	}
	
	public String getDeleteRootChild() throws HttpException {
		return httpDTO.getUrl()+uag.getDeleteRootChild();
	}
	
}
