package com.itrus.common.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itrus.common.utils.YmlConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CallApiUrlDTO {

	@Autowired
	private CallApiPartUrlDTO callApiPartUrlDTO;
	
	@Autowired
	private CallApiUrlAllDTO callApiUrlAllDTO;
	
	private boolean alled() throws HttpException {
		if( "1".equals(getAlled()) || "true".equalsIgnoreCase(getAlled()) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 固定配置
	 * @return
	 * @throws HttpException 
	 */
	private String getAlled() throws HttpException {
		 String alled =  YmlConfig.get("http.callApi.alled");
		 log.info("YmlConfig http.callApi.alled={}", alled);
		 if( StringUtils.trimToNull(alled) == null ) {
			 throw new HttpException("callApi请求模式，缺少参数配置http.callApi.alled");
		 }
		 return alled;
	}
	
	
	/* ####################印章服务##################### */
	/**
	 * 创建椭圆印章
	 * @return
	 * @throws HttpException 
	 */
	public String getCreateEllipseSeal() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCreateEllipseSeal();
		}
		return callApiPartUrlDTO.getCreateEllipseSeal();
	}
	
	/**
	 * 创建圆形印章
	 * @throws HttpException 
	 */
	public String getCreateCircularSeal() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCreateCircularSeal();
		}
		return callApiPartUrlDTO.getCreateCircularSeal();
	}
	/**
	 * 创建双行人名印章
	 * @throws HttpException 
	 */
	public String getCreateDoubleRowSeal() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCreateDoubleRowSeal();
		}
		return callApiPartUrlDTO.getCreateDoubleRowSeal();
	}
	
	/**
	 * 创建单行人名印章
	 * @throws HttpException 
	 */
	public String getCreateSingleRowSeal() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCreateSingleRowSeal();
		}
		return callApiPartUrlDTO.getCreateSingleRowSeal();
	}
	
	/**
	 * 印章透明处理
	 * @throws HttpException 
	 */
	public String getSealLimpid() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getSealLimpid();
		}
		return callApiPartUrlDTO.getSealLimpid();
	}
	 /* ####################文件服务##################### */
	/**
	 * 上传文件
	 * @throws HttpException 
	 */
	public String getFileUpload() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getFileUpload();
		}
		return callApiPartUrlDTO.getFileUpload();
	}
	public String getFileUploadBase64() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getFileUploadBase64();
		}
		return callApiPartUrlDTO.getFileUploadBase64();
	}
	/**
	 * 文件删除
	 * @throws HttpException 
	 */
	public String getFileDelete() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getFileDelete();
		}
		return callApiPartUrlDTO.getFileDelete();
	}
	
	/**
	 * 文件下载
	 * @throws HttpException 
	 */
	public String getFileDownload() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getFileDownload();
		}
		return callApiPartUrlDTO.getFileDownload();
	}
	
	/**
	 * 文件下载
	 * @throws HttpException 
	 */
	public String getFileDownloadBase64() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getFileDownloadBase64();
		}
		return callApiPartUrlDTO.getFileDownloadBase64();
	}
		 /* ####################证书服务##################### */
	
	/**
	 * 文件下载
	 * @throws HttpException 
	 */
	public String getCertApply() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCertApply();
		}
		return callApiPartUrlDTO.getCertApply();
	}
	
	/**
	 * 证书查询
	 * @throws HttpException 
	 */
	public String getCertGet() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCertGet();
		}
		return callApiPartUrlDTO.getCertGet();
	}
	
	/**
	 * 证书吊销
	 * @throws HttpException 
	 */
	public String getCertRevoke() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCertRevoke();
		}
		return callApiPartUrlDTO.getCertRevoke();
	}
	
	/**
	 * 证书更新
	 * @throws HttpException 
	 */
	public String getCertUpdate() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getCertUpdate();
		}
		return callApiPartUrlDTO.getCertUpdate();
	}
/*		##################签章验章###################### */
	
	/**
	 * PDF签章
	 * @throws HttpException 
	 */
	public String getDsvsSign() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getDsvsSign();
		}
		return callApiPartUrlDTO.getDsvsSign();
	}
	
	/**
	 * PDF批量签章
	 * @throws HttpException 
	 */
	public String getDsvsBatchSign() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getDsvsBatchSign();
		}
		return callApiPartUrlDTO.getDsvsBatchSign();
	}
	
	/**
	 * PDF验章
	 * @throws HttpException 
	 */
	public String getDsvsVerifyBase64() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getDsvsVerifyBase64();
		}
		return callApiPartUrlDTO.getDsvsVerifyBase64();
	}
/*		##################文档生产服务###################### */
	
	/**
	 * PDF模板填充
	 * @throws HttpException 
	 */
	public String getPdfFill() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getPdfFill();
		}
		return callApiPartUrlDTO.getPdfFill();
	}
	
	/**
	 * PDF创建
	 * @throws HttpException 
	 */
	public String getPdfCreate() throws HttpException {
		if( alled() ) {
			return callApiUrlAllDTO.getPdfCreate();
		}
		return callApiPartUrlDTO.getPdfCreate();
	}

}
