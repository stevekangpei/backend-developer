package com.kangpei.security.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: OrderController <br>
 * date: 2020/7/20 12:53 上午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@RestController
public class OrderController {

    @GetMapping("/r1")
    @PreAuthorize("hasAuthority('p1')") // //拥有p1权限方可访问此url
    public String r1() {
        return "访问资源1";
    }
}
