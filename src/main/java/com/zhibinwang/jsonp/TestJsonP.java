package com.zhibinwang.jsonp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author 花开
 * @create 2020-05-18 20:13
 * @desc TestJsonp
 **/
public class TestJsonP {

    public static void main(String[] args) {

        try {
            Document document = Jsoup.parse(new File("d://第1题网页源文件.html"), "utf-8");
            Elements elementsByClass = document.getElementsByClass("price J-p-100004404948");

            for (int i =0; i < elementsByClass.size();i++){
                System.out.println(elementsByClass.get(i).text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
