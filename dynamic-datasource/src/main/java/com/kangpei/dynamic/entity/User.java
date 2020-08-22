package com.kangpei.dynamic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * description: User <br>
 * date: 2020/8/22 7:45 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Data
@TableName("user")
public class User implements Serializable {

    private Long id;
    private String name;
    private String phone;

    public User() {}

}
