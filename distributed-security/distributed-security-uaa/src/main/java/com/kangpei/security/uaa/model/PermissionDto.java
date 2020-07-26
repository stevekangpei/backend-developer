package com.kangpei.security.uaa.model;

import lombok.Data;

/**
 * description: PermissionDto <br>
 * date: 2020/7/20 12:37 上午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Data
public class PermissionDto {

    private String id;
    private String code;
    private String description;
    private String url;
}
