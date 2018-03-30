package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wch on 18-3-30.
 */
public class ProviderSpring {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-dubbo-provider.xml");

        System.out.println("begin...");
        Thread.currentThread().join();
    }
}
