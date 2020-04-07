package com.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.net.URLDecoder;

/**
 *
 *
 * @author lixing
 * @date 2020/4/6
 */
public class ImgchrFileUpload {

    private static final String IMGCHR_URL = "https://imgkr.com/api/files/upload";

    public static void main(String[] args) throws Exception {
        JSONObject json = upload("/Users/cayley/Downloads/22.png");
        System.out.println(json);
    }

    public static JSONObject upload(String filePath) throws Exception {
        File file = new File(filePath);

        HttpPost method = new HttpPost(IMGCHR_URL);
        JSONObject jsonResult = null;
        HttpClient httpClient = new DefaultHttpClient();
        try {

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addBinaryBody("file",file);
            HttpEntity httpEntity = multipartEntityBuilder.build();
            //解决中文乱码问题
            method.setEntity(httpEntity);

            HttpResponse result = httpClient.execute(method);
            /**请求发送成功，并得到响应**/
            int noContentCode = 200;
            if (result.getStatusLine().getStatusCode() == noContentCode) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}
