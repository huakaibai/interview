package com.zhibinwang.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.util.List;

public class CsvUtil {


    public static  <T> List<T> getCsvData(File file, Class<T> clazz) throws FileNotFoundException, UnsupportedEncodingException {


        InputStreamReader in = new InputStreamReader(new FileInputStream(file), "utf-8");


        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<T>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }
}
