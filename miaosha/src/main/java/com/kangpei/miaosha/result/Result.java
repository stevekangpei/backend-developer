package com.kangpei.miaosha.result;

/**
 * description: Result <br>
 * date: 2020/7/26 9:06 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    private Result(CodeMsg msg) {

        if(msg == null) {
            return;
        }
        this.code = msg.getCode();
        this.msg = msg.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {

        return new Result<T>(0, "success", data);
    }

    public static <T> Result<T> error(CodeMsg msg) {

        return new Result<T>(msg);
    }
}
