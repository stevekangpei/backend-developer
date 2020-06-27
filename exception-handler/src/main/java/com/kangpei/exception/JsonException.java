package com.kangpei.exception;

import com.kangpei.constant.Status;

/**
 * description: JsonExpection <br>
 * date: 2020/6/27 8:53 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
public class JsonException extends BaseException{


    public JsonException(Integer code, String msg) {
        super(code, msg);
    }

    public JsonException(Status status) {
        super(status);
    }
}
