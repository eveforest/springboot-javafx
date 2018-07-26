package com.kingyea.kim.core.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static RequestConfig requestConfig = null;
    private static final String DEFAULT_CHARSET = "utf-8";

    static {
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
    }

    public static JSONObject httpPost(String url, Map<String, String> headers, JSONObject jsonParam) {
        return httpPost(url, headers, jsonParam, DEFAULT_CHARSET);
    }

    /**
     * post请求传输json参数
     *
     * @param url       url地址
     * @param headers
     * @param jsonParam 参数
     * @return
     */
    public static JSONObject httpPost(String url, Map<String, String> headers, JSONObject jsonParam,String charset) {
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        //设置请求头
        setHeader(headers, httpPost);
        if (null != jsonParam) {
            StringEntity entity = new StringEntity(jsonParam.toString(), charset);
            httpPost.setEntity(entity);
        }
        jsonResult = executeRequest(httpPost);
        return jsonResult;
    }


    public static JSONObject httpPost(String url,Map<String,String> headers, Map<String,String> bodyParams) {
        return httpPost(url, headers, bodyParams, DEFAULT_CHARSET);
    }

    /**
     * post请求传输String参数 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     *
     * @param url
     * @param headers   map
     * @param bodyParams map
     * @return
     */
    public static JSONObject httpPost(String url,Map<String,String> headers, Map<String,String> bodyParams,String charset) {
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        //请求配置
        httpPost.setConfig(requestConfig);
        //设置请求头
        setHeader(headers, httpPost);
        //设置请求参数
        if (null != bodyParams ) {
            // 解决中文乱码问题
            List<NameValuePair> paramList = new ArrayList<>();
            bodyParams.forEach((k,v)->{
                paramList.add(new BasicNameValuePair(k, v));
            });

            UrlEncodedFormEntity entity = null;
            try {
                entity = new UrlEncodedFormEntity(paramList, charset);
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(),e);
            }
            httpPost.setEntity(entity);
        }
        jsonResult = executeRequest(httpPost);
        return jsonResult;
    }


    public static JSONObject httpPost(String url,Map<String,String> headers, String strParam) {
        return httpPost(url, headers, strParam, DEFAULT_CHARSET);
    }

    /**
     * post请求传输String参数 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     *
     * @param url      url地址
     * @param headers   请求头map
     * @param strParam 参数string
     * @return
     */
    public static JSONObject httpPost(String url,Map<String,String> headers, String strParam,String charset) {
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        //请求配置
        httpPost.setConfig(requestConfig);
        //设置请求头
        setHeader(headers, httpPost);
        //设置body参数
        if (null != strParam) {
            // 解决中文乱码问题
            StringEntity entity = new StringEntity(strParam, charset);
            httpPost.setEntity(entity);
        }
        jsonResult = executeRequest(httpPost);
        return jsonResult;
    }


    public static JSONObject httpGet(String url){
        return httpGet(url,null);
    }

    public static JSONObject httpGet(String url,Map<String,String> headers){
        return httpGet(url,headers,DEFAULT_CHARSET);
    }
    /**
     * 发送get请求
     *
     * @param url 路径
     * @return
     */
    public static JSONObject httpGet(String url,Map<String,String> headers,String charset) {
        // get请求返回结果
        JSONObject jsonResult = null;
        // 发送get请求
        HttpGet httpGet = new HttpGet(url);
        //配置请求
        httpGet.setConfig(requestConfig);
        //设置请求头
        setHeader(headers,httpGet);

        jsonResult = executeRequest(httpGet);
        return jsonResult;
    }

    private static void setHeader(Map<String,String> headers, HttpUriRequest request) {
        if (headers == null || headers.size() <= 0) {
            headers = getDefaultHeaders();
        }
        headers.forEach((k,v) ->{
            request.setHeader(k, v);
        });
    }

    public static Map<String,String> getDefaultHeaders() {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put(HTTP.CONTENT_TYPE, "application/json");
        headerMap.put(HTTP.CONTENT_ENCODING, "UTF-8");
        headerMap.put("Accept", "application/json");
        return headerMap;
    }

    private static JSONObject executeRequest(HttpRequestBase requestBase) {
        JSONObject jsonResult = null;
        try {
            // post请求返回结果
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(requestBase);
            // 请求发送成功，并得到响应
            jsonResult = getJsonResult(response);
        } catch (Exception e) {
            logger.error(requestBase.getMethod()+"请求提交失败:" + requestBase.getURI(), e);
        } finally {
            requestBase.releaseConnection();
        }
        return jsonResult;
    }

    private static JSONObject getJsonResult(CloseableHttpResponse response) throws Exception {
        JSONObject jsonResult = null;

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

            // 读取服务器返回过来的json字符串数据
            String strResult = EntityUtils.toString(response.getEntity(), "utf-8");

            ContentType contentType = ContentType.get(response.getEntity());
            if (contentType == null) {
                throw new HttpException("header [content-type] not found.");
            }

            String mimeType = contentType.getMimeType();
            if (StringUtils.isBlank(mimeType) ) {
                throw new HttpException("header [content-type] is invaliable.");

                // 把json字符串转换成json对象
            }else if (StringUtils.equals(ContentType.APPLICATION_JSON.getMimeType(), mimeType)) {
                jsonResult = JSONObject.parseObject(strResult);

                // 把key-value字符串转换成json对象
            } else if (StringUtils.equals(ContentType.TEXT_PLAIN.getMimeType(), mimeType)) {
                jsonResult = new JSONObject();
                String ln = System.getProperty("line.separator", "/n");
                String[] split = StringUtils.split(strResult, ln);
                for (String line : split) {
                    String[] split1 = StringUtils.split(line, ":");
                    jsonResult.put(split1[0],split1[1]);
                }
            } else {
                throw new Exception("other content-type:  "+mimeType);
            }
        }
        return jsonResult;
    }

}
