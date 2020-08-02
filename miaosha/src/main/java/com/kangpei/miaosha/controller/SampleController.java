package com.kangpei.miaosha.controller;

import com.kangpei.miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: SampleController <br>
 * date: 2020/7/26 8:57 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Controller
@RequestMapping("/demo")
public class SampleController {


    @ResponseBody
    @RequestMapping("/thymeleaf")
    public Result<String> thymeleaf(Model model)  {

        model.addAttribute("name", "steve");
        return Result.success("hello,imooc");

    }
}
