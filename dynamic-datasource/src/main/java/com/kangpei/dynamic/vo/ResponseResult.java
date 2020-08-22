package com.kangpei.dynamic.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: ResponseResult <br>
 * date: 2020/8/22 7:55 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseResult<T> {

    private boolean success;
    private String errCode;
    private String errMsg;
    private String errShowMsg;
    private T resultData;


    public static <T> ResponseResult of(boolean success, T resultData, String errCode,
                                        String errShowMsg, String errMsg) {
        return new ResponseResult(success, errCode, errMsg, errShowMsg, resultData);
    }

    public static <T> ResponseResult success(T data) {
        return of(true, data, null, null, null);
    }

    public static <T> ResponseResult error(String errShowMsg) {
        return of(false, null, null, errShowMsg, null);
    }
}
