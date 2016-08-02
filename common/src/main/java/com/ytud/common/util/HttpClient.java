package com.ytud.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * yangch 2016/7/29
 */
public class HttpClient {

    private final String HTTP_POST = "post";
    private final String HTTP_GET = "get";

    /**
     * post请求
     *
     * @param url     地址
     * @param params  参数
     * @param charset
     * @return
     */
    public String post(String url, Map<String, String> params, String charset) {
        return execute(HTTP_POST, url, params, charset);
    }

    private String execute(String httpType, String url, Map<String, String> params, String charset) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        HttpGet httpGet = null;
        HttpResponse response = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            switch (httpType) {
                case HTTP_POST:
                    httpPost = new HttpPost(url);
                    response = httpClient.execute(httpPost);
                    break;
                case HTTP_GET:
                    httpGet = new HttpGet(url);
                    response = httpClient.execute(httpGet);
                    
                    break;
            }
            //result.getStatusLine().getStatusCode() == 200
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
