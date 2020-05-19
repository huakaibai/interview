package com.zhibinwang.dic;

import java.io.File;

/**
 * @author 花开
 * @create 2020-05-18 22:16
 * @desc 测试目录
 **/
public class TestDic {

    public static void main(String[] args) {

        openFile("D:\\bda\\机试题\\repo",0);
    }


    public static void openFile(String path,int j){
        File parentFile = new File(path);
        for (int i = 0 ; i < j ;i++){
            System.out.print("    ");
        }
        System.out.println(parentFile.getName());
        int temp = j+1;

        File[] files = parentFile.listFiles();
        for (File file1 : files) {

            if (file1.isFile()){

                for (int i = 0 ; i < temp ;i++){
                    System.out.print("    ");
                }
                System.out.println(file1.getName());
            }else {
                j = temp - 1;
                openFile(file1.getPath(),++j);
            }
        }

    }

}
