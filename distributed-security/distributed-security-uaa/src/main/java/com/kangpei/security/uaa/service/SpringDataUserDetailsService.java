package com.kangpei.security.uaa.service;

import com.alibaba.fastjson.JSON;
import com.kangpei.security.uaa.dao.UserDao;
import com.kangpei.security.uaa.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: SpringDataUserDetailsService <br>
 * date: 2020/7/25 6:37 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //将来连接数据库根据账号查询用户信息
        UserDto userDto = userDao.getUserByUsername(s);
        if (userDto == null) {
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> permissions = userDao.findPermissionsByUserId(userDto.getId());
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        //将userDto转成json
        String principal = JSON.toJSONString(userDto);
        UserDetails userDetails = User.withUsername(principal).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;

    }
}
