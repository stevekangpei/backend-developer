package com.kangpei.controller;

import com.kangpei.exception.JsonException;
import com.kangpei.exception.PageException;
import com.kangpei.resp.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * description: TestController <br>
 * date: 2020/6/27 8:44 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Controller
public class TestController {


    @GetMapping("/page")
    public ModelAndView pageException() {

        throw new PageException(500, "page error");
    }
    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonExpection() {
        throw new JsonException(500, "json data error");
    }
}
