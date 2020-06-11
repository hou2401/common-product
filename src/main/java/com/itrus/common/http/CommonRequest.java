package com.itrus.common.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.exception.AuthException;
import com.itrus.common.exception.EnterpriseAuthException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.params.AuthEnterpriseParams;
import com.itrus.common.params.AuthParams;
import com.itrus.common.params.AuthPersionParams;
import com.itrus.common.params.AuthPersionVideoParams;
import com.itrus.common.params.CertParams;
import com.itrus.common.params.PdfImageMarkParams;
import com.itrus.common.params.PdfQrCodeMarkParams;
import com.itrus.common.params.PdfTextAndQrCodeMarkParams;
import com.itrus.common.params.PdfTextMarkParams;
import com.itrus.common.params.UploadParams;

import cn.com.itrus.atom.sign.api.fss.bean.DownloadResponse;
import cn.com.itrus.atom.sign.api.fss.bean.UploadResponse;
import cn.com.itrus.atom.sign.api.seal.bean.SealParam;
import cn.com.itrus.atom.sign.common.bean.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-2-25 12:04:04
 **/
@Slf4j
@Component
public class CommonRequest {

    @Autowired
    private HttpDTO http;

    @Autowired
    private HttpRequset httpRequset;

    @Autowired
    private CallApiRequest callApiRequest;

    /**
     *	 公共请求对象
     *
     * @return 返回实例
     */
	/*public static CommonRequest getInstance() {
        return REQUEST;
    }*/

    /**
     * 是否是http调用模式
     *
     * @return
     * @throws HttpException
     */
    private boolean httped() throws HttpException {
        return http.httped();
    }

    /**
     * 请求是否OK
     *
     * @param object json对象
     */
    public boolean isOk(JSONObject object) {
        if (object != null && (object.get("code") != null || object.get("status") != null)) {
            return object.getIntValue("code") == 0 || object.getIntValue("status") == 1;

        }
        return false;

    }

    /**
     * 获取请求消息
     *
     * @param object json对象
     */
    public String getMsg(JSONObject object) {
        return object.getString("msg") == null ? object.getString("message") : object.getString("msg");
    }

    /**
     * 获取请求消息
     *
     * @param object json对象
     */
    public int getCode(JSONObject object) {
        return object.getIntValue("code");
    }


    /**
     * 获取请求消息
     *
     * @param object json对象
     * @return
     */
    public JSONObject getData(JSONObject object) {
        if (object == null) {
            return null;
        }
        return (JSONObject) object.get("data");
    }

    /**
     *
     * 印章服务
     *
     */
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * 创建椭圆印章
     *
     * @param kvs 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject createEllipseSeal(Object kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.createEllipseSeal(kvs);
            } else {
                result = callApiRequest.createEllipseSeal(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 创建圆形印章
     *
     * @param sealParam 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject createCircularSeal(SealParam sealParam) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.createCircularSeal(sealParam);
            } else {
                result = callApiRequest.createCircularSeal(sealParam);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 创建双行人名印章
     *
     * @param sealParam 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject createDoubleRowSeal(SealParam sealParam) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                throw new Exception("http 方法还未实现");
            } else {

                result = callApiRequest.createDoubleRowSeal(sealParam);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 创建单行人名印章
     *
     * @param sealParam 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject createSingleRowSeal(SealParam sealParam) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                throw new Exception("http 方法还未实现");
            } else {
                result = callApiRequest.createSingleRowSeal(sealParam);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 印章透明处理
     *
     * @param kvs 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject sealLimpid(Object kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                throw new Exception("http 方法还未实现");
            } else {

                result = callApiRequest.sealLimpid(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * 文件存储服务
     * @throws Exception
     */
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * 文件删除服务
     *
     * @param
     * @return
     * @throws Exception
     */
    public JSONObject fileDelete(Long fssId) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                return httpRequset.fileDelete(fssId);
            } else {
                result = callApiRequest.fileDelete(fssId);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 文件上传
     *
     * @param uploadQuery
     * @return
     * @throws Exception
     */
    public Long upload(UploadParams uploadQuery) throws Exception {
        //log.info("upload is uploadQuery = {}",uploadQuery.toString());
        Long ffsId = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            ffsId = upload(uploadQuery.getBizType(), uploadQuery.getFileName(), uploadQuery.getFileBytes(), uploadQuery.getEncryptionType());
            if (ffsId != null) {
                break;
            }
        }
        return ffsId;
    }

    public Long upload(String bizType, String originalFileName, byte[] fileBytes, Integer encryptionType) throws Exception {
        Long fssId = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                Map<String, Object> cearParam = new HashMap<>();
                cearParam.put("fileBytes", Base64Utils.encodeToString(fileBytes));
                cearParam.put("bizType", bizType);
                cearParam.put("fileName", originalFileName);
                cearParam.put("encryptionType", encryptionType);
                JSONObject uploadBase64 = httpRequset.uploadBase64(cearParam);
                String jsonData = uploadBase64.getString("data");
                JSONObject jsondata = JSON.parseObject(jsonData);
                fssId = jsondata.getLong("fssId");
                return fssId;
            }
            JSONObject jsonObject = callApiRequest.uploadBase64(fileBytes, bizType, originalFileName, encryptionType);
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
            if (fssId != null) {
                break;
            }
        }
        return fssId;

    }

    /***
     * 上传文件
     * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
     * @param file 文件
     * @return 操作结果
     * @throws Exception
     */
    public Result<UploadResponse> upload(String bizType, File file, Integer encryptionType) throws Exception {
        Result<UploadResponse> result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                throw new Exception("http 方法还未实现");
            } else {
                result = callApiRequest.upload(bizType, file, encryptionType);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /***
     * 下载文件
     * @param fssId 文件存储标识
     * @return 文件内容
     * @throws Exception
     */
    public JSONObject downloadBase64(Long fssId) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.downLoadBase64(fssId);
            } else {
                result = callApiRequest.downloadBase64(fssId);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }


    /**
     * 文件流下载接口
     * /**
     * http 下载文件 返回流
     *
     * @param fssId
     * @return
     * @throws Exception
     */
    public Result<DownloadResponse> download(Long fssId) throws Exception {

        Result<DownloadResponse> result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                DownloadResponse downLoadResponse = new DownloadResponse();
                InputStream is = httpRequset.downLoad(fssId);
                byte[] bytes = input2byte(is);
                downLoadResponse.setFileBytes(bytes);
                result = new Result<DownloadResponse>();
                result.setCode(0L);
                result.setData(downLoadResponse);
            } else {
                result = callApiRequest.download(fssId);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    public final byte[] input2byte(InputStream inStream) throws IOException {

        byte[] in2b = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = inStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            in2b = swapStream.toByteArray();
            if (in2b != null && in2b.length != 0) {
                break;
            }
        }
        return in2b;
    }

    /**
     * word文档转换pdf(支持doc/docx)
     *
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject word2Pdfs(byte[] data) throws Exception {

        return callApiRequest.word2Pdfs(data);
    }

	/**
	 * excel文档转换pdf（支持xls/xlsx）
	 * @param data
	 * @return
	 * @throws Exception
	 */
    public JSONObject excel2Pdfs(byte[] data) throws Exception {
        return callApiRequest.excel2Pdfs(data);
    }

	/**
	 * image文档转换pdf（支持jpeg/jpg/png）
	 * @param data
	 * @return
	 * @throws Exception
	 */
    public JSONObject image2png(byte[] data) throws Exception {
        return callApiRequest.image2Pdfs(data);
    }


    public JSONObject pdf2png(byte[] data) throws Exception {
        return callApiRequest.pdf2png(data);
    }


    //-------------------------------------------------------------------------------------------------------------------------
    /**
     * 证书服务
     */
    //-------------------------------------------------------------------------------------------------------------------------

    /**
     * 申请证书
     *
     * @param cert 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject applyCert(CertParams cert) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.applyCert(cert);
            } else {
                result = callApiRequest.applyCert(cert);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * 更新证书
     *
     * @param kvs 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public JSONObject updateCert(Object kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.updateCert(kvs);
            } else {
                result = callApiRequest.updateCert(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }
    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 文档生成服务
     */
    //-----------------------------------------------------------------------------------------------------------------------


    /**
     * PDF签章
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public JSONObject pdfFill(Map kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.pdfFill(kvs);
            } else {
                result = callApiRequest.pdfFill(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }


    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 签章验章服务
     */
    //-----------------------------------------------------------------------------------------------------------------------

    /**
     * PDF签章
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public JSONObject sign(Object kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.sign(kvs);
            } else {
                result = callApiRequest.sign(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * PDF签章
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public JSONObject signMap(Map kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.sign(kvs);
            } else {
                result = callApiRequest.signMap(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;

    }

    /**
     * PDF批量签章
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public JSONObject batchSign(Object kvs) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                throw new Exception("http 方法还未实现");
            } else {
                result = callApiRequest.batchSign(kvs);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 实名服务
     */
    //-----------------------------------------------------------------------------------------------------------------------


    /**
     * 实名服务，2要素/手机号3要素/银行卡3、4要素 --个人实名
     *
     * @param authPersionParams
     * @return
     * @throws PersionAuthException
     * @throws Exception
     */
    public JSONObject auth(AuthPersionParams authPersionParams) throws PersionAuthException {

        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.authPersion(authPersionParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 实名服务 video h5，静默，数读接口
     *
     * @param authPersionVideoParams
     * @return
     * @throws PersionAuthException
     * @throws Exception
     */
    public JSONObject auth(AuthPersionVideoParams authPersionVideoParams) throws PersionAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.authPersionVideo(authPersionVideoParams);
            if (result != null) {
                break;
            }

        }
        return result;
    }

    /**
     * 实名服务，手机号3要素  --企业实名
     *
     * @param authEnterpriseParams
     * @return
     * @throws EnterpriseAuthException
     * @throws Exception
     */
    public JSONObject auth(AuthEnterpriseParams authEnterpriseParams) throws EnterpriseAuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.authEnterprise(authEnterpriseParams);
            if (result != null) {
                break;
            }

        }
        return result;
    }

    /**
     * 查询银行列表
     *
     * @param url 完整路径 从数据库里面查询
     * @return
     * @throws AuthException
     */
    public JSONObject bankList(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.bankList(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 查询省/直辖市列表
     *
     * @param url 完整路径 从数据库里面查询
     * @return
     * @throws AuthException
     */
    public JSONObject provinceList(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.provinceList(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 查询市/区列表
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject cityList(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.cityList(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 查询支行列表
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject branchBankList(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.branchBankList(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 企业对公银行账户打款
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject payBank(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.payBank(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 账户打款查询
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject queryPayBank(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.queryPayBank(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 打款金额验证
     *
     * @param authParams
     * @return
     * @throws AuthException
     */
    public JSONObject verifyPayBank(AuthParams authParams) throws AuthException {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            result = httpRequset.verifyPayBank(authParams);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 添加水印服务
     */
    //-----------------------------------------------------------------------------------------------------------------------


    /**
     * 添加文本水印服务
     *
     * @param pdfTextMarkParams
     * @return
     * @throws Exception
     */
    public JSONObject pdfTextMarkParams(PdfTextMarkParams pdfTextMarkParams) throws Exception {

        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.pdfTextMark(pdfTextMarkParams);
            } else {
                result = callApiRequest.pdfTextMark(pdfTextMarkParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 添加图片水印服务
     *
     * @param pdfImageMarkParams
     * @return
     * @throws Exception
     */
    public JSONObject pdfImageMarkParams(PdfImageMarkParams pdfImageMarkParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.pdfImageMark(pdfImageMarkParams);
            } else {
                result = callApiRequest.pdfImageMark(pdfImageMarkParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 添加二维码水印服务
     *
     * @param pdfQrCodeMarkParams
     * @return
     * @throws Exception
     */
    public JSONObject pdfQrCodeMarkParams(PdfQrCodeMarkParams pdfQrCodeMarkParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.pdfQrCodeMark(pdfQrCodeMarkParams);
            } else {
                result = callApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * 添加文本和二维码水印服务
     *
     * @param pdfTextAndQrCodeMarkParams
     * @return
     * @throws Exception
     */
    public JSONObject pdfTextAndQrCodeMarkParams(PdfTextAndQrCodeMarkParams pdfTextAndQrCodeMarkParams) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (httped()) {
                result = httpRequset.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams);
            } else {
                result = callApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }

}
