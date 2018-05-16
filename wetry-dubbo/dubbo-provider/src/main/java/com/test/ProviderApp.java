package com.test;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wch on 18-5-16.
 * spring boot 启动类
 */
@SpringBootApplication// spring boot
@EnableDubboConfiguration// dubbo-spring-boot-starter
@RestController
@ComponentScan(basePackages = {"com.test"})
public class ProviderApp {

    @RequestMapping("/")
    String home(){
        return "hello demo";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }

}
