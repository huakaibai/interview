package com.zhibinwang.service;

import com.zhibinwang.csv.User;

import java.util.List;

/**
 * @author 花开
 * @create 2020-05-18 21:31
 * @desc
 **/
public interface IUserService {

    List<User> getUser(String cityName);
}
