package com.itrus.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * Title: HttpTools.java<br>
 * Description: Http工具类<br>
 * 
 * @author sunsr
 */
public class HttpTools {
    // cookie 存储
    private static final CookieStore COOKIE_STORE = new BasicCookieStore();
    private static PoolingHttpClientConnectionManager cm = null; // 连接池管理器
    private static RequestConfig defaultRequestConfig = null; // 请求默认配置
    public static final boolean COOKIE_ENABLED = false; // 是否开启cookie
    public static final int REQUEST_TIMEOUT = 30 * 1000; // 读取超时 30秒
    public static final int CONN_TIMEOUT = 5 * 1000; // 连接超时 5秒
    public static final int POOL_MAX_TOTAL = 200; // 连接池最大连接数
    public static final int POOL_MAX_PER_ROUTE = 100; // 每个路由的默认最大连接数

    static {
        // 连接池管理器初始化
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();
        cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(POOL_MAX_TOTAL);
        cm.setDefaultMaxPerRoute(POOL_MAX_PER_ROUTE);
        // TODO:为具体路由指定连接数
        // cm.setMaxPerRoute(new HttpRoute(new HttpHost("127.0.0.1", 8080)), 1);

        // 请求默认配置初始化
        defaultRequestConfig = RequestConfig.custom().setSocketTimeout(REQUEST_TIMEOUT) // 读取超时时间
                .setConnectTimeout(CONN_TIMEOUT) // 连接超时时间
                .setCookieSpec(CookieSpecs.DEFAULT).build();
    }

    /**
    *
    * @api HttpTools.get 发送get请求
    * @apiVersion 2.2.0
    * @apiParam {String} url 请求路径
    * @apiName get
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {Integer} status 状态码
    * @apiSuccess (Success) {String} message 状态消息
    * @apiSuccess (Success) {String} content 内容
    * @apiSuccess (Success) {String} sign 签名
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "成功",
    *       "content":"{\"suject\":\"温温测试\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity get(String url) throws IOException {
        return get(url, new HttpData());
    }

    /**
    *
    * @api HttpTools.get 发送get请求
    * @apiVersion 2.2.0
    * @apiParam {String} url 请求路径
    * @apiUse HttpData
    * @apiName get
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {Integer} status 状态码
    * @apiSuccess (Success) {String} message 状态消息
    * @apiSuccess (Success) {String} content 内容
    * @apiSuccess (Success) {String} sign 签名
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "成功",
    *       "content":"{\"suject\":\"温温测试\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity get(String url, HttpData data) throws IOException {
        // 连接池管理，无需关闭
        CloseableHttpClient httpclient = createClient(data);

        HttpGet httpGet = new HttpGet(url);
        // 设置请求数据信息
        setData(httpGet, data);
        // 设置请求配置信息
        httpGet.setConfig(getRequestConfig(data));
        // 返回响应结果
        return httpclient.execute(httpGet, responseHandler);
    }


    /**
    *
    * @api HttpTools.post 发送post请求
    * @apiName post
    * @apiGroup HttpTools工具类
    * @apiVersion 2.2.0
    * @apiParam {String} url 请求路径
    * @apiSuccess (Success) {Integer} status 状态码
    * @apiSuccess (Success) {String} message 状态消息
    * @apiSuccess (Success) {String} content 内容
    * @apiSuccess (Success) {String} sign 签名
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "成功",
    *       "content":"{\"suject\":\"温温测试\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity post(String url) throws IOException {
        return post(url, new HttpData());
    }

    /**
    *
    * @api HttpTools.post 发送post请求
    * @apiVersion 2.2.0
    * @apiParam {String} url 请求路径
    * @apiUse HttpData
    * @apiName post
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {Integer} status 状态码
    * @apiSuccess (Success) {String} message 状态消息
    * @apiSuccess (Success) {String} content 内容
    * @apiSuccess (Success) {String} sign 签名
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "成功",
    *       "content":"{\"suject\":\"温温测试\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity post(String url, HttpData data) throws IOException {
        CloseableHttpClient httpclient = createClient(data);

        HttpPost httpPost = new HttpPost(url);
        // 设置请求数据信息
        setData(httpPost, data);
        // 设置请求配置信息
        httpPost.setConfig(getRequestConfig(data));
        // 返回响应结果
        return httpclient.execute(httpPost, responseHandler);
    }

    /**
    *
    * @api HttpTools.delete 发送DELETE请求
    * @apiVersion 2.2.0
    * @apiParam {String} url 请求路径
    * @apiUse HttpData
    * @apiName delete
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {Integer} status 状态码
    * @apiSuccess (Success) {String} message 状态消息
    * @apiSuccess (Success) {String} content 内容
    * @apiSuccess (Success) {String} sign 签名
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "成功",
    *       "content":"{\"suject\":\"温温测试\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity delete(String url, HttpData data) throws IOException {
        CloseableHttpClient httpclient = createClient(data);

        HttpDelete httpDelete = new HttpDelete(url);
        // 设置请求数据信息
        setData(httpDelete, data);
        // 设置请求配置信息
        httpDelete.setConfig(getRequestConfig(data));
        // 返回响应结果
        return httpclient.execute(httpDelete, responseHandler);
    }
    
    /**
    *
    * @api HttpTools.download 下载
    * @apiVersion 2.2.0
    * @apiParam {String} url 请求路径
    * @apiUse HttpData
    * @apiParam {OutputStream} out 输出流
    * @apiName download
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {Integer} status 状态码
    * @apiSuccess (Success) {String} message 状态消息
    * @apiSuccess (Success) {String} content 内容
    * @apiSuccess (Success) {String} sign 签名
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "成功",
    *       "content":"{ok}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity download(String url, HttpData data, final OutputStream out) throws IOException {
        CloseableHttpClient httpclient = createClient(data);

        HttpPost httpPost = new HttpPost(url);
        // 设置请求数据信息
        setData(httpPost, data);
        // 设置请求配置信息
        httpPost.setConfig(getRequestConfig(data));
        // 返回响应结果
        return httpclient.execute(httpPost, new ResponseHandler<ResponseEntity>() {
            @Override
            public ResponseEntity handleResponse(final HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setStatus(status);
                if(responseEntity.isOk()) {
                    InputStream in = response.getEntity().getContent();
                    byte[] b = new byte[1000];
                    int n;
                    while ((n = in.read(b)) != -1) {
                        out.write(b, 0, n);
                    }
                    out.flush();
                    responseEntity.setContent("ok");
                } else if (status == 202) {
                    responseEntity.setContent(EntityUtils.toString(response.getEntity()));
                } else {
                    responseEntity.setMessage(response.getStatusLine().toString());
                }
                return responseEntity;
            }
        });
    }


    /***
     * 创建HttpClient
     * 
     * @return HttpClient对象
     */
    private static CloseableHttpClient createClient(HttpData data) {
        CloseableHttpClient httpclient = null;

        if (data != null && data.getCookieEnabled()) {
            httpclient = HttpClients.custom()
                    // CloseableHttpClient关闭时，ConnectionManager不会被关闭，如果为false则会关闭ConnectionManager，导致获取连接异常；
                    .setConnectionManagerShared(true).setConnectionManager(cm).setDefaultCookieStore(COOKIE_STORE)
                    .build();
        } else {
            httpclient = HttpClients.custom().setConnectionManagerShared(true).setConnectionManager(cm).build();
        }

        return httpclient;
    }

    /**
    *
    * @api HttpTools.setData 设置请求头
    * @apiVersion 2.2.0
    * @apiParam {HttpRequestBase} request requestBase
    * @apiUse HttpData
    * @apiName setData
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {HttpRequestBase} request requestBase
	*/
    private static void setData(HttpRequestBase request, HttpData data) throws UnsupportedEncodingException {
        /* -----------设置请求头信息------------- */
        if (data.getHeaders() != null) {
            for (Entry<String, String> entry : data.getHeaders().entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        /* -----------设置get请求参数------------- */
        if (request instanceof HttpGet) {
            setHttpGetParams((HttpGet) request, data);
            return;
        }

        /* -----------设置delete请求参数------------- */
        if (request instanceof HttpDelete) {
            setHttpDeleteParams((HttpDelete) request, data);
            return;
        }

        /* -----------设置post请求参数------------- */
        HttpPost httpPost = (HttpPost) request;

        // 如果请求体不为null，则使用现有请求体，并返回
        if (data.getPostEntity() != null) {
            httpPost.setEntity(data.getPostEntity());
            return;
        }

        // 没有上传文件，设置参数后返回
        if (data.getFiles() == null) {
            setHttpPostParams(httpPost, data);
            return;
        }

        // 有上传文件，使用Multipart模式；
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        meBuilder.setCharset(Charset.forName(data.getCharset()));
        // 1、添加参数部分
        Map<String, String> params = data.getParams();
        if (params != null) {
            for (String key : params.keySet()) {
                String value = params.get(key);
                if(value != null) {
                    value = new String(params.get(key).getBytes(data.getCharset()), "iso8859-1");
                }
                meBuilder.addPart(key, new StringBody(value, ContentType.TEXT_PLAIN));
            }
        }
        // 2、添加文件部分
        Map<String, Object> files = data.getFiles();
        for (String key : files.keySet()) {
            Object file = files.get(key);
            if (file instanceof File) {
                FileBody fileBody = new FileBody((File) file);
                meBuilder.addPart(key, fileBody);
                continue;
            }

            if (file instanceof Object[]) {
                Object[] fileAttr = (Object[]) file;
                if (fileAttr[0] instanceof InputStream) {
                    InputStreamBody fileBody = new InputStreamBody((InputStream) fileAttr[0],
                            String.valueOf(fileAttr[1]));
                    meBuilder.addPart(key, fileBody);
                    continue;
                }

                if (fileAttr[0] instanceof byte[]) {
                    ByteArrayBody fileBody = new ByteArrayBody((byte[]) fileAttr[0], String.valueOf(fileAttr[1]));
                    meBuilder.addPart(key, fileBody);
                }
            }
        }
        // 设置请求参数信息
        httpPost.setEntity(meBuilder.build());
    }

    /**
    *
    * @api HttpTools.setHttpGetParams 设置get类型参数
    * @apiVersion 2.2.0
    * @apiParam {HttpGet} request HttpGet
    * @apiUse HttpData
    * @apiName setHttpGetParams
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {HttpGet} request HttpGet
	*/
    private static void setHttpGetParams(HttpGet request, HttpData data) throws UnsupportedEncodingException {
        if (data.getParams() == null) {
            return;
        }

        StringBuilder url = new StringBuilder(request.getURI().toString());
        // 如果url以"/"结尾，则移除末尾的"/"
        if (url.lastIndexOf("/") == url.length() - 1) {
            url.delete(url.length() - 1, url.length());
        }
        // 如果url中无"?"，则在末尾添加"?"
        if (url.indexOf("?") == -1) {
            url.append("?");
        }

        for (Entry<String, String> entry : data.getParams().entrySet()) {
            // url最后一位不是"?",则在末尾添加"&"参数连接符
            if (url.lastIndexOf("?") != url.length() - 1) {
                url.append("&");
            }

            url.append(entry.getKey()).append("=");
            url.append(URLEncoder.encode(entry.getValue(), data.getCharset()));
        }

        request.setURI(URI.create(url.toString()));
    }

    /**
    *
    * @api HttpTools.setHttpDeleteParams 设置Delete类型参数
    * @apiVersion 2.2.0
    * @apiParam {HttpDelete} request HttpDelete
    * @apiUse HttpData
    * @apiName setHttpDeleteParams
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {HttpDelete} request HttpDelete
	*/
    private static void setHttpDeleteParams(HttpDelete request, HttpData data) throws UnsupportedEncodingException {
        if (data.getParams() == null) {
            return;
        }

        StringBuilder url = new StringBuilder(request.getURI().toString());
        // 如果url以"/"结尾，则移除末尾的"/"
        if (url.lastIndexOf("/") == url.length() - 1) {
            url.delete(url.length() - 1, url.length());
        }
        // 如果url中无"?"，则在末尾添加"?"
        if (url.indexOf("?") == -1) {
            url.append("?");
        }

        for (Entry<String, String> entry : data.getParams().entrySet()) {
            // url最后一位不是"?",则在末尾添加"&"参数连接符
            if (url.lastIndexOf("?") != url.length() - 1) {
                url.append("&");
            }

            url.append(entry.getKey()).append("=");
            url.append(URLEncoder.encode(entry.getValue(), data.getCharset()));
        }

        request.setURI(URI.create(url.toString()));
    }

    /**
    *
    * @api HttpTools.setHttpPostParams 设置post类型参数
    * @apiVersion 2.2.0
    * @apiParam {HttpPost} request HttpPost
    * @apiUse HttpData
    * @apiName setHttpPostParams
    * @apiGroup HttpTools工具类
    * @apiSuccess (Success) {HttpPost} request HttpPost
	*/
    private static void setHttpPostParams(HttpPost request, HttpData data) throws UnsupportedEncodingException {
        if (data.getParams() == null) {
            return;
        }

        // 构建请求参数列表
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : data.getParams().entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        // 设置请求参数信息
        request.setEntity(new UrlEncodedFormEntity(nvps, data.getCharset()));
    }

    private static RequestConfig getRequestConfig(HttpData httpData) {
        if (httpData == null || httpData.getTimeout() == REQUEST_TIMEOUT) {
            return defaultRequestConfig;
        } else {
            return RequestConfig.custom().setSocketTimeout(httpData.getTimeout()) // 读取超时时间
                    .setConnectTimeout(CONN_TIMEOUT) // 连接超时时间
                    .setCookieSpec(CookieSpecs.DEFAULT).build();
        }

    }

    /***
	 * 响应处理器
	 */
	private static ResponseHandler<ResponseEntity> responseHandler = new ResponseHandler<ResponseEntity>() {
		@Override
		public ResponseEntity handleResponse(final HttpResponse response) throws IOException {
			int status = response.getStatusLine().getStatusCode();
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setStatus(status);
            Header header = response.getFirstHeader("X-LUFAX-API-SIGN");
            if (header != null) {
                responseEntity.setSign(header.getValue());
            }
			if(responseEntity.isOk()) {
			    responseEntity.setContent(EntityUtils.toString(response.getEntity()));
			} else if (status == 202) {
                responseEntity.setContent(EntityUtils.toString(response.getEntity()));
			} else {
	            responseEntity.setMessage(response.getStatusLine().toString());
			}
			return responseEntity;
		}
	};
	

    /**
     * @author ssr
     *
     */
    public static class ResponseEntity implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private Integer status;
        private String message;
        private String content;
        private String sign;

        public static ResponseEntity of(Integer status, String message, String content) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.status = status;
            responseEntity.message = message;
            responseEntity.content = content;
            return responseEntity;
        }

        public boolean isOk() {
            return Objects.equals(200, status);
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
        
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return "ResponseEntity [status=" + status + ", message=" + message + ", content=" + content + ", sign="+ sign +"]";
        }
    }
    
    
    /**
     * @apiDefine HttpData 请求体
     * 
     * @apiParam {Map} files file文件
     * @apiParam {Map} headers 请求头参数
     * @apiParam {Map} params 表单参数
     * @apiParam {HttpEntity} postEntity 请求体
     */
    public static class HttpData{
        //编码
        private String charset = "UTF-8"; 
        //请求超时时间
        private int timeout = HttpTools.REQUEST_TIMEOUT;
        // 是否开启cookie
        private boolean cookieEnabled = HttpTools.COOKIE_ENABLED;
        //上传文件
        private Map<String, Object> files = null;
        //请求头参数
        private Map<String, String> headers = null;
        //表单参数
        private Map<String, String> params = null;
        //请求体
        private HttpEntity postEntity = null;
        
        public static HttpData instance() {
            return new HttpData();
        }
        
        
        /**
        *
        * @api HttpTools.addHeader 添加请求头参数
        * @apiVersion 2.2.0
        * @apiParam {String} name 键(参数名称)
        * @apiParam {Object} value 值
        * @apiName addHeader
        * @apiGroup HttpTools工具类
        * @apiSuccess (Success) {HttpData} headers HttpData
    	*/
        public HttpData addHeader(String name, Object value){
            if(name != null && value != null) {
                if(headers == null) {
                    headers = new HashMap<>();
                }
                headers.put(name, String.valueOf(value));
            }
            return this;
        }
        
        /**
        *
        * @api HttpTools.addParams 添加表单参数
        * @apiVersion 2.2.0
        * @apiParam {Map} params Map键值对
        * @apiName addParams
        * @apiGroup HttpTools工具类
        * @apiSuccess (Success) {HttpData} params HttpData
    	*/
        public HttpData addParams(Map<String, String> params){
            if(params == null || params.size() == 0) {
                return this;
            }
    
            if(this.params == null) {
                this.params = new HashMap<>();
            }
            
            for (String key : params.keySet()) {
                this.params.put(key, params.get(key));
            }
    
            return this;
        }
        
        /**
        *
        * @api HttpTools.addParams 添加表单参数
        * @apiVersion 2.2.0
        * @apiParam {String} name 键(参数名称)
        * @apiParam {Object} value 值
        * @apiName addParams
        * @apiGroup HttpTools工具类
        * @apiSuccess (Success) {HttpData} params HttpData
    	*/
        public HttpData addParam(String name, Object value){
            if(name != null && value != null) {
                if(params == null) {
                    params = new HashMap<>();
                }
                params.put(name, String.valueOf(value));
            }
            return this;
        }
        
        /**
        *
        * @api HttpTools.addParams 添加文件流参数
        * @apiVersion 2.2.0
        * @apiParam {String} name 键(参数名称)
        * @apiParam {File} value 值(file文件)
        * @apiName addParams
        * @apiGroup HttpTools工具类
        * @apiSuccess (Success) {HttpData} files HttpData
    	*/
        public HttpData addFile(String name, File value) {
            if(name != null && value != null) {
                if(files == null) {
                    files = new HashMap<>();
                }
                files.put(name, value);
            }
            return this;
        }
        
        /**
        *
        * @api HttpTools.addFile 添加文件流参数
        * @apiVersion 2.2.0
        * @apiParam {String} paramName 键(参数名称)
        * @apiParam {InputStream} value 值(输入流)
        * @apiParam {String} fileName 值(文件名称)
        * @apiName addFile
        * @apiGroup HttpTools工具类
        * @apiSuccess (Success) {HttpData} files HttpData
    	*/
        public HttpData addFile(String paramName, InputStream value, String fileName) {
            if(paramName != null && value != null && fileName != null) {
                if(files == null) {
                    files = new HashMap<>();
                }
                Object[] item = new Object[2];
                item[0] = value;
                item[1] = fileName;
                files.put(paramName, item);
            }
            return this;
        }
        
        /**
        *
        * @api HttpTools.addFile 添加文件字节数组参数
        * @apiVersion 2.2.0
        * @apiParam {String} paramName 键(参数名称)
        * @apiParam {byte[]} value 文件字节数组
        * @apiParam {String} fileName 值(文件名称)
        * @apiName addFile
        * @apiGroup HttpTools工具类
        * @apiSuccess (Success) {HttpData} files HttpData
    	*/
        public HttpData addFile(String paramName, byte[] value, String fileName) {
            if(paramName != null && value != null && fileName != null) {
                if(files == null) {
                    files = new HashMap<>();
                }
                Object[] item = new Object[2];
                item[0] = value;
                item[1] = fileName;
                files.put(paramName, item);
            }
            return this;
        }
    
        //--------------------------------------------------------
        /** 获取编码：默认UTF-8 */
        public String getCharset() {
            return charset;
        }
    
        /** 设置编码：默认UTF-8 */
        public HttpData setCharset(String charset) {
            this.charset = charset;
            return this;
        }
        
        /** 获取请求超时时间(毫秒) */
        public int getTimeout() {
            return timeout;
        }
    
        /** 设置请求超时时间(毫秒) */
        public HttpData setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }
        
        /** 获取是否允许cookie*/
        public boolean getCookieEnabled() {
            return cookieEnabled;
        }
    
        /** 设置是否允许cookie */
        public HttpData setCookieEnabled(boolean cookieEnabled) {
            this.cookieEnabled = cookieEnabled;
            return this;
        }
    
        /** 获取请求体：默认为null */
        public HttpEntity getPostEntity() {
            return postEntity;
        }
    
        /** 
         * 设置post请求体：设置后addParam和addFile添加的参数将失效，常用请求体如下：
         *  1、StringEntity：字符串体，常用于webservice，提交xml格式内容；
         *  2、InputStreamEntity：流
         *  3、ByteArrayEntity：字符数组
         *  4、FileEntity：文件
         */
        public HttpData setPostEntity(HttpEntity postEntity) {
            this.postEntity = postEntity;
            return this;
        }
    
        /** 获取上传文件列表：无上传文件返回null */
        public Map<String, Object> getFiles() {
            return files;
        }
    
        /** 获取请求头参数列表：无参数返回null */
        public Map<String, String> getHeaders() {
            return headers;
        }
    
        /** 获取参数列表：无参数返回null */
        public Map<String, String> getParams() {
            return params;
        }
    }


    /***
     * 测试方法
     * 
     * @param args
     * @throws Exception
     */
   /* public static void main(String[] args) throws Exception {
        long s = System.currentTimeMillis();
        final CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 100; j++) {
                            System.out.println(get("http://www.baidu.com").getStatus());
                        }
                    } catch (IOException e) {
                    	logger.error(e.getMessage());
                    } finally {
                        cdl.countDown();
                    }
                }
            }).start();;
        }
        
        cdl.await();
        System.out.println(System.currentTimeMillis() - s);
        
    }*/

}
