package com.zhibinwang.service;

import com.zhibinwang.csv.User;
import com.zhibinwang.util.CsvUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 花开
 * @create 2020-05-18 21:31
 * @desc
 **/
@Service
public class UserServiceImpl implements  IUserService {
    
    private List<User> list;
    
    public UserServiceImpl(){
        try {
            list = CsvUtil.getCsvData(new File("D:\\bda\\机试题\\人员名单.csv"),User.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getUser(String cityName) {
        List<User> userList = new ArrayList<>();
        for (User user : list) {
            if (cityName.equals(user.getCity())){
                userList.add(user);
            }
        }
        return userList;
    }
}
