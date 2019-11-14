package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <br>Title: AccountApplication
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/9/14:17
 */
@SpringBootApplication
@EnableEurekaServer
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
