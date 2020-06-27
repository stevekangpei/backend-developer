package com.kangpei.resp;

import com.kangpei.constant.Status;
import lombok.Data;

/**
 * description: ResultVo <br>
 * date: 2020/6/27 10:48 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Data
public class ResultVo<T> {

    private Integer code;
    private String msg;

    private T data;

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(T data) {
        this.code = Status.OK.getCode();
        this.msg = Status.OK.getMessage();
        this.data = data;
    }

    public ResultVo<T> OKResult(T data) {

        return new ResultVo<>(Status.OK.getCode(), Status.OK.getMessage(), data);
    }
}
