package com.itrus.common.http;

import cn.com.itrus.atom.sign.common.bean.Result;
import com.itrus.common.request.atom.CreateCircularSealRequest;
import com.itrus.common.request.atom.CreateDoubleRowSealRequest;
import com.itrus.common.request.atom.CreateSingleRowSealRequest;
import com.itrus.common.request.atom.SealLimpidRequest;
import com.itrus.common.request.cert.CertUpdateRequest;
import com.itrus.common.request.dgs.*;
import com.itrus.common.request.dsvs.DsvsBatchSignRequest;
import com.itrus.common.request.dsvs.DsvsKeywordCoordinateRequest;
import com.itrus.common.request.dsvs.DsvsSignRequest;
import com.itrus.common.request.dsvs.DsvsVerifyBase64Request;
import com.itrus.common.request.ra.CertConfigRequest;
import com.itrus.common.request.ra.TimeStampRequest;
import com.itrus.common.response.atom.FssDownloadBase64Result;
import com.itrus.common.response.atom.FssUploadBase64Result;
import com.itrus.common.response.atom.FssUploadResult;
import com.itrus.common.response.cert.ApplyCertResult;
import com.itrus.common.response.cert.CertUpdateResult;
import com.itrus.common.response.dgs.DgsPdfFillResult;
import com.itrus.common.response.dsvs.DsvsKeywordCoordinatesResult;
import com.itrus.common.response.dsvs.DsvsSignResult;
import com.itrus.common.response.dsvs.DsvsVerifyBase64Result;
import com.itrus.common.response.ra.CertConfigResponse;
import com.itrus.common.response.ra.RaResult;
import com.itrus.common.response.ra.TimeStampResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 整合版公共原子服务调用方法
 *
 * @author han_yanhui
 * @date 2020-8-26 14:41:00
 **/
@FeignClient(value = "${http.atomed}") //value:被调用的服务在注册中心的名称
public interface AtomedApiRequest {

    /**
     *
     * 印章服务
     *
     */
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * 创建椭圆印章
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */

    //value:被调用的服务接口路径
    @RequestMapping(value = "/seal/front/createEllipseSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> createEllipseSeal(CreateCircularSealRequest obj);

    /**
     * 创建圆形印章
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/seal/front/createCircularSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> createCircularSeal(CreateCircularSealRequest obj);

    /**
     * 创建三角章
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/seal/front/createTriangleSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> createTriangleSeal(CreateCircularSealRequest obj);

    /**
     * 创建双行人名印章
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/seal/front/createDoubleRowSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> createDoubleRowSeal(CreateDoubleRowSealRequest obj);

    /**
     * 创建单行人名印章
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/seal/front/createSingleRowSeal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> createSingleRowSeal(CreateSingleRowSealRequest obj);

    /**
     * 印章透明处理
     *
     * @param obj 请求参数
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/seal/front/sealLimpid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> sealLimpid(SealLimpidRequest obj);
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * 文件存储服务
     *
     * @throws Exception
     */
    //--------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/fss/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> fileDelete(Object obj);

    /***
     * 上传文件
     * @param    obj
     * @return 操作结果
     * @throws Exception
     */
    @RequestMapping(value = "/fss/uploadBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<FssUploadBase64Result> uploadBase64(Object obj);

    /***
     * 上传文件
     * @param file 文件
     * @param bizType 业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符
     * | encryptionType | Integer | 可选 | 加密类型：<br />1. 不加密（默认）
     * @return 操作结果
     */
    @RequestMapping(value = "/fss/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<FssUploadResult> upload(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "bizType") String bizType,
                                          @RequestPart(value = "encryptionType") Integer encryptionType);

    /***
     * 下载文件
     * @param obj 文件存储标识
     * @return 文件内容
     * @throws Exception
     */
    @RequestMapping(value = "/fss/downloadBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<FssDownloadBase64Result> downLoadBase64(Object obj);

    /***
     * 下载文件
     * @param obj 文件存储标识
     * @return 文件内容
     * @throws Exception
     */
    @RequestMapping(value = "/fss/download", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> download(Object obj);

    /***
     * 下载文件
     * @param fssId 文件存储标识
     * @return 文件内容
     */
	/*public Result<DownloadResponse> download(Long fssId) {
		Map<String, Long> request = new Hashtable<>();
		request.put("fssId", fssId);
		Result<DownloadResponse> result;
		try {
			result = getApiService().callApi(callApiUrlDTO.getFileDownload(), request, new ApiUser(),
					new ApiResponseHandler<Result<DownloadResponse>>() {
				@Override
				public Result<DownloadResponse> handleResponse(Response response) {
					try {
						String downloadSuccess = response.header(FSSConstants.HEADER_DOWNLOAD_SUCCESS);
						if("true".equals(downloadSuccess)) {
							String filename = response.header("Content-Disposition");
							if (filename.startsWith("attachment;filename=")) {
								filename = filename.replace("attachment;filename=", "");
							}
							DownloadResponse downloaRresponse = new DownloadResponse();
							downloaRresponse.setFileBytes(response.body().bytes());
							downloaRresponse.setFileName(filename);
							return Result.createSuccessResult(downloaRresponse);
						} else {
							return JSON.parseObject(response.body().string(), new TypeReference<Result<DownloadResponse>>() {});
						}
					} catch (Exception e) {
						log.error("download error", e);
						return Result.createFailResult("下载失败: " + e.getMessage());
					}
				}
			});
			return result;
		} catch (Exception e) {
			log.error("download error", e);
			return Result.createFailResult("download error: " + e.getMessage());
		}
	}*/


    //-------------------------------------------------------------------------------------------------------------------------
    /**
     * 证书服务
     */
    //-------------------------------------------------------------------------------------------------------------------------

    /**
     * 申请证书
     *
     * @param obj 不能是map对象
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/cert/apply", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<ApplyCertResult> applyCert(Object obj);

    /**
     * 更新证书
     *
     * @param obj 不能是map对象
     * @return 返回创建结果
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/cert/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<CertUpdateResult> updateCert(CertUpdateRequest obj);

    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 签章验章服务
     */
    //-----------------------------------------------------------------------------------------------------------------------

    /**
     * PDF签章
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dsvs/sign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<DsvsSignResult> sign(DsvsSignRequest obj);

    /**
     * PDF批量签章
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dsvs/batchSign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<DsvsSignResult> batchSign(DsvsBatchSignRequest obj);

    /**
     * PDF验章
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dsvs/verifyBase64", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<DsvsVerifyBase64Result> verifyBase64(DsvsVerifyBase64Request obj);

    /**
     * 获取关键字坐标
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dsvs/getKeywordCoordinates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<DsvsKeywordCoordinatesResult> getKeywordCoordinates(DsvsKeywordCoordinateRequest obj);
    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * 文档生成服务
     */
    //-----------------------------------------------------------------------------------------------------------------------

    /**
     * PDF模板填充
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/dgs/pdfFill", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<DgsPdfFillResult> pdfFill(DgsPdfFillRequest obj);

    /**
     * PDF模板创建
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/dgs/pdfCreate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> pdfCreate(DgsPdfCreateRequest obj);


    /**
     * 添加文字水印
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dgs/pdfTextMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> pdfTextMark(DgsPdfTextMarkRequest obj);

    /**
     * 添加图片水印
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dgs/pdfImageMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> pdfImageMark(DgsPdfImageMarkRequest obj);

    /**
     * 添加二维码水印
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dgs/pdfQrCodeMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> pdfQrCodeMark(DgsPdfQrCodeMarkRequest obj);

    /**
     * 添加文字和二维码水印
     *
     * @param obj 不能是map对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dgs/pdfTextAndQrCodeMark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> pdfTextAndQrCodeMark(DgsPdfTextAndQrCodeMarkRequest obj);

    /**
     * 新建RA证书配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/ra/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> RaAdd(CertConfigRequest obj);

    /**
     * 查询RA证书配置
     *
     * @param raCode
     * @return
     */
    @RequestMapping(value = "/web/ra/getByRaCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<CertConfigResponse> GetByRaCode(@RequestPart("raCode") String raCode);


    /**
     * 更新RA证书配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/ra/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> RaUpdate(CertConfigRequest obj);


    /**
     * 根据唯一标识删除区块链服务配置
     *
     * @param raCode
     * @return
     */
    @RequestMapping(value = "/web/ra/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> RaDelete(@RequestPart("raCode") String raCode);

    /**
     * 查询区块链服务配置列表
     *
     * @param enterpriseId 必选 企业唯一标识
     * @param productId    可选 产品唯一标识
     * @return
     */
    @RequestMapping(value = "/web/ra/getList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<List<CertConfigResponse>> RaGetList(@RequestPart("enterpriseId") String enterpriseId, @RequestPart("productId") String productId);


    /**
     * 新增时间戳配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/tsa/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> tsaAdd(TimeStampRequest obj);

    /**
     * 根据企业唯一标识查询时间戳配置详情，只返回最后一次添加的一条
     *
     * @param enterpriseId 必填 企业唯一标识
     * @param productId    可选 产品唯一标识
     * @return
     */
    @RequestMapping(value = "/web/tsa/getTsaConfig", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<TimeStampResponse> tsaGetTsaConfig(@RequestPart("enterpriseId") String enterpriseId, @RequestPart("productId") String productId);

    /**
     * 根据tsaCode查询时间戳配置是否已存在
     *
     * @param tsaCode 必选 时间戳代码
     * @return
     */

    @RequestMapping(value = "/web/tsa/getByTsaCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<TimeStampResponse> tsaGetByTsaCode(@RequestPart("tsaCode") String tsaCode);

    /**
     * 根据tsaCode更新时间戳配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/tsa/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> tsaUpdate(TimeStampRequest obj);

    /**
     * 根据tsaCode删除时间戳服务配置
     *
     * @param tsaCode 必填 时间戳代码
     * @return
     */
    @RequestMapping(value = "/web/tsa/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> tsaDelete(@RequestPart("tsaCode") String tsaCode);

}
