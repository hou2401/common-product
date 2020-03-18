package com.itrus.common.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.exception.SmsException;
import com.itrus.common.params.ServiceParams;
import com.itrus.common.params.SmsParams;
import com.itrus.common.utils.HMACSHA1;
import com.itrus.common.utils.HttpTools;
import com.itrus.common.utils.HttpTools.HttpData;
import com.itrus.common.utils.HttpUtil;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 发送短信工具类
 * @author wgx52
 *
 */
@Data
@ToString
@Slf4j
@Component
public class SmsRequest{

	/**
	 * i信短信授权
	 */
	public static final String IXIN_AUTH_HMAC = "authHmac";

	/**
	 * 手机号
	 */
	public static final String IXIN_MPHONE = "mphone";

	private static final String IXIN_APP_ID = "appid";

	/**
	 * 内容
	 */
	public static final String IXIN_CONTENT = "content";

	public static final String PHONE = "phone";
	/**
	 * 天威云使用短信签名
	 */
	public static final String AUTOGRAPH = "autograph";


	/**
	 * 应用id
	 */
	private String appId;

	/**
	 * 应用密钥
	 */
	private String secretKey;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 产品code
	 */
	private String serviceCode;

	/**
	 * 短信签名
	 */
	private String autograph;

	/**
	 * 短信内容
	 */
	private String content;

	/**
	 * 是否采用天威云的方式发送短信
	 * 默认采用天威云的方式发送短信
	 */
	private boolean sendTwy = true;




	/**
	 * 发送短信
	 * @throws SmsException 
	 */
	public void send(String url) throws SmsException{

		if( serviceCode == null ){
			sendOld(url);
			//			send(url, false);
		}else{
			send(url, true);
		}

	}



	private void sendOld(String url) throws SmsException {
		try {
			//拼接签名
			content = StringUtils.trimToEmpty( autograph )+ content;
			final Map<String, Object> params = new HashMap<>();
			params.put(IXIN_APP_ID, appId);
			params.put(IXIN_MPHONE, phone);
			params.put(IXIN_CONTENT, content);
			final Map<String, String> header = new HashMap<>();
			header.put(IXIN_AUTH_HMAC, Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(appId + content + phone, secretKey)));
			
			log.debug("url=={}",url);
			log.debug("短信参数params=={}",JSON.toJSONString(params));
			log.debug("短信参数header=={}",JSON.toJSONString(header));
			
			String doPost = HttpUtil.doPost(url,params,header);
			log.debug("doPost == {}",doPost);
			if( !StringUtils.isEmpty(doPost) ){
				JSONObject jsonObject = JSON.parseObject(doPost);
				Integer retCode = jsonObject.getInteger("retCode");
				if (!Objects.equals(retCode, 1000)) {
					// TODO:出证申请失败处理
					throw new SmsException("code="+retCode+":message="+jsonObject.get("retMsg"));
				} 
			}else{
				log.error("doPost="+doPost);
				throw new SmsException("发送短信错误");
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new SmsException(e.getMessage());
		}
	}



	/**
	 * 发送短信
	 * @throws SmsException 
	 */
	public void send(String url, boolean sendTwy) throws SmsException{
		try {
			HttpData data = null;
			if(sendTwy){
				data = getTwyData();
			}else{
				data = getIxinData();
			}
			
			log.info("url=={}",url);
			log.info("短信参数=={}",JSON.toJSONString(data));
			
			HttpTools.ResponseEntity responseEntity = HttpTools.post(url, data);
			if (responseEntity.isOk()) {
				log.info(responseEntity.getContent());
				JSONObject jsonObject = JSON.parseObject(responseEntity.getContent());

				if( sendTwy ){
					Integer status = jsonObject.getInteger("status");
					if (!Objects.equals(status, 1)) {
						// TODO:出证申请失败处理
						throw new SmsException("status="+status+"message="+jsonObject.get("message"));
					} 
					// TODO:出证申请成功处理
				}else{

					Integer retCode = jsonObject.getInteger("retCode");
					if (!Objects.equals(retCode, 1000)) {
						// TODO:出证申请失败处理
						throw new SmsException("retCode="+retCode+"retMsg="+jsonObject.get("retMsg"));
					} 
					// TODO:出证申请成功处理
				}

			} else {
				// TODO：Http调用失败处理
				log.info(responseEntity.getMessage());
				throw new SmsException(responseEntity.getMessage());
			}
		} catch (SmsException | IOException e) {
			log.error(e.getMessage(),e);
			throw new SmsException("发送短信错误");
		}
	}

	/**
	 * 计算i信 httpData
	 * @return
	 * @throws SmsException
	 */
	private HttpData getIxinData() throws SmsException {
		HttpData data = HttpData.instance()
				.addHeader(IXIN_AUTH_HMAC, getIxinSignature())
				.addHeader(ServiceParams.CONTEXT_TYPE, ServiceParams.CONTEXT_TYPE_JSON)
				.setPostEntity(new ByteArrayEntity(JSON.toJSONBytes(getIxinParams())));
		return data;
	}

	/**
	 * 计算天威云 httpData
	 * @return
	 * @throws SmsException
	 */
	private HttpData getTwyData() throws SmsException{
		HttpData data = HttpData.instance()
				.addHeader(ServiceParams.CONTENT_SIGNATURE, getTwySignature())
				.addHeader(ServiceParams.CONTEXT_TYPE, ServiceParams.CONTEXT_TYPE_JSON)
				.addHeader(ServiceParams.APP_ID, appId )
				.addHeader(ServiceParams.SERVICE_CODE, serviceCode)
				.setPostEntity(new ByteArrayEntity(JSON.toJSONBytes(getTwyParams())));
		return data;
	}

	/**
	 * i信计算header密钥
	 * @return
	 * @throws SmsException 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	private String getIxinSignature() throws SmsException{
		try {
			return Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(appId + content + phone, secretKey));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error(e.getMessage(),e);
			throw new SmsException("发送I信短信计算签名异常");
		}
	}

	private Map<String,String> getIxinParams() throws SmsException{
		Map<String, String> params = new TreeMap<>();
		params.put(IXIN_APP_ID, appId);
		params.put(IXIN_MPHONE, phone);
		params.put(IXIN_CONTENT, content);
		return params;
	}

	/**
	 * 天威云签名
	 * @return
	 * @throws SmsException
	 */
	private String getTwySignature() throws SmsException{
		try {
			return ServiceParams.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(getByterequest(), secretKey + serviceCode));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error(e.getMessage(),e);
			throw new SmsException("发送天威云短信计算签名异常");
		}
	}

	private byte[] getByterequest(){
		return JSON.toJSONBytes(getTwyParams());
	}
	/**
	 * 天威云参数
	 * @return
	 */
	private Map<String,String> getTwyParams(){
		Map<String, String> params = new HashMap<>();
		params.put(PHONE, phone);
		params.put(IXIN_CONTENT, content);
		params.put(AUTOGRAPH,autograph);
		return params;
	}



	public SmsRequest(SmsParams sms) {
		super();
		this.appId = sms.getAppId();
		this.secretKey = sms.getSecretKey();
		this.serviceCode = sms.getServiceCode();
		this.phone = sms.getAccount();
		this.autograph = sms.getSignature();
		this.content = sms.getContent();
	}



	public SmsRequest() {
		super();
	}

	@SuppressWarnings("unused")
	private static void testOldIxin() throws Exception {
		String content ="您好：您的验证码为：CODE。";
		String appId = "e7a765ff2a2b46";
		String secretKey = "ab6b33ae9a6f49cb8e6dba4d0520a157";
		String mPhone = "15010491957";
		/*final Map<String, Object> params = new HashMap<>();
		params.put("appid", appId);
		params.put("mphone", mPhone);
		params.put("content", content);
		final Map<String, String> header = new HashMap<>();
		header.put("authHmac", Base64.encode(HMACSHA1.getHmacSHA1(appId + content + mPhone, secretKey), false));
		String doPost = HttpUtil.doPost("http://124.205.224.179:9018/portal/sms/send",params,header);
		System.out.println(doPost);
		 */



		String url = "http://124.205.224.179:9018/portal/sms/send";
		String mphone = mPhone;
		//		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		/*Map<String, Object> map = new HashMap<>();
		map.put("appid", appId);
		map.put("mphone", mphone);
		map.put("content", content);*/

		final Map<String, Object> params = new HashMap<>();
		params.put("appid", appId);
		params.put(IXIN_MPHONE, mphone);
		params.put(IXIN_CONTENT, content);
		final Map<String, String> header = new HashMap<>();
		header.put(IXIN_AUTH_HMAC, Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(appId + content + mphone, secretKey)));
		String doPost = HttpUtil.doPost(url,params,header);
		System.out.println(doPost);
	}



	@SuppressWarnings("unused")
	private static void testTwy() throws SmsException {
		String content ="您好：您的验证码为：CODE。";
		String appId = "e7a765ff2a2b46";
		String secretKey = "ab6b33ae9a6f49cb8e6dba4d0520a157";
		String phone = "15010491957";
		String autograph = "【天威诚信】";
		String serviceCode = "msg0001";

		SmsRequest smsUtil = new SmsRequest();
		smsUtil.setAppId(appId);
		smsUtil.setSecretKey(secretKey);
		smsUtil.setPhone(phone);
		smsUtil.setAutograph(autograph);
		smsUtil.setServiceCode(serviceCode);
		smsUtil.setContent(content);
		smsUtil.send("http://demo-open.itruscloud.com/apigate/smsService/sendingSms");

		System.out.println( "发送成功");
	}



	@SuppressWarnings("unused")
	private static void testIxin() throws SmsException{

		String content ="【天威诚信】您好：您的验证码为：CODE。";
		String appId = "ecea8764614149";
		String secretKey = "19d2a7192b604f29aa9ebfc319ba24b0";
		String phone = "15010491957";

		SmsRequest smsUtil = new SmsRequest();
		smsUtil.setAppId(appId);
		smsUtil.setSecretKey(secretKey);
		smsUtil.setPhone(phone);
		//		smsUtil.setAutograph(autograph);
		//		smsUtil.setServiceCode(serviceCode);
		smsUtil.setContent(content);
		smsUtil.send("http://124.205.224.179:9018/portal/sms/send");
	}

	/*public static void main(String[] args) throws Exception {

//		testIxin();
		//		testOldIxin();
				testTwy();
	}*/
}
