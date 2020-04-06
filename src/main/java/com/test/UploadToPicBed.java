package com.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/**
 *
 *
 * @author lixing
 * @date 2020/4/4
 */
public class UploadToPicBed {

    private static final String API_URL = "https://imgchr.com/json";

    public static void main(String[] args) throws Exception {
//        upload("/Users/cayley/Downloads/weixin/0c08d024-26bf-41c4-ab04-10aac5ca713a.jpeg");
        httpPost(API_URL,null);
    }

    private static JSONObject httpPost(String url,JSONObject jsonParam){
        HttpClient httpClient = new DefaultHttpClient();
        JSONObject jsonResult = new JSONObject();
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200 || result.getStatusLine().getStatusCode()==500) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.parseObject(str);
                    return jsonResult;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void upload(String filePath) throws Exception {
        File file = new File(filePath);
        String url = API_URL;

        HttpPost method = new HttpPost(url);
        JSONObject jsonResult = null;
        HttpClient httpClient = new DefaultHttpClient();
        try {

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addBinaryBody("chart",file);
            HttpEntity httpEntity = multipartEntityBuilder.build();
            //解决中文乱码问题
            method.setEntity(httpEntity);

            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            int noContentCode = 201;
            if (result.getStatusLine().getStatusCode() == noContentCode) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    /**把json字符串转换成json对象**/
                    System.out.println(str);
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
