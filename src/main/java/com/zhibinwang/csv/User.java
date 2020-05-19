package com.zhibinwang.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

/**
 * @author 花开
 * @create 2020-05-18 20:55
 * @desc
 **/

public class User {

    @CsvBindByName(column = "编号(id)", required = true)
    private String id;
    @CsvBindByName(column = "姓名(name)", required = true)
    private String name;
    @CsvBindByName(column = "性别(sex)", required = true)
    private String sex;
    @CsvBindByName(column = "年龄(age)", required = true)
    private String age;
    @CsvBindByName(column = "城市(city)", required = true)
    private String city;
    @CsvBindByName(column = "职业(job)", required = true)
    private String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
