package com.kangpei.service;

import com.kangpei.model.User;
import org.springframework.stereotype.Service;

/**
 * description: UserService <br>
 * date: 2020/6/27 10:18 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Service
public class UserService {


    public String addUser(User user) {

        return "success";
    }

}
