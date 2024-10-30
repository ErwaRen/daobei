package com.daobei.utils;

public class CrawlerUtils {


    public static void main(String[] args) {
        String content = UrlUtils.getContent("https://www.sesemanhua.top/index.php/chapter/13115");
        System.out.println(content);
    }


}
