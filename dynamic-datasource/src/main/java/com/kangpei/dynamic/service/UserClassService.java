package com.kangpei.dynamic.service;

import com.kangpei.dynamic.annotation.DS;
import com.kangpei.dynamic.constant.DSConstant;
import com.kangpei.dynamic.entity.User;
import com.kangpei.dynamic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: UserClassWrapper <br>
 * date: 2020/8/22 7:50 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@DS(DSConstant.MASTER)
@Service
public class UserClassService {

    @Autowired
    private UserMapper userMapper;

    public List<User>  queryUsers() {
        return userMapper.selectAll(null);
    }
}
