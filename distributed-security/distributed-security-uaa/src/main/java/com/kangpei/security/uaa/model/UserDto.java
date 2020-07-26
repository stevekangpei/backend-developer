package com.kangpei.security.uaa.model;

import lombok.Data;

/**
 * description: UserDto <br>
 * date: 2020/7/20 12:38 上午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
