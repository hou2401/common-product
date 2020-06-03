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


	public String getUserRegister() throws HttpException {
		return httpDTO.getUrl()+uag.getUserRegister();
	}
	public String getUserUpdate() throws HttpException {
		return httpDTO.getUrl()+uag.getUserUpdate();
	}
	public String getUserSearchInfo() throws HttpException {
		return httpDTO.getUrl()+uag.getUserSearchInfo();
	}
	public String getResetPassWd() throws HttpException {
		return httpDTO.getUrl()+uag.getResetPassWd();
	}
	public String getEntAdd() throws HttpException {
		return httpDTO.getUrl()+uag.getEntAdd();
	}
	public String getEntUpdate() throws HttpException {
		return httpDTO.getUrl()+uag.getEntUpdate();
	}
	public String getEntSearchInfo() throws HttpException {
		return httpDTO.getUrl()+uag.getEntSearchInfo();
	}
	public String getDeptAdd() throws HttpException {
		return httpDTO.getUrl()+uag.getDeptAdd();
	}
	public String getDeptUpdate() throws HttpException {
		return httpDTO.getUrl()+uag.getDeptUpdate();
	}
	public String getDeptSearchInfo() throws HttpException {
		return httpDTO.getUrl()+uag.getDeptSearchInfo();
	}
	public String getDeptDelete() throws HttpException {
		return httpDTO.getUrl()+uag.getDeptDelete();
	}
	public String getEntSearchOneNode() throws HttpException {
		return httpDTO.getUrl()+uag.getEntSearchOneNode();
	}
	public String getDeptSearchOneNode() throws HttpException {
		return httpDTO.getUrl()+uag.getDeptSearchOneNode();
	}
	public String getEntAll() throws HttpException {
		return httpDTO.getUrl()+uag.getEntAll();
	}
	public String getDeptAll() throws HttpException {
		return httpDTO.getUrl()+uag.getDeptAll();
	}
	public String getFindJoinCompanys() throws HttpException {
		return httpDTO.getUrl()+uag.getFindJoinCompanys();
	}
	public String getBetchImport() throws HttpException {
		return httpDTO.getUrl()+uag.getBetchImport();
	}
	public String getRemoveUser() throws HttpException {
		return httpDTO.getUrl()+uag.getRemoveUser();
	}
	public String getSwitchEnterprise() throws HttpException {
		return httpDTO.getUrl()+uag.getSwitchEnterprise();
	}
	public String getJoinEnterprise() throws HttpException {
		return httpDTO.getUrl()+uag.getJoinEnterprise();
	}
	public String getPasswdAuth() throws HttpException {
		return httpDTO.getUrl()+uag.getPasswdAuth();
	}
	public String getGetVerificationCode() throws HttpException {
		return httpDTO.getUrl()+uag.getGetVerificationCode();
	}
	public String getVerifySmsCodeAuth() throws HttpException {
		return httpDTO.getUrl()+uag.getVerifySmsCodeAuth();
	}
	public String getLogout() throws HttpException {
		return httpDTO.getUrl()+uag.getLogout();
	}
	public String getExtendedAdd() throws HttpException {
		return httpDTO.getUrl()+uag.getLogout();
	}
	public String getFindChildUuidList() throws HttpException {
		return httpDTO.getUrl()+uag.getFindChildUuidList();
	}
	public String getGrantAuth() throws HttpException {
		return httpDTO.getUrl()+uag.getGrantAuth();
	}
	public String getFindUserInfoByUuidList() throws HttpException {
		return httpDTO.getUrl()+uag.getFindUserInfoByUuidList();
	}
	public String getFindAllEnterpriseAndUser() throws HttpException {
		return httpDTO.getUrl()+uag.getFindAllEnterpriseAndUser();
	}
	
	public String getFindSuperManagerForCompany() throws HttpException {
		return httpDTO.getUrl()+uag.getFindSuperManagerForCompany();
	}

	public String getentLoadTree() throws HttpException {
		return httpDTO.getUrl()+uag.getEntLoadTree();
	}
}
