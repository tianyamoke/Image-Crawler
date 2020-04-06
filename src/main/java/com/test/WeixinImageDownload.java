package com.test;

import com.alibaba.fastjson.JSONObject;
import com.test.Patterns;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 *
 *
 * @author lixing
 * @date 2020/4/4
 */
public class WeixinImageDownload {

    public static void main(String[] args) throws Exception {
        File file = new File("1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;

        file = new File("new.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);

        int count = 1;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            Matcher matcher = Patterns.WEB_URL.matcher(s);
            if (matcher.find()){
                String oldUrl = matcher.group();
                //先找到图片地址
                if(oldUrl.startsWith("https://mmbiz.qpic.cn/")){
                    System.out.println("上传第   " + count +"   张图片");
                    String jsonString = HttpUtils.get("https://api.uomg.com/api/image.360?imgurl="+oldUrl);
                    Object obj = JSONObject.parseObject(jsonString).get("imgurl");
                    if(obj==null){

                    }else{
                        String imgurl = obj.toString();
                        oldUrl = oldUrl.substring(0,oldUrl.indexOf("?"));
                        s = s.replaceAll(oldUrl,imgurl);
                    }
                    count ++;
                }
            }
            fw.write(s.toString());
        }
        fw.flush();
        fw.close();
        br.close();

    }

    //链接url下载图片
    public static String downloadPicture(String urlList,String path,String suffix) throws Exception {
        URL url;
        String filePath = "";
        try {
            url = new URL(urlList);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            String savePath = "/Users/cayley/Downloads/"+path+"/";
            File imgDir = new File(savePath);
            filePath = savePath+ UUID.randomUUID().toString()+"."+suffix;
            if(!imgDir.exists()){
                imgDir.mkdirs();
            }
            HttpUtils.readInputStream(inStream, filePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

}
