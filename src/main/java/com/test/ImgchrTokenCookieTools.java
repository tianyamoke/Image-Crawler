package com.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URLDecoder;

/**
 *
 *
 * @author lixing
 * @date 2020/4/6
 */
public class ImgchrTokenCookieTools {

    public static void main(String[] args) {
        String result = get("http://imgchr.com");
        int start = result.indexOf("PF.obj.config.auth_token =")+28;
        int end = start+40;
        System.out.println(result.substring(start,end));
    }


    public static String get(String url){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        StringBuilder entityStringBuilder = new StringBuilder();
        try {
            HttpResponse res = client.execute(get);
            String setCookie = res.getHeaders("Set-Cookie")[0].toString().split(";")[0];
            System.out.println(setCookie.substring(12,setCookie.length()));
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity httpEntity=res.getEntity();
                if (httpEntity!=null) {
                    BufferedReader bufferedReader = new BufferedReader
                            (new InputStreamReader(httpEntity.getContent(), "UTF-8"), 1024);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        entityStringBuilder.append(line);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            if (client != null) {
                try {
                    client.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return entityStringBuilder.toString();
    }

    public static void readInputStream(InputStream inStream, String path) throws Exception{
        FileOutputStream fos = new FileOutputStream(new File(path));
        byte[] buffer = new byte[102400];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            fos.write(buffer, 0, len);
        }
        inStream.close();
        fos.flush();
        fos.close();
    }


}
