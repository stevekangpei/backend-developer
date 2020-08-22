package com.kangpei.dynamic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.kangpei.dynamic.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: UserMapper <br>
 * date: 2020/8/22 7:47 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

   List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
