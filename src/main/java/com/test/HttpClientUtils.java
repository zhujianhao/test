package com.test;


import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class HttpClientUtils {
    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static PoolingHttpClientConnectionManager poolConnManager ;
    private final static int maxTotalPool = 100;
    private final static int maxConPerRoute = 50;

//    private static CloseableHttpClient httpClient=null;

    private static RequestConfig defaultRequestConfig = null;
    //初始化代码：
    static {
        try {
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .build();
            //初始化连接管理器
            poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            // Increase max total connection to 200
            poolConnManager.setMaxTotal(maxTotalPool);
            // Increase default max connection per route to 20
            poolConnManager.setDefaultMaxPerRoute(maxConPerRoute);

//            poolConnManager.setDefaultConnectionConfig();

            defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(30000)
                    .setConnectTimeout(40000)
                    .setConnectionRequestTimeout(50000)
                    .build();

        } catch (Exception e) {
            logger.error("HttpClientUtils init error", e);
        }
    }


    /**
     * 获取连接池中一个连接
     * @return 连接池中一个连接
     */
    public static CloseableHttpClient getConnection()
    {


        CloseableHttpClient httpClient = HttpClients.custom()
                    .setConnectionManager(poolConnManager).setDefaultRequestConfig(defaultRequestConfig).build();

        return httpClient;
    }

    /**
     * 发送post请求
     * @param url post请求地址
     * @param jsonRequest 请求参数，json格式的字符串
     * @return  json格式的字符串
     * @throws IOException
     */
    public static String post(String url, String jsonRequest) throws IOException {

        String sResult = null;
        //参数检测
        if(url==null||"".equals(url))
        {
            logger.error("post请求，url为null。");
            return sResult;
        }
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                return value == null;
            }
        });

        CloseableHttpClient httpclient = getConnection();

        CloseableHttpResponse response=null;
        HttpPost httppost = new HttpPost(url);
        try {
            httppost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            HttpEntity reqEntity = EntityBuilder.create()
                    .setContentType(ContentType.APPLICATION_JSON)  //.TEXT_PLAIN
                    .setContentEncoding("UTF-8")
                    .setText(new JSONObject().fromObject(jsonRequest, config).toString())
                    .build();
            httppost.setEntity(reqEntity);

            response = httpclient.execute(httppost);
            //获取响应状态码
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity resEntity = response.getEntity();
                sResult = resEntity != null ? EntityUtils.toString(resEntity, "UTF-8") : null;
            } else {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer resultRes = new StringBuffer();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    resultRes.append(line);
                }

                sResult = resultRes.toString();

                logger.error("post请求返回异常，[url为=" + url + ",jsonRequest=" + jsonRequest + "][响应 status=" + status + ", sResult=" + sResult + "]");
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            logger.debug("post请求成功，[url为=" + url + ",jsonRequest=" + jsonRequest + "][响应 sResult=" + sResult + "]");

        } catch (Exception e) {
            httppost.abort();
            logger.error("post请求异常，[url为=" + url + ",jsonRequest=" + jsonRequest + "]",e);
        } finally {
            httppost.completed();
            if (null != response){
                response.close();
            }
        }
        return sResult;
    }


    /**
     * 发送post请求
     * @param url post请求地址
     * @param params 请求参数
     * @return  json格式的字符串
     * @throws IOException
     */
    public static String post(String url, List<NameValuePair> params) throws IOException {

        String sResult = null;
        //参数检测
        if(url==null||"".equals(url))
        {
            logger.error("post请求，url为null。");
            return sResult;
        }
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                return value == null;
            }
        });

        CloseableHttpClient httpclient = getConnection();
        CloseableHttpResponse response=null;

        HttpPost httppost = new HttpPost(url);
        try {
            httppost.addHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");

            UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(params, "UTF-8");
//
////            UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(params);  //,"UTF-8"
//            reqEntity.setContentType("application/x-www-form-urlencoded");
//            reqEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
//                    "application/x-www-form-urlencoded"));
            httppost.setEntity(reqEntity);

            response = httpclient.execute(httppost);
            //获取响应状态码
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity resEntity = response.getEntity();
                logger.debug("请求-ContentType：" + reqEntity.getContentType().getValue());

                if(resEntity.getContentType() != null) {
                    logger.debug("响应-ContentType：" + resEntity.getContentType().getValue());
                }

                sResult = resEntity != null ? EntityUtils.toString(resEntity, "UTF-8") : null;
            } else {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer resultRes = new StringBuffer();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    resultRes.append(line);
                }

                sResult = resultRes.toString();

                logger.error("post请求返回异常，[url为=" + url + ",params=" + params.toString() + "][响应 status=" + status + ", sResult=" + sResult + "]");
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            logger.debug("post请求成功，[url为=" + url + ",params=" + params.toString() + "][响应 sResult=" + sResult + "]");
        } catch (Exception e) {
            httppost.abort();
            logger.error("post请求异常，[url为=" + url + ",params=" + params.toString() + "]", e);
        } finally {
            if (null != response){
                response.close();
            }
        }
        return sResult;
    }




    /**
     * 发送post请求
     * @param url post请求地址
     * @param params 请求参数
     * @return  json格式的字符串
     * @throws IOException
     */
    public static String post(String url, Map<String,String> params) throws IOException {

        String sResult = null;
        String key;

        List<NameValuePair> lsParams = new ArrayList<NameValuePair>();
        for(Iterator<String> it =params.keySet().iterator();it.hasNext(); ){
            key = it.next();
            lsParams.add(new BasicNameValuePair(key,params.get(key)));
        }

        sResult = post(url,lsParams);
        return sResult;
    }

    public static String sslGet(String url) throws IOException {
        HttpGet get = new HttpGet();


        try {
            get.setURI(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response =  httpclient.execute(get);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer resultRes = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            resultRes.append(line);
        }

        String sResult = resultRes.toString();

        return sResult;
    }

    public static CloseableHttpClient createSSLClientDefault(){
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain,
                                         String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return  HttpClients.createDefault();
    }

    public static void main(String[] args){



    }

}



