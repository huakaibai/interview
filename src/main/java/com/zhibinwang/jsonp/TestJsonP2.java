package com.zhibinwang.jsonp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 花开
 * @create 2020-05-18 21:41
 * @desc
 **/
public class TestJsonP2 {

    public static void main(String[] args) throws IOException {

        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();
        String path = com.getPath()+"/jd/";
        File jd = new File(path);
        if (!jd.exists())   {
            jd.mkdir();
        }


        Document document = Jsoup.connect("https://search.jd.com/Search?keyword=java&enc=utf-8&wq=java&pvid=e01d294d58fb49b2ad65feae72f46da6").get();
        Elements select1 = document.select("#J_goodsList ul li");
        for (Element element : select1) {
            String src = element.select("img").attr("src");
            String name = element.select(".p-name em").text();

         //   这就搞定了  记住这个操作过程  把你要循环的东西 打DEBUGGER到目的地 然后用 这个 调试

            System.out.println(element);
        }
       /* Elements elementsByClass = document.getElementsByClass("gl-i-wrap");
        Elements select = document.select("gl-i-wrap");
        for (Element element : select) {
            System.out.println(element);
        }


        for (Element elementWrap : elementsByClass) {



            String name = null;
            Elements elementsName= elementWrap.getElementsByClass("p-name p-name-type-2");
            for (Element element : elementsName) {
                Elements em = element.getElementsByTag("em");
                name = em.get(0).text();
            }
            String imgUrl = null;
            Elements elementImg = elementWrap.getElementsByClass("p-img");
            for (Element element : elementImg) {

                Elements a = element.getElementsByTag("a");
              //  System.out.println(a);
                Elements img = a.get(0).getElementsByTag("img");
            //    System.out.println(img);
                imgUrl =  img.get(0).attr("src");
              // System.out.println(img.get(0).getElementsByAttribute("src"));
            }
            if (name != null && imgUrl != null)  {
                System.out.println(imgUrl);
              //  System.out.println(name);
               // System.out.println(path);
               downloadPicture("http:"+imgUrl, path + name+".jpg");
            }
        }*/
    }



    public static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
