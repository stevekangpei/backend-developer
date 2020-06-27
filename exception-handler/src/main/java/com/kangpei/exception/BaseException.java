package com.kangpei.exception;

import com.kangpei.constant.Status;
import lombok.Data;

/**
 * description: BaseException <br>
 * date: 2020/6/27 8:45 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Data
public class BaseException extends RuntimeException{

    private Integer code;

    private String msg;

    public BaseException(Integer code, String msg) {

        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(Status status) {

        super(status.getMessage());
        this.msg = status.getMessage();
        this.code = status.getCode();
    }

}
