package com.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.helper.StringUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 * @author lixing
 * @date 2020/4/5
 */
public class ImgchrUpload {

    public static void main(String[] args) throws Exception {
        upload("/Users/cayley/Downloads/weixin/70071934-012e-4733-870c-d7c0ce1eafb3.png","PHPSESSID=2boip5ar5hbpb0eh8hmeic6r48","e8380863e94dacf8986ec176cba48f316fdd6606");
    }

    public static String upload(String filePath,String cookie,String authToken) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = null;
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
        HttpPost httpPost = new HttpPost("https://imgchr.com/json");
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Cookie",cookie);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        //multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));

        //File file = new File("F:\\Ken\\1.PNG");
        //FileBody bin = new FileBody(file);

        File file = new File(filePath);

        //multipartEntityBuilder.addBinaryBody("file", file,ContentType.create("image/png"),"abc.pdf");
        //当设置了setSocketTimeout参数后，以下代码上传PDF不能成功，将setSocketTimeout参数去掉后此可以上传成功。上传图片则没有个限制
        //multipartEntityBuilder.addBinaryBody("file",file,ContentType.create("application/octet-stream"),"abd.pdf");
        multipartEntityBuilder.addBinaryBody("source",file);
        //multipartEntityBuilder.addPart("comment", new StringBody("This is comment", ContentType.TEXT_PLAIN));
        multipartEntityBuilder.addTextBody("type", "file");
        multipartEntityBuilder.addTextBody("action", "upload");
        multipartEntityBuilder.addTextBody("timestamp", System.currentTimeMillis()+"");
        multipartEntityBuilder.addTextBody("auth_token", authToken);
        multipartEntityBuilder.addTextBody("nsfw", "0");

        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);

        String displayUrl = "";
        System.out.println("开始上传......");
        httpResponse = httpClient.execute(httpPost);
        System.out.println("上传完成......");
        HttpEntity responseEntity = httpResponse.getEntity();
        int statusCode= httpResponse.getStatusLine().getStatusCode();
        if(statusCode == 200 || statusCode ==400){
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            StringBuffer buffer = new StringBuffer();
            String str = "";
            while(!StringUtil.isBlank(str = reader.readLine())) {
                buffer.append(str);
            }

            JSONObject obj = JSONObject.parseObject(buffer.toString());
            JSONObject image = (JSONObject) obj.get("image");
            if(image==null){
                System.out.println(obj.toString());
                throw new Exception("token过期");
            }
            displayUrl = image.get("display_url").toString();
        }

        httpClient.close();
        if(httpResponse!=null){
            httpResponse.close();
        }
        return displayUrl;

    }

}
