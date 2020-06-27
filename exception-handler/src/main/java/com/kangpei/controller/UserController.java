package com.kangpei.controller;

import com.kangpei.model.User;
import com.kangpei.resp.ResultVo;
import com.kangpei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * description: UserController <br>
 * date: 2020/6/27 10:17 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 现在这样子做就避免掉了大量的if判断。
     *      if (user == null || user.getId() == null || user.getAccount() == null
     *      || user.getPassword() == null || user.getEmail() == null) {
     *          return "对象或者对象字段不能为空";
     *      }
     *      if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())
     *      || StringUtils.isEmpty(user.getEmail())) {
     *          return "不能输入空字符串";
     *      }
     *      if (user.getAccount().length() < 6 || user.getAccount().length() > 11) {
     *          return "账号长度必须是6-11个字符";
     *      }
     * @param user
     * @return
     */
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
}
