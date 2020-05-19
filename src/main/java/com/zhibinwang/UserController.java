package com.zhibinwang;

import com.zhibinwang.csv.User;
import com.zhibinwang.service.IUserService;
import com.zhibinwang.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 花开
 * @create 2020-05-18 21:28
 * @desc
 **/
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/persons/{cityName}")
    public List<User> getUser(@PathVariable("cityName") String cityName){
        return userService.getUser(cityName);
    }


}
