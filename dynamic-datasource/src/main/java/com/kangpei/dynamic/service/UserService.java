package com.kangpei.dynamic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kangpei.dynamic.annotation.DS;
import com.kangpei.dynamic.constant.DSConstant;
import com.kangpei.dynamic.entity.User;
import com.kangpei.dynamic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: UserService <br>
 * date: 2020/8/22 7:50 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @DS(DSConstant.MASTER)
    public List<User> getMasterUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectAll(wrapper.isNotNull("name"));
    }


    @DS(DSConstant.SLAVE)
    public List<User> getSlaveUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectAll(wrapper.isNotNull("name"));
    }



}
