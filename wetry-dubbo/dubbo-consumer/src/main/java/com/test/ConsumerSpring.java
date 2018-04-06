package com.test;

import com.test.api.ApiTest;
import com.test.model.ClassA;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by wch on 18-3-30.
 */
public class ConsumerSpring {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-dubbo-consumer.xml");

        System.out.println("consumer begin...");
        Speaker speaker = (Speaker) context.getBean("speaker", Speaker.class);
        System.out.println(speaker.speak("hello"));


        System.out.println("===========================");

        ClassA ca = new ClassA();
        ca.setBirthDay(new Date());
        ApiTest apiTest = (ApiTest) context.getBean("apiTest", ApiTest.class);
        for (int i = 0; i < 100; i++) {
            apiTest.method(ca);
            System.out.println(ca);
        }
    }
}
