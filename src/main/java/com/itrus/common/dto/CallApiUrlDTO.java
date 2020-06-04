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
     *
     * @return
     * @throws HttpException
     */
    public String getCreateEllipseSeal() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getSeal().getCreateEllipseSeal();
        }
        return callApiPartUrlDTO.getSeal().getCreateEllipseSeal();
    }

    /**
     * 创建圆形印章
     *
     * @throws HttpException
     */
    public String getCreateCircularSeal() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getSeal().getCreateCircularSeal();
        }
        return callApiPartUrlDTO.getSeal().getCreateCircularSeal();
    }

    /**
     * 创建双行人名印章
     *
     * @throws HttpException
     */
    public String getCreateDoubleRowSeal() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getSeal().getCreateDoubleRowSeal();
        }
        return callApiPartUrlDTO.getSeal().getCreateDoubleRowSeal();
    }

    /**
     * 创建单行人名印章
     *
     * @throws HttpException
     */
    public String getCreateSingleRowSeal() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getSeal().getCreateSingleRowSeal();
        }
        return callApiPartUrlDTO.getSeal().getCreateSingleRowSeal();
    }

    /**
     * 印章透明处理
     *
     * @throws HttpException
     */
    public String getSealLimpid() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getSeal().getSealLimpid();
        }
        return callApiPartUrlDTO.getSeal().getSealLimpid();
    }
    /* ####################文件服务##################### */

    /**
     * 上传文件
     *
     * @throws HttpException
     */
    public String getFileUpload() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getUpload();
        }
        return callApiPartUrlDTO.getFile().getUpload();
    }

    public String getFileUploadBase64() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getUploadBase64();
        }
        return callApiPartUrlDTO.getFile().getUploadBase64();
    }

    /**
     * 文件删除
     *
     * @throws HttpException
     */
    public String getFileDelete() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getDelete();
        }
        return callApiPartUrlDTO.getFile().getDelete();
    }

    /**
     * 文件下载
     *
     * @throws HttpException
     */
    public String getFileDownload() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getDownload();
        }
        return callApiPartUrlDTO.getFile().getDownload();
    }

    /**
     * 文件下载
     *
     * @throws HttpException
     */
    public String getFileDownloadBase64() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getDownloadBase64();
        }
        return callApiPartUrlDTO.getFile().getDownloadBase64();
    }
    /**
     * 文档转换
     *
     * @throws HttpException
     */
    public String getWord2Pdfs() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getWord2Pdfs();
        }
        return callApiPartUrlDTO.getFile().getWord2Pdfs();
    }

    /**
     * 文档转换
     *
     * @throws HttpException
     */
    public String getPdf2png() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getFile().getPdf2png();
        }
        return callApiPartUrlDTO.getFile().getPdf2png();
    }

    /* ####################证书服务##################### */

    /**
     * 文件下载
     *
     * @throws HttpException
     */
    public String getCertApply() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getCert().getApply();
        }
        return callApiPartUrlDTO.getCert().getApply();
    }

    /**
     * 证书查询
     *
     * @throws HttpException
     */
    public String getCertGet() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getCert().getGet();
        }
        return callApiPartUrlDTO.getCert().getGet();
    }

    /**
     * 证书吊销
     *
     * @throws HttpException
     */
    public String getCertRevoke() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getCert().getRevoke();
        }
        return callApiPartUrlDTO.getCert().getRevoke();
    }

    /**
     * 证书更新
     *
     * @throws HttpException
     */
    public String getCertUpdate() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getCert().getUpdate();
        }
        return callApiPartUrlDTO.getCert().getUpdate();
    }
    /*		##################签章验章###################### */

    /**
     * PDF签章
     *
     * @throws HttpException
     */
    public String getDsvsSign() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDsvs().getSign();
        }
        return callApiPartUrlDTO.getDsvs().getSign();
    }

    /**
     * PDF批量签章
     *
     * @throws HttpException
     */
    public String getDsvsBatchSign() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDsvs().getBatchSign();
        }
        return callApiPartUrlDTO.getDsvs().getBatchSign();
    }

    /**
     * PDF验章
     *
     * @throws HttpException
     */
    public String getDsvsVerifyBase64() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDsvs().getVerifyBase64();
        }
        return callApiPartUrlDTO.getDsvs().getVerifyBase64();
    }
    /*		##################文档生产服务###################### */

    /**
     * PDF模板填充
     *
     * @throws HttpException
     */
    public String getPdfFill() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDgs().getPdfFill();
        }
        return callApiPartUrlDTO.getDgs().getPdfFill();
    }

    /**
     * PDF创建
     *
     * @throws HttpException
     */
    public String getPdfCreate() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDgs().getPdfCreate();
        }
        return callApiPartUrlDTO.getDgs().getPdfCreate();
    }

    /**
     * 添加文字水印
     *
     * @return
     * @throws HttpException
     */
    public String getPdfTextMark() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDgs().getPdfTextMark();
        }
        return callApiPartUrlDTO.getDgs().getPdfTextMark();
    }

    /**
     * 添加图片水印
     *
     * @return
     * @throws HttpException
     */
    public String getPdfImageMark() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDgs().getPdfImageMark();
        }
        return callApiPartUrlDTO.getDgs().getPdfImageMark();

    }

    /**
     * 添加二维码水印
     *
     * @return
     * @throws HttpException
     */
    public String getPdfQrCodeMark() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDgs().getPdfQrCodeMark();
        }
        return callApiPartUrlDTO.getDgs().getPdfQrCodeMark();
    }

    /**
     * 添加文字和二维码水印
     *
     * @return
     * @throws HttpException
     */
    public String getPdfTextAndQrCodeMark() throws HttpException {

        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getDgs().getPdfTextAndQrCodeMark();
        }
        return callApiPartUrlDTO.getDgs().getPdfTextAndQrCodeMark();
    }


    /*		##################UAG组织架构服务############################### */

    /**
            * 用户注册
     *
     * @throws HttpException
     */
    public String getUserRegister() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getUserRegister();
    	}
    	return callApiPartUrlDTO.getUag().getUserRegister();
    }
    
    /**
             * 用户更新
     *
     * @throws HttpException
     */
    public String getUserUpdate() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getUserUpdate();
        }
        return callApiPartUrlDTO.getUag().getUserUpdate();
    }

    /**
            * 用户详细信息查询
     *
     * @throws HttpException
     */
    public String getUserSearchInfo() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getUserSearchInfo();
        }
        return callApiPartUrlDTO.getUag().getUserSearchInfo();
    }

    /**
            *用户更新/重置/忘记密码
     *
     * @throws HttpException
     */
    public String getResetPassWd() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getResetPassWd();
        }
        return callApiPartUrlDTO.getUag().getResetPassWd();
    }

    /**
         * 创建企业
     *
     * @return
     */
    public String getEntAdd() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getEntAdd();
        }
        return callApiPartUrlDTO.getUag().getEntAdd();
    }

    /**
            * 更新企业
     *
     * @return
     */
    public String getEntUpdate() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getEntUpdate();
        }
        return callApiPartUrlDTO.getUag().getEntUpdate();
    }

    /**
            * 企业详细信息查询
     *
     * @return
     */
    public String getEntSearchInfo() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getEntSearchInfo();
        }
        return callApiPartUrlDTO.getUag().getEntSearchInfo();
    }

    /**
            * 创建部门
     *
     * @return
     */
    public String getDeptAdd() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getDeptAdd();
        }
        return callApiPartUrlDTO.getUag().getDeptAdd();
    }

    /**
            * 更新部门
     *
     * @return
     */
    public String getDeptUpdate() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getDeptUpdate();
        }
        return callApiPartUrlDTO.getUag().getDeptUpdate();
    }

    /**
            * 查询部门详情信息
     *
     * @return
     */
    public String getDeptSearchInfo() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getDeptSearchInfo();
        }
        return callApiPartUrlDTO.getUag().getDeptSearchInfo();
    }

    /**
             * 部门删除
     *
     * @return
     */
    public String getDeptDelete() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getDeptDelete();
        }
        return callApiPartUrlDTO.getUag().getDeptDelete();
    }

    /**
            * 查询企业下一级节点信息
     *
     * @return
     */
    public String getEntSearchOneNode() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getEntSearchOneNode();
        }
        return callApiPartUrlDTO.getUag().getEntSearchOneNode();
    }

    /**
            * 查询部门下一级节点信息
     *
     * @return
     */
    public String getDeptSearchOneNode() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getDeptSearchOneNode();
        }
        return callApiPartUrlDTO.getUag().getDeptSearchOneNode();
    }

    /**
             * 查询企业下全部节点信息
     *
     * @return
     */
    public String getEntAll() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getEntAll();
        }
        return callApiPartUrlDTO.getUag().getEntAll();
    }
    
    /**
             * 查询部门下全部节点信息
     *
     * @return
     */
    public String getDeptAll() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getDeptAll();
        }
        return callApiPartUrlDTO.getUag().getDeptAll();
    }
    
    /**
            * 查询当前用户加入的企业列表
     *
     * @return
     */
    public String getFindJoinCompanys() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getFindJoinCompanys();
    	}
    	return callApiPartUrlDTO.getUag().getFindJoinCompanys();
    }
    
    /**
             * 批量导入
     *
     * @return
     */
    public String getBetchImport() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getBetchImport();
    	}
    	return callApiPartUrlDTO.getUag().getBetchImport();
    }
    
    /**
             * 移除邀约用户
     *
     * @return
     */
    public String getRemoveUser() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getRemoveUser();
    	}
    	return callApiPartUrlDTO.getUag().getRemoveUser();
    }
    
    /**
             * 用户切换企业
     *
     * @return
     */
    public String getSwitchEnterprise() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getSwitchEnterprise();
    	}
    	return callApiPartUrlDTO.getUag().getSwitchEnterprise();
    }
    
    /**
             * 企业邀请用户
     *
     * @return
     */
    public String getJoinEnterprise() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getJoinEnterprise();
    	}
    	return callApiPartUrlDTO.getUag().getJoinEnterprise();
    }

    /**
     * 重新邀请企业用户
     *
     * @return
     */
    public String getReJoinEnterprise() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getReJoinEnterprise();
        }
        return callApiPartUrlDTO.getUag().getReJoinEnterprise();
    }
    
    /**
             * 口令认证
     *
     * @return
     */
    public String getPasswdAuth() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getPasswdAuth();
    	}
    	return callApiPartUrlDTO.getUag().getPasswdAuth();
    }
    
    /**
             * 获取短信验证码
     *
     * @return
     */
    public String getGetVerificationCode() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getGetVerificationCode();
    	}
    	return callApiPartUrlDTO.getUag().getGetVerificationCode();
    }
    
    /**
            * 验证短信验证码
     *
     * @return
     */
    public String getVerifySmsCodeAuth() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getVerifySmsCodeAuth();
    	}
    	return callApiPartUrlDTO.getUag().getVerifySmsCodeAuth();
    }
    
    /**
             * 退出单点登录
     *
     * @return
     */
    public String getLogout() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getLogout();
    	}
    	return callApiPartUrlDTO.getUag().getLogout();
    }
    
    /**
             * 添加扩展属性
     *
     * @return
     */
    public String getExtendedAdd() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getExtendedAdd();
    	}
    	return callApiPartUrlDTO.getUag().getExtendedAdd();
    }
    
    /**
            * 查询当前节点下uuid集合
     *
     * @return
     */
    public String getFindChildUuidList() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getFindChildUuidList();
    	}
    	return callApiPartUrlDTO.getUag().getFindChildUuidList();
    }
    
    /**
             * 用户授权接口
     *
     * @return
     */
    public String getGrantAuth() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getGrantAuth();
    	}
    	return callApiPartUrlDTO.getUag().getGrantAuth();
    }
    
    /**
             *根据手机号或uuid集合查询用户信息
     *
     * @return
     */
    public String getFindUserInfoByUuidList() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getFindUserInfoByUuidList();
    	}
    	return callApiPartUrlDTO.getUag().getFindUserInfoByUuidList();
    }
    
    /**
             *全量查询企业和用户信息
     *
     * @return
     */
    public String getFindAllEnterpriseAndUser() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getFindAllEnterpriseAndUser();
    	}
    	return callApiPartUrlDTO.getUag().getFindAllEnterpriseAndUser();
    }
    
    /**
     *全量查询企业和用户信息
     *
     * @return
     */
    public String getFindSuperManagerForCompany() throws HttpException {
    	if (httpDTO.alled()) {
    		return callApiUrlAllDTO.getUag().getFindSuperManagerForCompany();
    	}
    	return callApiPartUrlDTO.getUag().getFindSuperManagerForCompany();
    }

    /**
     * 查询企业下全部节点信息
     *
     * @return
     */
    public String getentLoadTree() throws HttpException {
        if (httpDTO.alled()) {
            return callApiUrlAllDTO.getUag().getEntLoadTree();
        }
        return callApiPartUrlDTO.getUag().getEntLoadTree();
    }
    

}
