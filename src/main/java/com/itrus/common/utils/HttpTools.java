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
 * Description: Http?????????<br>
 * 
 * @author sunsr
 */
public class HttpTools {
    // cookie ??????
    private static final CookieStore COOKIE_STORE = new BasicCookieStore();
    private static PoolingHttpClientConnectionManager cm = null; // ??????????????????
    private static RequestConfig defaultRequestConfig = null; // ??????????????????
    public static final boolean COOKIE_ENABLED = false; // ????????????cookie
    public static final int REQUEST_TIMEOUT = 30 * 1000; // ???????????? 30???
    public static final int CONN_TIMEOUT = 5 * 1000; // ???????????? 5???
    public static final int POOL_MAX_TOTAL = 200; // ????????????????????????
    public static final int POOL_MAX_PER_ROUTE = 100; // ????????????????????????????????????

    static {
        // ???????????????????????????
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
        // TODO:??????????????????????????????
        // cm.setMaxPerRoute(new HttpRoute(new HttpHost("127.0.0.1", 8080)), 1);

        // ???????????????????????????
        defaultRequestConfig = RequestConfig.custom().setSocketTimeout(REQUEST_TIMEOUT) // ??????????????????
                .setConnectTimeout(CONN_TIMEOUT) // ??????????????????
                .setCookieSpec(CookieSpecs.DEFAULT).build();
    }

    /**
    *
    * @api HttpTools.get ??????get??????
    * @apiVersion 2.2.0
    * @apiParam {String} url ????????????
    * @apiName get
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {Integer} status ?????????
    * @apiSuccess (Success) {String} message ????????????
    * @apiSuccess (Success) {String} content ??????
    * @apiSuccess (Success) {String} sign ??????
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "??????",
    *       "content":"{\"suject\":\"????????????\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity get(String url) throws IOException {
        return get(url, new HttpData());
    }

    /**
    *
    * @api HttpTools.get ??????get??????
    * @apiVersion 2.2.0
    * @apiParam {String} url ????????????
    * @apiUse HttpData
    * @apiName get
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {Integer} status ?????????
    * @apiSuccess (Success) {String} message ????????????
    * @apiSuccess (Success) {String} content ??????
    * @apiSuccess (Success) {String} sign ??????
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "??????",
    *       "content":"{\"suject\":\"????????????\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity get(String url, HttpData data) throws IOException {
        // ??????????????????????????????
        CloseableHttpClient httpclient = createClient(data);

        HttpGet httpGet = new HttpGet(url);
        // ????????????????????????
        setData(httpGet, data);
        // ????????????????????????
        httpGet.setConfig(getRequestConfig(data));
        // ??????????????????
        return httpclient.execute(httpGet, responseHandler);
    }


    /**
    *
    * @api HttpTools.post ??????post??????
    * @apiName post
    * @apiGroup HttpTools?????????
    * @apiVersion 2.2.0
    * @apiParam {String} url ????????????
    * @apiSuccess (Success) {Integer} status ?????????
    * @apiSuccess (Success) {String} message ????????????
    * @apiSuccess (Success) {String} content ??????
    * @apiSuccess (Success) {String} sign ??????
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "??????",
    *       "content":"{\"suject\":\"????????????\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity post(String url) throws IOException {
        return post(url, new HttpData());
    }

    /**
    *
    * @api HttpTools.post ??????post??????
    * @apiVersion 2.2.0
    * @apiParam {String} url ????????????
    * @apiUse HttpData
    * @apiName post
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {Integer} status ?????????
    * @apiSuccess (Success) {String} message ????????????
    * @apiSuccess (Success) {String} content ??????
    * @apiSuccess (Success) {String} sign ??????
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "??????",
    *       "content":"{\"suject\":\"????????????\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity post(String url, HttpData data) throws IOException {
        CloseableHttpClient httpclient = createClient(data);

        HttpPost httpPost = new HttpPost(url);
        // ????????????????????????
        setData(httpPost, data);
        // ????????????????????????
        httpPost.setConfig(getRequestConfig(data));
        // ??????????????????
        return httpclient.execute(httpPost, responseHandler);
    }

    /**
    *
    * @api HttpTools.delete ??????DELETE??????
    * @apiVersion 2.2.0
    * @apiParam {String} url ????????????
    * @apiUse HttpData
    * @apiName delete
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {Integer} status ?????????
    * @apiSuccess (Success) {String} message ????????????
    * @apiSuccess (Success) {String} content ??????
    * @apiSuccess (Success) {String} sign ??????
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "??????",
    *       "content":"{\"suject\":\"????????????\",\"listFile\":[],\"html\":true,\"email\":[\"wen_guoxing@itrus.com.cn\"]}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity delete(String url, HttpData data) throws IOException {
        CloseableHttpClient httpclient = createClient(data);

        HttpDelete httpDelete = new HttpDelete(url);
        // ????????????????????????
        setData(httpDelete, data);
        // ????????????????????????
        httpDelete.setConfig(getRequestConfig(data));
        // ??????????????????
        return httpclient.execute(httpDelete, responseHandler);
    }
    
    /**
    *
    * @api HttpTools.download ??????
    * @apiVersion 2.2.0
    * @apiParam {String} url ????????????
    * @apiUse HttpData
    * @apiParam {OutputStream} out ?????????
    * @apiName download
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {Integer} status ?????????
    * @apiSuccess (Success) {String} message ????????????
    * @apiSuccess (Success) {String} content ??????
    * @apiSuccess (Success) {String} sign ??????
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": 200,
    *       "message": "??????",
    *       "content":"{ok}",
    *       "sign":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static ResponseEntity download(String url, HttpData data, final OutputStream out) throws IOException {
        CloseableHttpClient httpclient = createClient(data);

        HttpPost httpPost = new HttpPost(url);
        // ????????????????????????
        setData(httpPost, data);
        // ????????????????????????
        httpPost.setConfig(getRequestConfig(data));
        // ??????????????????
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
     * ??????HttpClient
     * 
     * @return HttpClient??????
     */
    private static CloseableHttpClient createClient(HttpData data) {
        CloseableHttpClient httpclient = null;

        if (data != null && data.getCookieEnabled()) {
            httpclient = HttpClients.custom()
                    // CloseableHttpClient????????????ConnectionManager???????????????????????????false????????????ConnectionManager??????????????????????????????
                    .setConnectionManagerShared(true).setConnectionManager(cm).setDefaultCookieStore(COOKIE_STORE)
                    .build();
        } else {
            httpclient = HttpClients.custom().setConnectionManagerShared(true).setConnectionManager(cm).build();
        }

        return httpclient;
    }

    /**
    *
    * @api HttpTools.setData ???????????????
    * @apiVersion 2.2.0
    * @apiParam {HttpRequestBase} request requestBase
    * @apiUse HttpData
    * @apiName setData
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {HttpRequestBase} request requestBase
	*/
    private static void setData(HttpRequestBase request, HttpData data) throws UnsupportedEncodingException {
        /* -----------?????????????????????------------- */
        if (data.getHeaders() != null) {
            for (Entry<String, String> entry : data.getHeaders().entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        /* -----------??????get????????????------------- */
        if (request instanceof HttpGet) {
            setHttpGetParams((HttpGet) request, data);
            return;
        }

        /* -----------??????delete????????????------------- */
        if (request instanceof HttpDelete) {
            setHttpDeleteParams((HttpDelete) request, data);
            return;
        }

        /* -----------??????post????????????------------- */
        HttpPost httpPost = (HttpPost) request;

        // ?????????????????????null???????????????????????????????????????
        if (data.getPostEntity() != null) {
            httpPost.setEntity(data.getPostEntity());
            return;
        }

        // ??????????????????????????????????????????
        if (data.getFiles() == null) {
            setHttpPostParams(httpPost, data);
            return;
        }

        // ????????????????????????Multipart?????????
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        meBuilder.setCharset(Charset.forName(data.getCharset()));
        // 1?????????????????????
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
        // 2?????????????????????
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
        // ????????????????????????
        httpPost.setEntity(meBuilder.build());
    }

    /**
    *
    * @api HttpTools.setHttpGetParams ??????get????????????
    * @apiVersion 2.2.0
    * @apiParam {HttpGet} request HttpGet
    * @apiUse HttpData
    * @apiName setHttpGetParams
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {HttpGet} request HttpGet
	*/
    private static void setHttpGetParams(HttpGet request, HttpData data) throws UnsupportedEncodingException {
        if (data.getParams() == null) {
            return;
        }

        StringBuilder url = new StringBuilder(request.getURI().toString());
        // ??????url???"/"???????????????????????????"/"
        if (url.lastIndexOf("/") == url.length() - 1) {
            url.delete(url.length() - 1, url.length());
        }
        // ??????url??????"?"?????????????????????"?"
        if (url.indexOf("?") == -1) {
            url.append("?");
        }

        for (Entry<String, String> entry : data.getParams().entrySet()) {
            // url??????????????????"?",??????????????????"&"???????????????
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
    * @api HttpTools.setHttpDeleteParams ??????Delete????????????
    * @apiVersion 2.2.0
    * @apiParam {HttpDelete} request HttpDelete
    * @apiUse HttpData
    * @apiName setHttpDeleteParams
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {HttpDelete} request HttpDelete
	*/
    private static void setHttpDeleteParams(HttpDelete request, HttpData data) throws UnsupportedEncodingException {
        if (data.getParams() == null) {
            return;
        }

        StringBuilder url = new StringBuilder(request.getURI().toString());
        // ??????url???"/"???????????????????????????"/"
        if (url.lastIndexOf("/") == url.length() - 1) {
            url.delete(url.length() - 1, url.length());
        }
        // ??????url??????"?"?????????????????????"?"
        if (url.indexOf("?") == -1) {
            url.append("?");
        }

        for (Entry<String, String> entry : data.getParams().entrySet()) {
            // url??????????????????"?",??????????????????"&"???????????????
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
    * @api HttpTools.setHttpPostParams ??????post????????????
    * @apiVersion 2.2.0
    * @apiParam {HttpPost} request HttpPost
    * @apiUse HttpData
    * @apiName setHttpPostParams
    * @apiGroup HttpTools?????????
    * @apiSuccess (Success) {HttpPost} request HttpPost
	*/
    private static void setHttpPostParams(HttpPost request, HttpData data) throws UnsupportedEncodingException {
        if (data.getParams() == null) {
            return;
        }

        // ????????????????????????
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : data.getParams().entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        // ????????????????????????
        request.setEntity(new UrlEncodedFormEntity(nvps, data.getCharset()));
    }

    private static RequestConfig getRequestConfig(HttpData httpData) {
        if (httpData == null || httpData.getTimeout() == REQUEST_TIMEOUT) {
            return defaultRequestConfig;
        } else {
            return RequestConfig.custom().setSocketTimeout(httpData.getTimeout()) // ??????????????????
                    .setConnectTimeout(CONN_TIMEOUT) // ??????????????????
                    .setCookieSpec(CookieSpecs.DEFAULT).build();
        }

    }

    /***
	 * ???????????????
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
     * @apiDefine HttpData ?????????
     * 
     * @apiParam {Map} files file??????
     * @apiParam {Map} headers ???????????????
     * @apiParam {Map} params ????????????
     * @apiParam {HttpEntity} postEntity ?????????
     */
    public static class HttpData{
        //??????
        private String charset = "UTF-8"; 
        //??????????????????
        private int timeout = HttpTools.REQUEST_TIMEOUT;
        // ????????????cookie
        private boolean cookieEnabled = HttpTools.COOKIE_ENABLED;
        //????????????
        private Map<String, Object> files = null;
        //???????????????
        private Map<String, String> headers = null;
        //????????????
        private Map<String, String> params = null;
        //?????????
        private HttpEntity postEntity = null;
        
        public static HttpData instance() {
            return new HttpData();
        }
        
        
        /**
        *
        * @api HttpTools.addHeader ?????????????????????
        * @apiVersion 2.2.0
        * @apiParam {String} name ???(????????????)
        * @apiParam {Object} value ???
        * @apiName addHeader
        * @apiGroup HttpTools?????????
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
        * @api HttpTools.addParams ??????????????????
        * @apiVersion 2.2.0
        * @apiParam {Map} params Map?????????
        * @apiName addParams
        * @apiGroup HttpTools?????????
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
        * @api HttpTools.addParams ??????????????????
        * @apiVersion 2.2.0
        * @apiParam {String} name ???(????????????)
        * @apiParam {Object} value ???
        * @apiName addParams
        * @apiGroup HttpTools?????????
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
        * @api HttpTools.addParams ?????????????????????
        * @apiVersion 2.2.0
        * @apiParam {String} name ???(????????????)
        * @apiParam {File} value ???(file??????)
        * @apiName addParams
        * @apiGroup HttpTools?????????
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
        * @api HttpTools.addFile ?????????????????????
        * @apiVersion 2.2.0
        * @apiParam {String} paramName ???(????????????)
        * @apiParam {InputStream} value ???(?????????)
        * @apiParam {String} fileName ???(????????????)
        * @apiName addFile
        * @apiGroup HttpTools?????????
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
        * @api HttpTools.addFile ??????????????????????????????
        * @apiVersion 2.2.0
        * @apiParam {String} paramName ???(????????????)
        * @apiParam {byte[]} value ??????????????????
        * @apiParam {String} fileName ???(????????????)
        * @apiName addFile
        * @apiGroup HttpTools?????????
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
        /** ?????????????????????UTF-8 */
        public String getCharset() {
            return charset;
        }
    
        /** ?????????????????????UTF-8 */
        public HttpData setCharset(String charset) {
            this.charset = charset;
            return this;
        }
        
        /** ????????????????????????(??????) */
        public int getTimeout() {
            return timeout;
        }
    
        /** ????????????????????????(??????) */
        public HttpData setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }
        
        /** ??????????????????cookie*/
        public boolean getCookieEnabled() {
            return cookieEnabled;
        }
    
        /** ??????????????????cookie */
        public HttpData setCookieEnabled(boolean cookieEnabled) {
            this.cookieEnabled = cookieEnabled;
            return this;
        }
    
        /** ???????????????????????????null */
        public HttpEntity getPostEntity() {
            return postEntity;
        }
    
        /** 
         * ??????post?????????????????????addParam???addFile???????????????????????????????????????????????????
         *  1???StringEntity???????????????????????????webservice?????????xml???????????????
         *  2???InputStreamEntity??????
         *  3???ByteArrayEntity???????????????
         *  4???FileEntity?????????
         */
        public HttpData setPostEntity(HttpEntity postEntity) {
            this.postEntity = postEntity;
            return this;
        }
    
        /** ????????????????????????????????????????????????null */
        public Map<String, Object> getFiles() {
            return files;
        }
    
        /** ?????????????????????????????????????????????null */
        public Map<String, String> getHeaders() {
            return headers;
        }
    
        /** ????????????????????????????????????null */
        public Map<String, String> getParams() {
            return params;
        }
    }


    /***
     * ????????????
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
