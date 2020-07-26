package com.kangpei.security.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: UAAServer <br>
 * date: 2020/7/19 11:47 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
//@EnableFeignClients(basePackages = {"com.kangpei.security.uaa"})
public class UAAServer {

    public static void main(String[] args) {
        SpringApplication.run(UAAServer.class, args);
    }

}
