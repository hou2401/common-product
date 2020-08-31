package com.itrus.common.http;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.exception.EnterpriseAuthException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.request.auth.AuthEnterpriseBankRequest;
import com.itrus.common.request.auth.AuthEnterpriseRequest;
import com.itrus.common.request.auth.AuthPersionRequest;
import com.itrus.common.request.auth.AuthPersionVideoRequest;
import com.itrus.common.utils.HttpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthApiRequest {

	@Autowired
    private HttpDTO http;
	
	public boolean isOk(JSONObject object) {
		if (object.get("status") != null) {
			return object.getIntValue("status") == 1;

		}
		return false;
	}
	
	/**
	 * 获取请求消息
	 *
	 * @param object json对象
	 */
	public String getMsg(JSONObject object) {
		if( object != null ) {
			return object.getString("message");
		}
		return null;
	}


    /**
     * 实名服务，2要素/手机号3要素/银行卡3、4要素 --个人实名
     *
     * @param authPersionParams
     * @return
     * @throws PersionAuthException
     * @throws Exception
     */
    public JSONObject auth(AuthPersionRequest authPersionRequest) throws PersionAuthException {

        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.authPersion(authPersionRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
	/**
	 *  个人实名认证   
		不支持视频h5核身功能
	 * @param persion
	 * @return
	 * @throws PersionAuthException 
	 * @throws Exception
	 */
	public JSONObject authPersion(AuthPersionRequest persion) throws PersionAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(persion.getUrl(), persion.getParams(), persion.getHeader());
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new PersionAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("异常错误:{},入参：persion={},返回结果：{}",e.getMessage(),persion.toString(), doPost,e);
			throw new PersionAuthException(e);
		}
	}
    
    /**
     * 实名服务 video h5，静默，数读接口
     *
     * @param authPersionVideoParams
     * @return
     * @throws PersionAuthException
     * @throws Exception
     */
    public JSONObject auth(AuthPersionVideoRequest authPersionVideoRequest) throws PersionAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.authPersionVideo(authPersionVideoRequest);
            if (result != null) {
                break;
            }

        }
        return result;
    }
    /**
	 *  视频h5核身功能
	 *  支持熟读
	 * @param persion
	 * @return
	 * @throws Exception
	 */
	public JSONObject authPersionVideo(AuthPersionVideoRequest persion) throws PersionAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(persion.getUrl(), persion.getParams(), persion.getHeader());
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new PersionAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("异常错误:{},入参：persion={},返回结果：{}",e.getMessage(),persion.toString(), doPost,e);
			throw new PersionAuthException(e);
		}
	}
    
    
    
    /**
     * 实名服务，手机号3要素  --企业实名
     *
     * @param authEnterpriseParams
     * @return
     * @throws EnterpriseAuthException
     * @throws Exception
     */
    public JSONObject auth(AuthEnterpriseRequest authEnterpriseRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.authEnterprise(authEnterpriseRequest);
            if (result != null) {
                break;
            }

        }
        return result;
    }
    
	/**
	 * 企业实名认证
	 * @param enterprise
	 * @return
	 * @throws EnterpriseAuthException
	 */
	public JSONObject authEnterprise( AuthEnterpriseRequest enterprise ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(enterprise.getUrl(), enterprise.getParams(), enterprise.getHeader());
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new PersionAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("异常错误:{},入参：enterprise={},返回结果：{}",e.getMessage(),enterprise.toString(), doPost,e);
			throw new EnterpriseAuthException(e);
		}
	}
    
    /**
     * 查询银行列表
     *
     * @param authParams 完整路径 从数据库里面查询
     * @return
     * @throws AuthException
     */
    public JSONObject bankList(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privateBankList(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privateBankList( AuthEnterpriseBankRequest authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			 doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), new HashMap<>(0), new HashMap<>(0));
			 if(StringUtils.trimToNull(doPost) != null ) {
				 return JSON.parseObject(doPost);
			 }else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("银行列表查询失败:",e);
			throw new EnterpriseAuthException("银行列表查询失败");
		}
	}
    
    
    /**
     * 查询省/直辖市列表
     *
     * @param authParams 完整路径 从数据库里面查询
     * @return
     * @throws AuthException
     */
    public JSONObject provinceList(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privateProvinceList(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    /**
	 * 
	 * @param authEnterpriseBankRequest
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privateProvinceList( AuthEnterpriseBankRequest authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), new HashMap<>(0), new HashMap<>(0));
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取银行省份信息失败:",e);
			throw new EnterpriseAuthException("获取银行省份信息失败");
		}
	}
    

    /**
     * 查询市/区列表
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject cityList(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privateCityList(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    
	/**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privateCityList( AuthEnterpriseBankRequest authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), authEnterpriseBankRequest.getCityList(), authEnterpriseBankRequest.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取银行城市失败:",e);
			throw new EnterpriseAuthException("获取银行城市失败");
		}
	}

    /**
     * 查询支行列表
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject branchBankList(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privateBranchBankList(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    /**
	 * 
	 * @param authEnterpriseBankRequest
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privateBranchBankList( AuthEnterpriseBankRequest  authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), authEnterpriseBankRequest.getBranchBankList(), authEnterpriseBankRequest.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new EnterpriseAuthException("获取付款银行支行信息失败");
		}
	}
    
    

    /**
     * 企业对公银行账户打款
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject payBank(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privatePayBank(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    
    /**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privatePayBank( AuthEnterpriseBankRequest authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), authEnterpriseBankRequest.getPayBankParams(), authEnterpriseBankRequest.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new EnterpriseAuthException("获取付款银行支行信息失败");
		}
	}

    /**
     * 账户打款查询
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject queryPayBank(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privateQueryPayBank(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    /**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privateQueryPayBank( AuthEnterpriseBankRequest authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), authEnterpriseBankRequest.getQueryAmount(), authEnterpriseBankRequest.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new EnterpriseAuthException("获取付款银行支行信息失败");
		}
	}
    
    
    

    /**
     * 打款金额验证
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject verifyPayBank(AuthEnterpriseBankRequest authEnterpriseBankRequest) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = this.privateVerifyPayBank(authEnterpriseBankRequest);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    /**
	 * 
	 * @param authParams
	 * @return
	 * @throws AuthException
	 */
	private JSONObject privateVerifyPayBank( AuthEnterpriseBankRequest authEnterpriseBankRequest ) throws EnterpriseAuthException {
		String doPost = null;
		try {
			doPost = HttpUtil.doPost(authEnterpriseBankRequest.getUrl(), authEnterpriseBankRequest.getQueryAmount(), authEnterpriseBankRequest.getNullHeaders());
			if(StringUtils.trimToNull(doPost) != null ) {
				return JSON.parseObject(doPost);
			}else {
				throw new EnterpriseAuthException("调用实名服务返回结果为null");
			}
		} catch (Exception e) {
			log.error("获取付款银行支行信息失败:",e);
			throw new EnterpriseAuthException("获取付款银行支行信息失败");
		}
	}
}
