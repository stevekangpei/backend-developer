package com.kangpei.handler;

import com.kangpei.constant.Status;
import com.kangpei.exception.ApiException;
import com.kangpei.resp.ResultVo;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * description: ExceptionControllerAdvice <br>
 * date: 2020/6/27 10:36 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
// Rest 用来处理是RestController标记的接口
@RestControllerAdvice(basePackages = {"com.kangpei"})
public class ExceptionControllerAdvice {


    // 这个方法专门用来处理MethodArgumentNotValid Exception的异常。也就是我们
    // 之前的接口参数不合法的异常。
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultVo<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return new ResultVo<>(Status.UNKNOWN_ERROR.getCode(), "校验失败", allErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(value = ApiException.class)
    public ResultVo<String> apiException(ApiException e) {
        return new ResultVo<>(Status.UNKNOWN_ERROR.getCode(), "操作失败", e.getMsg());
    }


}
