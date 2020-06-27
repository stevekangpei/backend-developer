package com.kangpei.resp;

import com.kangpei.constant.Status;
import com.kangpei.exception.BaseException;
import lombok.Data;

/**
 * description: ApiResponse <br>
 * date: 2020/6/27 9:05 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Data
public class ApiResponse {

    private Integer code;

    private String msg;

    private Object data;


    public ApiResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造一个空参构造器返回。
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public ApiResponse of(Integer code, String msg, Object data) {

        return new ApiResponse(code, msg, data);
    }

    public ApiResponse ofSuccess(Object data) {

        return  fromStatus(Status.OK, data);
    }

    public ApiResponse ofFailure(Object data) {

        return  fromStatus(Status.UNKNOWN_ERROR, data);
    }


    public ApiResponse fromStatus(Status status, Object data) {
        return new ApiResponse(status.getCode(), status.getMessage(), data);
    }

    public static <T extends BaseException> ApiResponse ofException(T t, Object data) {
        return new ApiResponse(t.getCode(), t.getMsg(), data);
    }

    public static <T extends BaseException> ApiResponse ofException(T t) {
        return ofException(t, null);
    }
}
