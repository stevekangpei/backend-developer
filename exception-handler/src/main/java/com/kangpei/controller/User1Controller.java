package com.kangpei.controller;

import com.kangpei.model.User;
import com.kangpei.resp.ResultVo;
import com.kangpei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * description: User1Controller <br>
 * date: 2020/6/27 11:01 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("user1")

public class User1Controller {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) {

        // 如果有错误的话，在这里处理, 加入统一异常处理后就不需要这个代码了
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            return error.getDefaultMessage();
//        }
        return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public ResultVo<User> getUser() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");

        return new ResultVo<>(user);

    }


    @GetMapping("/getUser1")
    public User getUser1() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");

        return user;

    }


}
