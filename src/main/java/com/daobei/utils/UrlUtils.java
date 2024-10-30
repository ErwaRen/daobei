package com.daobei.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlUtils {

    /**
     * 获取网站内容
     * @param strUrl url str
     * @return result
     */
    public static String getContent(String strUrl) {
        try {
            String result = null;
            StringBuffer sb = new StringBuffer();
            URL url = new URL(strUrl);
            //通过url建立与网页的连接
            URLConnection conn=url.openConnection();
            //通过链接取得网页返回的数据
            InputStream is=conn.getInputStream();
            System.out.println(conn.getContentEncoding());
            //一般按行读取网页数据，并进行内容分析
            //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
            //进行转换时，需要处理编码格式问题
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
            //按行读取并打印
            String line = null;
            while((line = br.readLine()) != null){
                // System.out.println(line);
                sb.append(line);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
