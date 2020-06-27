package com.kangpei.constant;

import lombok.Getter;

/**
 * 状态码的封装
 * description: Status <br>
 * date: 2020/6/27 8:41 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Getter
public enum  Status {

    OK(200, "操作成功"),
    UNKNOWN_ERROR(500, "操作失败");

    private Integer code;
    private String message;

    Status(Integer code, String message) {

        this.code = code;
        this.message = message;
    }
}
