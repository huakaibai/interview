package com.zhibinwang.http;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 花开
 * @create 2020-05-18 20:36
 * @desc
 **/
public class TestHttp {

    public static void main(String[] args) throws IOException {
        HttpClient httpclient  = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet("https://www.sogou.com");
        HttpResponse response = httpclient.execute(httpget);

        Header[] allHeaders = response.getAllHeaders();
       /* for (Header allHeader : allHeaders) {
            System.out.println(allHeader);
        }*/
        Map<String, String> map = new HashMap<String, String>();
        Header[] headers = response.getHeaders("Set-Cookie");
        for (Header header : headers) {
            System.out.println(header);
            String s1 = header.toString();
            String s = header.toString().substring(s1.indexOf(":")+1);
            String[] cookies = s.split(";");
            for (String cookie : cookies) {
                String[] keyValue = cookie.split("=");

               if (keyValue.length > 1){
                   map.put(keyValue[0],keyValue[1]);
               }

            }
        }

        System.out.println(map);
    }
}
