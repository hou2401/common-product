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

    /**
     * 是否为合并调用式
     *
     * @return
     * @throws HttpException
     */
    private boolean alled() throws HttpException {
        return http.alled();
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
            if (alled()) {//合并版
            	result = atomedApiRequest.createEllipseSeal(kvs).getData();
            } else {
                result = sealApiRequest.createEllipseSeal(kvs).getData();
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
            result = atomedApiRequest.createCircularSeal(sealParam).getData();
        } else {
            result = sealApiRequest.createCircularSeal(sealParam).getData();
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
    		result = atomedApiRequest.createTriangleSeal(sealParam).getData();
    	} else {
    		result = sealApiRequest.createTriangleSeal(sealParam).getData();
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
            	result = atomedApiRequest.createDoubleRowSeal(sealParam).getData();
            } else {
                result = sealApiRequest.createDoubleRowSeal(sealParam).getData();
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
        	result = atomedApiRequest.createSingleRowSeal(sealParam).getData();
        } else {
            result = sealApiRequest.createSingleRowSeal(sealParam).getData();
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
        	result = atomedApiRequest.sealLimpid(obj).getData();
        } else {

            result = sealApiRequest.sealLimpid(obj).getData();
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
            return atomedApiRequest.fileDelete(params).getData();
        } else {
            result = fssApiRequest.fileDelete(params).getData();
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
        	
        	JSONObject jsonObject = atomedApiRequest.uploadBase64(cearParam).getData();
            if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }        
        }else {
        	JSONObject jsonObject = fssApiRequest.uploadBase64(cearParam).getData();
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
        	jsonObject = atomedApiRequest.upload(file,bizType,encryptionType).getData();
        	if (jsonObject != null) {
                if (jsonObject.getInteger("code") == 0) {
                    fssId = jsonObject.getJSONObject("data").getLong("fssId");
                } else {
                    log.error("调用存储原子服务保存印章失败：" + jsonObject.getString("msg"));
                    return null;
                }
            }
        } else {
        	jsonObject = fssApiRequest.upload(file, bizType, encryptionType).getData();
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
            result = atomedApiRequest.downLoadBase64(params).getData();
        } else {
            result = fssApiRequest.downLoadBase64(params).getData();
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
        return fcsApiRequest.word2Pdfs(params).getData();
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
        return fcsApiRequest.pdf2png(params).getData();
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
        return fcsApiRequest.excel2Pdfs(params).getData();
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
        return fcsApiRequest.image2Pdfs(params).getData();
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
    	return fcsApiRequest.generateThumbnail(file, pages, scale, dpi).getData();
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
    	return fcsApiRequest.getTotalPages(file).getData();
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
            result = atomedApiRequest.applyCert(cert).getData();
        } else {
            result = certApiRequest.applyCert(cert).getData();
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
            result = atomedApiRequest.updateCert(kvs).getData();
        } else {
            result = certApiRequest.updateCert(kvs).getData();
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
	        result = atomedApiRequest.sign(kvs).getData();
	    } else {
	        result = dsvsApiRequest.sign(kvs).getData();
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
        	 result = atomedApiRequest.batchSign(pdfBatchSign).getData();
        } else {
            result = dsvsApiRequest.batchSign(pdfBatchSign).getData();
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
                result = atomedApiRequest.verifyBase64(obj).getData();
            } else {
                result = dsvsApiRequest.verifyBase64(obj).getData();
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
     * PDF模板填充
     *
     * @param kvs
     * @return
     * @throws Exception
     */
    public JSONObject pdfFill(Object kvs) throws Exception {
        JSONObject result = null;
        if (alled()) {
            result = atomedApiRequest.pdfFill(kvs).getData();
        } else {
            result = dgsApiRequest.pdfFill(kvs).getData();
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
    public JSONObject pdfCreate(Object kvs) throws Exception {
    	JSONObject result = null;
    	if (alled()) {
    		result = atomedApiRequest.pdfCreate(kvs).getData();
    	} else {
    		result = dgsApiRequest.pdfCreate(kvs).getData();
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
            result = atomedApiRequest.pdfTextMark(pdfTextMarkParams).getData();
        } else {
            result = dgsApiRequest.pdfTextMark(pdfTextMarkParams).getData();
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
            result = atomedApiRequest.pdfImageMark(pdfImageMarkParams).getData();
        } else {
            result = dgsApiRequest.pdfImageMark(pdfImageMarkParams).getData();
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
            result = atomedApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams).getData();
        } else {
            result = dgsApiRequest.pdfQrCodeMark(pdfQrCodeMarkParams).getData();
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
            result = atomedApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams).getData();
        } else {
            result = dgsApiRequest.pdfTextAndQrCodeMark(pdfTextAndQrCodeMarkParams).getData();
        }
        return result;
    }

}
