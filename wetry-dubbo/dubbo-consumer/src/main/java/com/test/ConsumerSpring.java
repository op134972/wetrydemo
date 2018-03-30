package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wch on 18-3-30.
 */
public class ConsumerSpring {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-dubbo-consumer.xml");

        System.out.println("consumer begin...");
        Speaker speaker = (Speaker) context.getBean("speaker", Speaker.class);
        System.out.println(speaker.speak("hello"));
    }
}
