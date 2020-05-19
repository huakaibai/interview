package com.zhibinwang.csv;

import com.alibaba.fastjson.JSON;
import com.zhibinwang.util.CsvUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 花开
 * @create 2020-05-18 21:02
 * @desc 测试csv
 **/
public class TestCsv {

    public static void main(String[] args) {
        File file = new File("D:\\bda\\机试题\\人员名单.csv");


        List<User> csvData = null;
        try {
            csvData = CsvUtil.getCsvData(file, User.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String s = JSON.toJSONString(csvData);
        System.out.println(s);
    }
}
