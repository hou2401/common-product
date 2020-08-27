package com.itrus.common.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.itrus.common.params.sign.PdfBatchSign;

import org.apache.http.HttpException;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.params.CertParams;
import com.itrus.common.params.PdfImageMarkParams;
import com.itrus.common.params.PdfQrCodeMarkParams;
import com.itrus.common.params.PdfTextAndQrCodeMarkParams;
import com.itrus.common.params.PdfTextMarkParams;
import com.itrus.common.params.UploadParams;

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
    
    private Long okCode = 1L;

    /**
     * 是否为合并调用式
     *
     * @return
     * @throws HttpException
     */
    private boolean alled() throws HttpException {
        return http.alled();
    }
    
    private Object isOk(Result<?> result) throws HttpException{
    	Long code = result.getCode();
    	if(code != null && code.equals(okCode)) {
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
    public JSONObject createEllipseSeal(Object kvs) throws Exception {
        JSONObject result = null;
            if (alled()) {//合并版
            	result = (JSONObject) isOk(atomedApiRequest.createEllipseSeal(kvs));
            } else {
                result = (JSONObject) isOk(sealApiRequest.createEllipseSeal(kvs));
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
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.createCircularSeal(sealParam));
        } else {
            result = (JSONObject) isOk(sealApiRequest.createCircularSeal(sealParam));
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
    public JSONObject createTriangleSeal(SealParam sealParam) throws Exception {
    	JSONObject result = null;
    	if (alled()) {
    		result = (JSONObject) isOk(atomedApiRequest.createTriangleSeal(sealParam));
    	} else {
    		result = (JSONObject) isOk(sealApiRequest.createTriangleSeal(sealParam));
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
            if (alled()) {
            	result = (JSONObject) isOk(atomedApiRequest.createDoubleRowSeal(sealParam));
            } else {
                result = (JSONObject) isOk(sealApiRequest.createDoubleRowSeal(sealParam));
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
        if (alled()) {
        	result = (JSONObject) isOk(atomedApiRequest.createSingleRowSeal(sealParam));
        } else {
            result = (JSONObject) isOk(sealApiRequest.createSingleRowSeal(sealParam));
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
    public JSONObject sealLimpid(Object obj) throws Exception {
        JSONObject result = null;
        if (alled()) {
        	result = (JSONObject) isOk(atomedApiRequest.sealLimpid(obj));
        } else {

            result = (JSONObject) isOk(sealApiRequest.sealLimpid(obj));
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
    	Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.fileDelete(params));
        } else {
            result = (JSONObject) isOk(fssApiRequest.fileDelete(params));
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
    public Long uploadBase64(UploadParams uploadQuery) throws Exception {
        Long ffsId = uploadBase64(uploadQuery.getBizType(), uploadQuery.getFileName(), uploadQuery.getFileBytes(), uploadQuery.getEncryptionType());
        return ffsId;
    }

    public Long uploadBase64(String bizType, String originalFileName, byte[] fileBytes, Integer encryptionType) throws Exception {
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
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }        
        }else {
        	JSONObject jsonObject = (JSONObject) isOk(fssApiRequest.uploadBase64(cearParam));
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
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
    public Long upload(String fileName, String bizType, byte[] fileBytes,String originalFilename, Integer encryptionType) throws Exception {
    	
    	if(originalFilename == null) {
    		originalFilename = "anonymous.file";
		}
    	InputStream inputStream = new ByteArrayInputStream(fileBytes);
    	MultipartFile file = new MockMultipartFile(fileName,originalFilename,ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
    	Long fssId = null;
    	JSONObject jsonObject = null;
        if (alled()) {
        	jsonObject = (JSONObject) isOk(atomedApiRequest.upload(file,bizType,encryptionType));
        	if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
        } else {
        	jsonObject = (JSONObject) isOk(fssApiRequest.upload(file, bizType, encryptionType));
        	if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
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
    public JSONObject downloadBase64(Long fssId) throws Exception {
    	Map<String, Object> params = new HashMap<>(1);
		params.put("fssId", fssId);
        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.downLoadBase64(params));
        } else {
            result = (JSONObject) isOk(fssApiRequest.downLoadBase64(params));
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
    public JSONObject word2Pdfs(byte[] data) throws Exception {
    	Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
        return (JSONObject) isOk(fcsApiRequest.word2Pdfs(params));
    }
    
    /**
     * pdf转png
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject pdf2png(byte[] data) throws Exception {
    	Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
        return (JSONObject) isOk(fcsApiRequest.pdf2png(params));
    }

	/**
	 * excel文档转换pdf（支持xls/xlsx）
	 * @param data
	 * @return
	 * @throws Exception
	 */
    public JSONObject excel2Pdfs(byte[] data) throws Exception {
    	Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
        return (JSONObject) isOk(fcsApiRequest.excel2Pdfs(params));
    }

	/**
	 * image文档转换pdf（支持jpeg/jpg/png）
	 * @param data
	 * @return
	 * @throws Exception
	 */
    public JSONObject image2png(byte[] data) throws Exception {
    	Map<String,String> params = new HashMap<>();
		params.put("file",Base64Utils.encodeToString(data));
        return (JSONObject) isOk(fcsApiRequest.image2Pdfs(params));
    }
    
    /***
     * 生成缩略图
     * @param file 文件
     * @return 操作结果
     * @throws Exception
     */
    public JSONObject generateThumbnail(String fileName, byte[] fileBytes,String originalFilename, String pages,
    		Float scale, Float dpi) throws Exception {
    	
    	if(originalFilename == null) {
    		originalFilename = "anonymous.file";
		}
    	InputStream inputStream = new ByteArrayInputStream(fileBytes);
    	MultipartFile file = new MockMultipartFile(fileName,originalFilename,ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
    	return (JSONObject) isOk(fcsApiRequest.generateThumbnail(file, pages, scale, dpi));
    }
    
    /***
     * 获取文件总页数
     * @param file 文件
     * @return 操作结果
     * @throws Exception
     */
    public JSONObject getTotalPages(String fileName, byte[] fileBytes,String originalFilename) throws Exception {
    	
    	if(originalFilename == null) {
    		originalFilename = "anonymous.file";
    	}
    	InputStream inputStream = new ByteArrayInputStream(fileBytes);
    	MultipartFile file = new MockMultipartFile(fileName,originalFilename,ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
    	return (JSONObject) isOk(fcsApiRequest.getTotalPages(file));
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
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.applyCert(cert));
        } else {
            result = (JSONObject) isOk(certApiRequest.applyCert(cert));
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
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.updateCert(kvs));
        } else {
            result = (JSONObject) isOk(certApiRequest.updateCert(kvs));
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
	    if (alled()) {
	        result = (JSONObject) isOk(atomedApiRequest.sign(kvs));
	    } else {
	        result = (JSONObject) isOk(dsvsApiRequest.sign(kvs));
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
    public JSONObject batchSign(PdfBatchSign pdfBatchSign) throws Exception {
        JSONObject result = null;
        if (alled()) {
        	 result = (JSONObject) isOk(atomedApiRequest.batchSign(pdfBatchSign));
        } else {
            result = (JSONObject) isOk(dsvsApiRequest.batchSign(pdfBatchSign));
        }
        return result;
    }

    /**
     * PDF验章
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public JSONObject verifyBase64(Object obj) throws Exception {
        JSONObject result = null;
        for (int i = 0; i < http.getRetryCount(); i++) {
            if (alled()) {
                result = (JSONObject) isOk(atomedApiRequest.verifyBase64(obj));
            } else {
                result = (JSONObject) isOk(dsvsApiRequest.verifyBase64(obj));
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
    public JSONObject pdfFill(Object kvs) throws Exception {
        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.pdfFill(kvs));
        } else {
            result = (JSONObject) isOk(dgsApiRequest.pdfFill(kvs));
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
    public JSONObject pdfCreate(String fileName, String bizType, byte[] fileBytes,String originalFilename,Integer styleType,
    		Integer pageSize) throws Exception {
    	if(originalFilename == null) {
    		originalFilename = "anonymous.file";
		}
    	InputStream inputStream = new ByteArrayInputStream(fileBytes);
    	MultipartFile file = new MockMultipartFile(fileName,originalFilename,ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
    	JSONObject result = null;
    	if (alled()) {
    		result = (JSONObject) isOk(atomedApiRequest.pdfCreate(file,styleType,pageSize));
    	} else {
    		result = (JSONObject) isOk(dgsApiRequest.pdfCreate(file,styleType,pageSize));
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
    public JSONObject pdfTextMark(PdfTextMarkParams pdfTextMarkParams) throws Exception {

        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.pdfTextMark(pdfTextMarkParams));
        } else {
            result = (JSONObject) isOk(dgsApiRequest.pdfTextMark(pdfTextMarkParams));
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
    public JSONObject pdfImageMark(PdfImageMarkParams pdfImageMarkParams) throws Exception {
        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.pdfImageMark(pdfImageMarkParams));
        } else {
            result = (JSONObject) isOk(dgsApiRequest.pdfImageMark(pdfImageMarkParams));
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
    public JSONObject pdfQrCodeMark(PdfQrCodeMarkParams pdfQrCodeMarkParams) throws Exception {
        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams));
        } else {
            result = (JSONObject) isOk(dgsApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams));
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
    public JSONObject pdfTextAndQrCodeMark(PdfTextAndQrCodeMarkParams pdfTextAndQrCodeMarkParams) throws Exception {
        JSONObject result = null;
        if (alled()) {
            result = (JSONObject) isOk(atomedApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams));
        } else {
            result = (JSONObject) isOk(dgsApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams));
        }
        return result;
    }
    
}
