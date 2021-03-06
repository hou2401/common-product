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
import com.itrus.common.response.atom.FssUploadBase64Result;
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
import com.itrus.common.result.uag.response.RaGetListResult;
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
 * ??????????????????????????????
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

    private Long okCode = 0L;
    /**
     * ????????????????????????
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


    /**
     *
     * ????????????
     *
     */
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * ??????????????????
     *
     * @param kvs ????????????
     * @return ??????????????????
     * @throws Exception ????????????
     */
    public String createEllipseSeal(CreateCircularSealRequest kvs) throws Exception {
        String result = null;
        if (alled()) {//?????????
            result = (String) isOk(atomedApiRequest.createEllipseSeal(kvs));
        } else {
            result = (String) isOk(sealApiRequest.createEllipseSeal(kvs));
        }
        return result;
    }

    /**
     * ??????????????????
     *
     * @param sealParam ????????????
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ???????????????
     *
     * @param sealParam ????????????
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ????????????????????????
     *
     * @param sealParam ????????????
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ????????????????????????
     *
     * @param sealParam ????????????
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ??????????????????
     *
     * @param
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ??????????????????
     * @throws Exception
     */
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * ??????????????????
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
     * ????????????
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

            FssUploadBase64Result ok = (FssUploadBase64Result) isOk(atomedApiRequest.uploadBase64(cearParam));
            if (ok != null) {
//                log.error("?????????????????????????????????????????????" + jsonObject.getString("msg"));
                return ok.getFssId();
            }
        } else {
            FssUploadBase64Result ok = (FssUploadBase64Result)  isOk(fssApiRequest.uploadBase64(cearParam));
            if (ok != null) {
//               log.error("?????????????????????????????????????????????" + jsonObject.getString("msg"));
                return ok.getFssId();
            }
        }
        return fssId;

    }

    /***
     * ????????????
     * @param obj ??????????????????????????????[0-9a-zA-Z_-]*??????????????????20?????????
     * @return ????????????
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
//                    log.error("?????????????????????????????????????????????" + jsonObject.getString("msg"));
                    return null;
                }
            }
        } else {
            jsonObject = (JSONObject) isOk(fssApiRequest.upload(file, obj.getBizType(), obj.getEncryptionType()));
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
//                    log.error("?????????????????????????????????????????????" + jsonObject.getString("msg"));
                    return null;
                }
            }
        }
        return fssId;
    }

    /***
     * ????????????
     * @param fssId ??????????????????
     * @return ????????????
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
     * ????????????
     *
     * @param fssId
     * @return
     * @throws Exception
     */
    public Result<DownloadResponse> downloadFile(Long fssId) throws Exception {
        Map<String, Object> params = new HashMap<>(1);
        params.put("fssId", fssId);
        ResponseEntity<byte[]> response = null;
        if (alled()) {
            response = atomedApiRequest.download(params);
        } else {
            response = fssApiRequest.download(params);
        }
        Result<DownloadResponse> re = this.getResultByResponseEntity(response);
        return re;
    }

    /**
     * ????????????FromBase64
     *
     * @param fssId
     * @return
     * @throws Exception
     */
    public Result<DownloadResponse> download(Long fssId) throws Exception {
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

    private Result<DownloadResponse> getResultByResponseEntity(ResponseEntity<byte[]> response) {
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
                return JSON.parseObject(new String(response.getBody()), new TypeReference<Result<DownloadResponse>>() {});
            }
        } catch (Exception e) {
//            log.error("download error", e);
            return Result.createFailResult("????????????: " + e.getMessage());
        }
    }

    /**
     * ?????????????????????
     * /**
     * http ???????????? ?????????
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
     * ??????????????????
     */
    //-------------------------------------------------------------------------------------------------------------------------


    /**
     * word????????????pdf(??????doc/docx)
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
     * pdf???png
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
     * excel????????????pdf?????????xls/xlsx???
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
     * image????????????pdf?????????jpeg/jpg/png???
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
     * ???????????????
     * @return ????????????
     * @throws Exception
     */
    public String generateThumbnail(GenerateThumbnailRequest obj) throws Exception {

        return (String) isOk(fcsApiRequest.generateThumbnail(obj.getMultipartFile(), obj.getPages(), obj.getScale(), obj.getDpi()));
    }

    /***
     * ?????????????????????
     * @return ????????????
     * @throws Exception
     */
    public GetTotalPagesResult getTotalPages(TotalPageRequest obj) throws Exception {

        return (GetTotalPagesResult) isOk(fcsApiRequest.getTotalPages(obj.getMultipartFile()));
    }


    //-------------------------------------------------------------------------------------------------------------------------
    /**
     * ????????????
     */
    //-------------------------------------------------------------------------------------------------------------------------

    /**
     * ????????????
     *
     * @param cert ????????????
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ????????????
     *
     * @param kvs ????????????
     * @return ??????????????????
     * @throws Exception ????????????
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
     * ??????????????????
     */
    //-----------------------------------------------------------------------------------------------------------------------

    /**
     * PDF??????
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
     * PDF????????????
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
     * PDF??????
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
     * ?????????????????????
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
     * ??????????????????
     */
    //-----------------------------------------------------------------------------------------------------------------------


    /**
     * PDF????????????
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
     * PDF????????????
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
     * ????????????????????????
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
     * ????????????????????????
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
     * ???????????????????????????
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
     * ????????????????????????????????????
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
     * ??????RA????????????
     *
     * @param obj
     * @return
     */
    public String RaAdd(CertConfigRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) RaResult.isOk(atomedApiRequest.RaAdd(obj));
        } else {
            result = (String) RaResult.isOk(certApiRequest.RaAdd(obj));
        }
        return result;
    }

    /**
     * ??????RA????????????
     *
     * @param raCode
     * @return
     */
    public CertConfigResponse GetByRaCode(String raCode) throws Exception {
        CertConfigResponse result = null;
        if (alled()) {
            result = (CertConfigResponse) RaResult.isOk(atomedApiRequest.GetByRaCode(raCode));
        } else {
            result = (CertConfigResponse) RaResult.isOk(certApiRequest.GetByRaCode(raCode));
        }
        return result;
    }

    /**
     * ??????RA????????????
     *
     * @param obj
     * @return
     */
    public String RaUpdate(CertConfigRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) RaResult.isOk(atomedApiRequest.RaUpdate(obj));
        } else {
            result = (String) RaResult.isOk(certApiRequest.RaUpdate(obj));
        }
        return result;
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @param raCode
     * @return
     */
    public String RaDelete(String raCode) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) RaResult.isOk(atomedApiRequest.RaDelete(raCode));
        } else {
            result = (String) RaResult.isOk(certApiRequest.RaDelete(raCode));
        }
        return result;
    }

    /**
     * ?????????????????????????????????
     *
     * @param enterpriseId ?????? ??????????????????
     * @param productId    ?????? ??????????????????
     * @return
     */
	public RaGetListResult RaGetList(String enterpriseId, String productId) throws Exception {
        RaGetListResult result = null;
        if (alled()) {
            result = (RaGetListResult) RaResult.isOk(atomedApiRequest.RaGetList(enterpriseId, productId));
        } else {
            result = (RaGetListResult) RaResult.isOk(certApiRequest.RaGetList(enterpriseId, productId));
        }
        return result;
    }

    /**
     * ?????????????????????
     *
     * @param obj
     * @return
     */
    public String tsaAdd(TimeStampRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) RaResult.isOk(atomedApiRequest.tsaAdd(obj));
        } else {
            result = (String) RaResult.isOk(certApiRequest.tsaAdd(obj));
        }
        return result;
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????????????????
     *
     * @param enterpriseId ?????? ??????????????????
     * @param productId    ?????? ??????????????????
     * @return
     */
    public TimeStampRequest tsaGetTsaConfig(String enterpriseId, String productId) throws Exception {
        TimeStampRequest result = null;
        if (alled()) {
            result = (TimeStampRequest) RaResult.isOk(atomedApiRequest.tsaGetTsaConfig(enterpriseId, productId));
        } else {
            result = (TimeStampRequest) RaResult.isOk(certApiRequest.tsaGetTsaConfig(enterpriseId, productId));
        }
        return result;
    }


    /**
     * ??????tsaCode????????????????????????????????????
     *
     * @param tsaCode ?????? ???????????????
     * @return
     */

    public TimeStampResponse tsaGetByTsaCode(String tsaCode) throws Exception {

        TimeStampResponse result = null;
        if (alled()) {
            result = (TimeStampResponse) RaResult.isOk(atomedApiRequest.tsaGetByTsaCode(tsaCode));
        } else {
            result = (TimeStampResponse) RaResult.isOk(certApiRequest.tsaGetByTsaCode(tsaCode));
        }
        return result;

    }

    /**
     * ??????tsaCode?????????????????????
     *
     * @param obj
     * @return
     */
    public String tsaUpdate(TimeStampRequest obj) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) RaResult.isOk(atomedApiRequest.tsaUpdate(obj));
        } else {
            result = (String) RaResult.isOk(certApiRequest.tsaUpdate(obj));
        }
        return result;
    }

    /**
     * ??????tsaCode???????????????????????????
     *
     * @param tsaCode ?????? ???????????????
     * @return
     */
    public String tsaDelete(String tsaCode) throws Exception {
        String result = null;
        if (alled()) {
            result = (String) RaResult.isOk(atomedApiRequest.tsaDelete(tsaCode));
        } else {
            result = (String) RaResult.isOk(certApiRequest.tsaDelete(tsaCode));
        }
        return result;
    }
}
