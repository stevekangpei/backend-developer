package com.kangpei.handler;

import com.kangpei.exception.JsonException;
import com.kangpei.exception.PageException;
import com.kangpei.resp.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * description: ExceptionHandler <br>
 * date: 2020/6/27 9:14 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = JsonException.class)
    public ApiResponse jsonExceptionHandler(JsonException exception) {
        log.error("[JsonException] : {}", exception.getMsg());
        return ApiResponse.ofException(exception);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = PageException.class)
    public ModelAndView pageExpectionHandler(PageException pageException) {

        log.error("[PageException] : {}", pageException.getMsg());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", pageException.getMsg());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

}
