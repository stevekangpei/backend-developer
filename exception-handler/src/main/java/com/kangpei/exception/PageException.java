package com.kangpei.exception;

import com.kangpei.constant.Status;

/**
 * description: PageException <br>
 * date: 2020/6/27 8:54 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
public class PageException extends BaseException{


    public PageException(Integer code, String msg) {
        super(code, msg);
    }

    public PageException(Status status) {
        super(status);
    }
}
