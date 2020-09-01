package com.itrus.common.http;

import cn.com.itrus.atom.sign.api.constants.FSSConstants;
import cn.com.itrus.atom.sign.api.fss.bean.DownloadResponse;
import cn.com.itrus.atom.sign.common.bean.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.request.atom.*;
import com.itrus.common.request.cert.CertApplyRequest;
import com.itrus.common.request.cert.CertUpdateRequest;
import com.itrus.common.request.dgs.*;
import com.itrus.common.request.dsvs.DsvsBatchSignRequest;
import com.itrus.common.request.dsvs.DsvsKeywordCoordinateRequest;
import com.itrus.common.request.dsvs.DsvsSignRequest;
import com.itrus.common.request.dsvs.DsvsVerifyBase64Request;
import com.itrus.common.request.fcs.GenerateThumbnailRequest;
import com.itrus.common.request.fcs.Pdf2pngRequest;
import com.itrus.common.request.fcs.TotalPageRequest;
import com.itrus.common.request.ra.CertConfigRequest;
import com.itrus.common.request.ra.TimeStampRequest;
import com.itrus.common.response.atom.FssDownloadBase64Result;
import com.itrus.common.response.cert.ApplyCertResult;
import com.itrus.common.response.cert.CertUpdateResult;
import com.itrus.common.response.dgs.DgsPdfFillResult;
import com.itrus.common.response.dsvs.DsvsKeywordCoordinatesResult;
import com.itrus.common.response.dsvs.DsvsSignResult;
import com.itrus.common.response.dsvs.DsvsVerifyBase64Result;
import com.itrus.common.response.fcs.GetTotalPagesResult;
import com.itrus.common.response.ra.CertConfigResponse;
import com.itrus.common.response.ra.RaResult;
import com.itrus.common.response.ra.TimeStampResponse;
import org.apache.http.HttpException;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-2-25 12:04:04
 **/
//@Slf4j
@Component
public class CommonRequest {

    @Autowired
    private HttpDTO http;

    @Autowired
    private AtomedApiRequest atomedApiRequest;

    @Autowired
    private SealApiRequest sealApiRequest;

    @Autowired
    private FssApiRequest fssApiRequest;

    @Autowired
    private FcsApiRequest fcsApiRequest;

    @Autowired
    private CertApiRequest certApiRequest;

    @Autowired
    private DsvsApiRequest dsvsApiRequest;

    @Autowired
    private DgsApiRequest dgsApiRequest;

    private Integer okCode = 0;

    /**
     * 是否为合并调用式
     *
     * @return
     * @throws HttpException
     */
    private boolean alled() throws HttpException {
        return http.alled();
    }

    private Object isOk(Result<?> result) throws HttpException {
        Long code = result.getCode();
        if (code != null && code.equals(okCode)) {
            return result.getData();
        }
        throw new HttpException(result.getMsg());
    }

    private Object isOk(RaResult<?> result) throws HttpException {
        Integer code = result.getCode();
        if (code != null && code.equals(okCode)) {
            return result.getData();
        }
        throw new HttpException(result.getMsg());
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
    public String createEllipseSeal(CreateCircularSealRequest kvs) throws Exception {
        String result = null;
        if (alled()) {//合并版
            result = (String) isOk(atomedApiRequest.createEllipseSeal(kvs));
        } else {
            result = (String) isOk(sealApiRequest.createEllipseSeal(kvs));
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
    public String createCircularSeal(CreateCircularSealRequest sealParam) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.createCircularSeal(sealParam));
        } else {
            result = (String) isOk(sealApiRequest.createCircularSeal(sealParam));
        }
        return result;
    }

    /**
     * 创建三角章
     *
     * @param sealParam 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public String createTriangleSeal(CreateCircularSealRequest sealParam) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.createTriangleSeal(sealParam));
        } else {
            result = (String) isOk(sealApiRequest.createTriangleSeal(sealParam));
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
    public String createDoubleRowSeal(CreateDoubleRowSealRequest sealParam) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.createDoubleRowSeal(sealParam));
        } else {
            result = (String) isOk(sealApiRequest.createDoubleRowSeal(sealParam));
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
    public String createSingleRowSeal(CreateSingleRowSealRequest sealParam) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.createSingleRowSeal(sealParam));
        } else {
            result = (String) isOk(sealApiRequest.createSingleRowSeal(sealParam));
        }
        return result;
    }

    /**
     * 印章透明处理
     *
     * @param
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    public String sealLimpid(SealLimpidRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.sealLimpid(obj));
        } else {
            result = (String) isOk(sealApiRequest.sealLimpid(obj));
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
    public String fileDelete(Long fssId) throws Exception {
        Map<String, Object> params = new HashMap<>(1);
        params.put("fssId", fssId);
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.fileDelete(params));
        } else {
            result = (String) isOk(fssApiRequest.fileDelete(params));
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
        Long ffsId = upload(uploadQuery.getBizType(), uploadQuery.getFileName(), uploadQuery.getFileBytes(), uploadQuery.getEncryptionType());
        return ffsId;
    }

    public Long upload(String bizType, String originalFileName, byte[] fileBytes, Integer encryptionType) throws Exception {
        Map<String, Object> cearParam = new HashMap<>();
        cearParam.put("fileBytes", Base64Utils.encodeToString(fileBytes));
        cearParam.put("bizType", bizType);
        cearParam.put("fileName", originalFileName);
        cearParam.put("encryptionType", encryptionType);
        Long fssId = null;
        if (alled()) {

            JSONObject jsonObject = (JSONObject) isOk(atomedApiRequest.uploadBase64(cearParam));
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
//                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
        } else {
            JSONObject jsonObject = (JSONObject) isOk(fssApiRequest.uploadBase64(cearParam));
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
//                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
        }
        return fssId;

    }

    /***
     * 上传文件
     * @param obj 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
     * @return 操作结果
     * @throws Exception
     */
    public Long upload(FssUploadRequest obj) throws Exception {

        if (obj.getOriginalFilename() == null) {
            obj.setOriginalFilename("anonymous.file");
        }
        InputStream inputStream = new ByteArrayInputStream(obj.getFileBytes());
        MultipartFile file = new MockMultipartFile(obj.getFileName(), obj.getOriginalFilename(), ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        Long fssId = null;
        JSONObject jsonObject = null;
        if (alled()) {
            jsonObject = (JSONObject) isOk(atomedApiRequest.upload(file, obj.getBizType(), obj.getEncryptionType()));
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
//                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
        } else {
            jsonObject = (JSONObject) isOk(fssApiRequest.upload(file, obj.getBizType(), obj.getEncryptionType()));
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
//                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
        }
        return fssId;
    }

    /***
     * 下载文件
     * @param fssId 文件存储标识
     * @return 文件内容
     * @throws Exception
     */
    public FssDownloadBase64Result downloadBase64(Long fssId) throws Exception {
        Map<String, Object> params = new HashMap<>(1);
        params.put("fssId", fssId);
        FssDownloadBase64Result result = null;
        if (alled()) {
            result = (FssDownloadBase64Result) isOk(atomedApiRequest.downLoadBase64(params));
        } else {
            result = (FssDownloadBase64Result) isOk(fssApiRequest.downLoadBase64(params));
        }
        return result;
    }


    /**
     * 下载文件
     *
     * @param fssId
     * @return
     * @throws Exception
     */
    public Result<DownloadResponse> download(Long fssId) throws Exception {
        Map<String, Object> params = new HashMap<>(1);
        params.put("fssId", fssId);
        //JSONObject result = null;
        ResponseEntity<?> response = null;
        if (alled()) {
            response = atomedApiRequest.download(params);
        } else {
            response = fssApiRequest.download(params);
        }
        Result<DownloadResponse> re = this.getResultByResponseEntity(response);
        isOk(re);
        return re;
    }

    /**
     * 下载文件FromBase64
     *
     * @param fssId
     * @return
     * @throws Exception
     */
    public Result<DownloadResponse> downloadFile(Long fssId) throws Exception {
        Map<String, Object> params = new HashMap<>(1);
        params.put("fssId", fssId);
        FssDownloadBase64Result result = null;
        if (alled()) {
            result = (FssDownloadBase64Result) isOk(atomedApiRequest.downLoadBase64(params));
        } else {
            result = (FssDownloadBase64Result) isOk(fssApiRequest.downLoadBase64(params));
        }
        DownloadResponse downloaRresponse = new DownloadResponse();
        downloaRresponse.setFileBytes(Base64Utils.decodeFromString(result.getFileBytes()));
        downloaRresponse.setFileName(result.getFileName());
        return Result.createSuccessResult(downloaRresponse);
    }

    private Result<DownloadResponse> getResultByResponseEntity(ResponseEntity<?> response) {
        try {
            HttpHeaders headers = response.getHeaders();
            headers.get(FSSConstants.HEADER_DOWNLOAD_SUCCESS).get(0);
            String downloadSuccess = headers.get(FSSConstants.HEADER_DOWNLOAD_SUCCESS).get(0);
            if ("true".equals(downloadSuccess)) {
                String filename = headers.get("Content-Disposition").get(0);
                if (filename.startsWith("attachment;filename=")) {
                    filename = filename.replace("attachment;filename=", "");
                }
                DownloadResponse downloaRresponse = new DownloadResponse();
                downloaRresponse.setFileBytes((byte[]) response.getBody());
                downloaRresponse.setFileName(filename);
                return Result.createSuccessResult(downloaRresponse);
            } else {
                return JSON.parseObject((String) response.getBody(), new TypeReference<Result<DownloadResponse>>() {
                });
            }
        } catch (Exception e) {
//            log.error("download error", e);
            return Result.createFailResult("下载失败: " + e.getMessage());
        }
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
    /*public Result<DownloadResponse> download(Long fssId) throws Exception {

    	Map<String, Long> request = new Hashtable<>();
		request.put("fssId", fssId);
        Result<DownloadResponse> result = null;
        if (alled()) {
            DownloadResponse downLoadResponse = new DownloadResponse();
            InputStream is = atomedApiRequest.downLoad(fssId);
            byte[] bytes = input2byte(is);
            downLoadResponse.setFileBytes(bytes);
            result = new Result<DownloadResponse>();
            result.setCode(0L);
            result.setData(downLoadResponse);
        } else {
            result = callApiRequest.download(fssId);
        }
        return result;
    }*/

    /*public final byte[] input2byte(InputStream inStream) throws IOException {

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
    }*/

    //-------------------------------------------------------------------------------------------------------------------------
    /**
     * 文档转换服务
     */
    //-------------------------------------------------------------------------------------------------------------------------


    /**
     * word文档转换pdf(支持doc/docx)
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String word2Pdfs(byte[] data) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("file", Base64Utils.encodeToString(data));
        return (String) isOk(fcsApiRequest.word2Pdfs(params));
    }

    /**
     * pdf转png
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String pdf2png(Pdf2pngRequest data) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("file", Base64Utils.encodeToString(data.getData()));
        params.put("scale", data.getScale().toString());
        return (String) isOk(fcsApiRequest.pdf2png(params));
    }

    /**
     * excel文档转换pdf（支持xls/xlsx）
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String excel2Pdfs(byte[] data) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("file", Base64Utils.encodeToString(data));
        return (String) isOk(fcsApiRequest.excel2Pdfs(params));
    }

    /**
     * image文档转换pdf（支持jpeg/jpg/png）
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String image2png(byte[] data) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("file", Base64Utils.encodeToString(data));
        return (String) isOk(fcsApiRequest.image2Pdfs(params));
    }

    /***
     * 生成缩略图
     * @return 操作结果
     * @throws Exception
     */
    public String generateThumbnail(GenerateThumbnailRequest obj) throws Exception {

        return (String) isOk(fcsApiRequest.generateThumbnail(obj.getMultipartFile(), obj.getPages(), obj.getScale(), obj.getDpi()));
    }

    /***
     * 获取文件总页数
     * @return 操作结果
     * @throws Exception
     */
    public GetTotalPagesResult getTotalPages(TotalPageRequest obj) throws Exception {

        return (GetTotalPagesResult) isOk(fcsApiRequest.getTotalPages(obj.getMultipartFile()));
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
    public ApplyCertResult applyCert(CertApplyRequest cert) throws Exception {
        ApplyCertResult result = null;
        if (alled()) {
            result = (ApplyCertResult) isOk(atomedApiRequest.applyCert(cert));
        } else {
            result = (ApplyCertResult) isOk(certApiRequest.applyCert(cert));
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
    public CertUpdateResult updateCert(CertUpdateRequest kvs) throws Exception {
        CertUpdateResult result = null;
        if (alled()) {
            result = (CertUpdateResult) isOk(atomedApiRequest.updateCert(kvs));
        } else {
            result = (CertUpdateResult) isOk(certApiRequest.updateCert(kvs));
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
    public DsvsSignResult sign(DsvsSignRequest kvs) throws Exception {
        DsvsSignResult result = null;
        if (alled()) {
            result = (DsvsSignResult) isOk(atomedApiRequest.sign(kvs));
        } else {
            result = (DsvsSignResult) isOk(dsvsApiRequest.sign(kvs));
        }
        return result;

    }

    /**
     * PDF批量签章
     *
     * @param pdfBatchSign
     * @return
     * @throws Exception
     */
    public DsvsSignResult batchSign(DsvsBatchSignRequest pdfBatchSign) throws Exception {
        DsvsSignResult result = null;
        if (alled()) {
            result = (DsvsSignResult) isOk(atomedApiRequest.batchSign(pdfBatchSign));
        } else {
            result = (DsvsSignResult) isOk(dsvsApiRequest.batchSign(pdfBatchSign));
        }
        return result;
    }

    /**
     * PDF验章
     *
     * @param
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<DsvsVerifyBase64Result> verifyBase64(DsvsVerifyBase64Request obj) throws Exception {
        List<DsvsVerifyBase64Result> result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (alled()) {
                result = (List<DsvsVerifyBase64Result>) isOk(atomedApiRequest.verifyBase64(obj));
            } else {
                result = (List<DsvsVerifyBase64Result>) isOk(dsvsApiRequest.verifyBase64(obj));
            }
        }
        return result;

    }


    /**
     * 获取关键字坐标
     *
     * @param
     * @return
     * @throws Exception
     */
    public DsvsKeywordCoordinatesResult getKeywordCoordinates(DsvsKeywordCoordinateRequest obj) throws Exception {
        DsvsKeywordCoordinatesResult result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (alled()) {
                result = (DsvsKeywordCoordinatesResult) isOk(atomedApiRequest.getKeywordCoordinates(obj));
            } else {
                result = (DsvsKeywordCoordinatesResult) isOk(dsvsApiRequest.getKeywordCoordinates(obj));
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
     * PDF模板填充
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public DgsPdfFillResult pdfFill(DgsPdfFillRequest kvs) throws Exception {
        DgsPdfFillResult result = null;
        if (alled()) {
            result = (DgsPdfFillResult) isOk(atomedApiRequest.pdfFill(kvs));
        } else {
            result = (DgsPdfFillResult) isOk(dgsApiRequest.pdfFill(kvs));
        }
        return result;

    }

    /**
     * PDF模板创建
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public String pdfCreate(DgsPdfCreateRequest kvs) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.pdfCreate(kvs));
        } else {
            result = (String) isOk(dgsApiRequest.pdfCreate(kvs));
        }
        return result;

    }

    /**
     * 添加文本水印服务
     *
     * @param pdfTextMarkParams
     * @return
     * @throws Exception
     */
    public String pdfTextMark(DgsPdfTextMarkRequest pdfTextMarkParams) throws Exception {

        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.pdfTextMark(pdfTextMarkParams));
        } else {
            result = (String) isOk(dgsApiRequest.pdfTextMark(pdfTextMarkParams));
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
    public String pdfImageMark(DgsPdfImageMarkRequest pdfImageMarkParams) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.pdfImageMark(pdfImageMarkParams));
        } else {
            result = (String) isOk(dgsApiRequest.pdfImageMark(pdfImageMarkParams));
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
    public String pdfQrCodeMark(DgsPdfQrCodeMarkRequest pdfQrCodeMarkParams) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams));
        } else {
            result = (String) isOk(dgsApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams));
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
    public String pdfTextAndQrCodeMark(DgsPdfTextAndQrCodeMarkRequest pdfTextAndQrCodeMarkParams) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams));
        } else {
            result = (String) isOk(dgsApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams));
        }
        return result;
    }

    /**
     * 新建RA证书配置
     *
     * @param obj
     * @return
     */
    public String RaAdd(CertConfigRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.RaAdd(obj));
        } else {
            result = (String) isOk(certApiRequest.RaAdd(obj));
        }
        return result;
    }

    /**
     * 查询RA证书配置
     *
     * @param raCode
     * @return
     */
    public CertConfigResponse GetByRaCode(String raCode) throws Exception {
        CertConfigResponse result = null;
        if (alled()) {
            result = (CertConfigResponse) isOk(atomedApiRequest.GetByRaCode(raCode));
        } else {
            result = (CertConfigResponse) isOk(certApiRequest.GetByRaCode(raCode));
        }
        return result;
    }

    /**
     * 更新RA证书配置
     *
     * @param obj
     * @return
     */
    public String RaUpdate(CertConfigRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.RaUpdate(obj));
        } else {
            result = (String) isOk(certApiRequest.RaUpdate(obj));
        }
        return result;
    }

    /**
     * 根据唯一标识删除区块链服务配置
     *
     * @param raCode
     * @return
     */
    public String RaDelete(String raCode) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.RaDelete(raCode));
        } else {
            result = (String) isOk(certApiRequest.RaDelete(raCode));
        }
        return result;
    }

    /**
     * 查询区块链服务配置列表
     *
     * @param enterpriseId 必选 企业唯一标识
     * @param productId    可选 产品唯一标识
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<CertConfigResponse> RaGetList(String enterpriseId, String productId) throws Exception {
        List<CertConfigResponse> result = null;
        if (alled()) {
            result = (List<CertConfigResponse>) isOk(atomedApiRequest.RaGetList(enterpriseId, productId));
        } else {
            result = (List<CertConfigResponse>) isOk(certApiRequest.RaGetList(enterpriseId, productId));
        }
        return result;
    }

    /**
     * 新增时间戳配置
     *
     * @param obj
     * @return
     */
    public String tsaAdd(TimeStampRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.tsaAdd(obj));
        } else {
            result = (String) isOk(certApiRequest.tsaAdd(obj));
        }
        return result;
    }

    /**
     * 根据企业唯一标识查询时间戳配置详情，只返回最后一次添加的一条
     *
     * @param enterpriseId 必填 企业唯一标识
     * @param productId    可选 产品唯一标识
     * @return
     */
    public TimeStampResponse tsaGetTsaConfig(String enterpriseId, String productId) throws Exception {
        TimeStampResponse result = null;
        if (alled()) {
            result = (TimeStampResponse) isOk(atomedApiRequest.tsaGetTsaConfig(enterpriseId, productId));
        } else {
            result = (TimeStampResponse) isOk(certApiRequest.tsaGetTsaConfig(enterpriseId, productId));
        }
        return result;
    }


    /**
     * 根据tsaCode查询时间戳配置是否已存在
     *
     * @param tsaCode 必选 时间戳代码
     * @return
     */

    public TimeStampResponse tsaGetByTsaCode(String tsaCode) throws Exception {

        TimeStampResponse result = null;
        if (alled()) {
            result = (TimeStampResponse) isOk(atomedApiRequest.tsaGetByTsaCode(tsaCode));
        } else {
            result = (TimeStampResponse) isOk(certApiRequest.tsaGetByTsaCode(tsaCode));
        }
        return result;

    }

    /**
     * 根据tsaCode更新时间戳配置
     *
     * @param obj
     * @return
     */
    public String tsaUpdate(TimeStampRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.tsaUpdate(obj));
        } else {
            result = (String) isOk(certApiRequest.tsaUpdate(obj));
        }
        return result;
    }

    /**
     * 根据tsaCode删除时间戳服务配置
     *
     * @param tsaCode 必填 时间戳代码
     * @return
     */
    public String tsaDelete(String tsaCode) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) isOk(atomedApiRequest.tsaDelete(tsaCode));
        } else {
            result = (String) isOk(certApiRequest.tsaDelete(tsaCode));
        }
        return result;
    }
}
