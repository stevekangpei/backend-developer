package com.kangpei.exception;

import com.kangpei.constant.Status;

/**
 * description: ApiException <br>
 * date: 2020/6/27 10:44 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
public class ApiException extends BaseException{


    private Integer code;
    private String msg;

    public ApiException(Integer code, String msg, Integer code1, String msg1) {
        super(code, msg);
        this.code = code1;
        this.msg = msg1;
    }

    public ApiException(Status status,  String msg) {
        super(status);
        this.msg = msg;
    }
}
