package com.kangpei.security.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: OrderServer <br>
 * date: 2020/7/20 12:00 上午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServer {

    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class, args);
    }
}
