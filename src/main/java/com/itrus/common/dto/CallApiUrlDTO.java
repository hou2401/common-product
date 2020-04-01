package com.itrus.common.dto;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallApiUrlDTO {
	@Autowired
	private CallApiAllUrlDTO callApiUrlAllDTO;

	@Autowired
	private CallApiPartUrlDTO callApiPartUrlDTO;
	
	@Autowired
	private HttpDTO httpDTO;
	
	/* ####################印章服务##################### */
	/**
	 * 创建椭圆印章
	 * @return
	 * @throws HttpException 
	 */
	public String getCreateEllipseSeal() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getSeal().getCreateEllipseSeal();
		}
		return callApiPartUrlDTO.getSeal().getCreateEllipseSeal();
	}
	
	/**
	 * 创建圆形印章
	 * @throws HttpException 
	 */
	public String getCreateCircularSeal() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getSeal().getCreateCircularSeal();
		}
		return callApiPartUrlDTO.getSeal().getCreateCircularSeal();
	}
	/**
	 * 创建双行人名印章
	 * @throws HttpException 
	 */
	public String getCreateDoubleRowSeal() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getSeal().getCreateDoubleRowSeal();
		}
		return callApiPartUrlDTO.getSeal().getCreateDoubleRowSeal();
	}
	
	/**
	 * 创建单行人名印章
	 * @throws HttpException 
	 */
	public String getCreateSingleRowSeal() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getSeal().getCreateSingleRowSeal();
		}
		return callApiPartUrlDTO.getSeal().getCreateSingleRowSeal();
	}
	
	/**
	 * 印章透明处理
	 * @throws HttpException 
	 */
	public String getSealLimpid() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getSeal().getSealLimpid();
		}
		return callApiPartUrlDTO.getSeal().getSealLimpid();
	}
	 /* ####################文件服务##################### */
	/**
	 * 上传文件
	 * @throws HttpException 
	 */
	public String getFileUpload() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getFile().getUpload();
		}
		return callApiPartUrlDTO.getFile().getUpload();
	}
	public String getFileUploadBase64() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getFile().getUploadBase64();
		}
		return callApiPartUrlDTO.getFile().getUploadBase64();
	}
	/**
	 * 文件删除
	 * @throws HttpException 
	 */
	public String getFileDelete() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getFile().getDelete();
		}
		return callApiPartUrlDTO.getFile().getDelete();
	}
	
	/**
	 * 文件下载
	 * @throws HttpException 
	 */
	public String getFileDownload() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getFile().getDownload();
		}
		return callApiPartUrlDTO.getFile().getDownload();
	}
	
	/**
	 * 文件下载
	 * @throws HttpException 
	 */
	public String getFileDownloadBase64() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getFile().getDownloadBase64();
		}
		return callApiPartUrlDTO.getFile().getDownloadBase64();
	}
		 /* ####################证书服务##################### */
	
	/**
	 * 文件下载
	 * @throws HttpException 
	 */
	public String getCertApply() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getCert().getApply();
		}
		return callApiPartUrlDTO.getCert().getApply();
	}
	
	/**
	 * 证书查询
	 * @throws HttpException 
	 */
	public String getCertGet() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getCert().getGet();
		}
		return callApiPartUrlDTO.getCert().getGet();
	}
	
	/**
	 * 证书吊销
	 * @throws HttpException 
	 */
	public String getCertRevoke() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getCert().getRevoke();
		}
		return callApiPartUrlDTO.getCert().getRevoke();
	}
	
	/**
	 * 证书更新
	 * @throws HttpException 
	 */
	public String getCertUpdate() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getCert().getUpdate();
		}
		return callApiPartUrlDTO.getCert().getUpdate();
	}
/*		##################签章验章###################### */
	
	/**
	 * PDF签章
	 * @throws HttpException 
	 */
	public String getDsvsSign() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getDsvs().getSign();
		}
		return callApiPartUrlDTO.getDsvs().getSign();
	}
	
	/**
	 * PDF批量签章
	 * @throws HttpException 
	 */
	public String getDsvsBatchSign() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getDsvs().getBatchSign();
		}
		return callApiPartUrlDTO.getDsvs().getBatchSign();
	}
	
	/**
	 * PDF验章
	 * @throws HttpException 
	 */
	public String getDsvsVerifyBase64() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getDsvs().getVerifyBase64();
		}
		return callApiPartUrlDTO.getDsvs().getVerifyBase64();
	}
/*		##################文档生产服务###################### */
	
	/**
	 * PDF模板填充
	 * @throws HttpException 
	 */
	public String getPdfFill() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getDgs().getPdfFill();
		}
		return callApiPartUrlDTO.getDgs().getPdfFill();
	}
	
	/**
	 * PDF创建
	 * @throws HttpException 
	 */
	public String getPdfCreate() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getDgs().getPdfCreate();
		}
		return callApiPartUrlDTO.getDgs().getPdfCreate();
	}

/*		##################UAG组织架构服务############################### */
	/**
	 * 企业注册
	 * @throws HttpException 
	 */
	public String getCreateAdmin() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getCreateAdmin();
		}
		return callApiPartUrlDTO.getUag().getCreateAdmin();
	}
	
	/**
	 * 新增节点
	 * @throws HttpException 
	 */
	public String getCreateUtsNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getCreateUtsNode();
		}
		return callApiPartUrlDTO.getUag().getCreateUtsNode();
	}

	/**
	 * 更新节点
	 * @throws HttpException 
	 */
	public String getUpdateUtsNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getUpdateUtsNode();
		}
		return callApiPartUrlDTO.getUag().getUpdateUtsNode();
	}

	/**
	 * 升级用户为管理员
	 * @return
	 */
	public String getUpgradeAdmin() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getUpgradeAdmin();
		}
		return callApiPartUrlDTO.getUag().getUpgradeAdmin();
	}
	
	/**
	 * 取消管理员权限
	 * @return
	 */
	public String getCancelAdminAuth() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getCancelAdminAuth();
		}
		return callApiPartUrlDTO.getUag().getCancelAdminAuth();
	}
	
	/**
	 * 删除节点
	 * @return
	 */
	public String getDeleteUtsNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getDeleteUtsNode();
		}
		return callApiPartUrlDTO.getUag().getDeleteUtsNode();
	}
	
	/**
	 * 重命名节点
	 * @return
	 */
	public String getRenameUtsNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getRenameUtsNode();
		}
		return callApiPartUrlDTO.getUag().getRenameUtsNode();
	}
	
	/**
	 * 移动节点
	 * @return
	 */
	public String getMovingUtsNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getMovingUtsNode();
		}
		return callApiPartUrlDTO.getUag().getMovingUtsNode();
	}
	
	/**
	 * 根据节点类型查找当前节点下所有节点数据
	 * @return
	 */
	public String getFindAllSubLevelUser() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getFindAllSubLevelUser();
		}
		return callApiPartUrlDTO.getUag().getFindAllSubLevelUser();
	}
	
	/**
	 *查询节点下所有一级节点
	 * @return
	 */
	public String getFindAllOneLevelNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getFindAllOneLevelNode();
		}
		return callApiPartUrlDTO.getUag().getFindAllOneLevelNode();
	}
	
	/**
	 *查询当前节点下所有下一级节点或加载权限树
	 * @return
	 */
	public String getFindAllOneLevelChildren() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getFindAllOneLevelChildren();
		}
		return callApiPartUrlDTO.getUag().getFindAllOneLevelChildren();
	}
	
	/**
	 *重置用户密码
	 * @return
	 */
	public String getResetNodePassword() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getResetNodePassword();
		}
		return callApiPartUrlDTO.getUag().getResetNodePassword();
	}
	
	/**
	 *判断当前用户是否根节点下用户
	 * @return
	 */
	public String getVerfyUserExistRootNode() throws HttpException {
		if( httpDTO.alled() ) {
			return callApiUrlAllDTO.getUag().getVerfyUserExistRootNode();
		}
		return callApiPartUrlDTO.getUag().getVerfyUserExistRootNode();
	}

}
