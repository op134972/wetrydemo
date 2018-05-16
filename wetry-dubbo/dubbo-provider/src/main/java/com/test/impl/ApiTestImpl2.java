package com.test.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.api.ApiTest;
import com.test.model.ClassA;
import org.springframework.stereotype.Component;

/**
 * Created by wch on 18-5-16.
 */
@Service(interfaceClass = ApiTest.class, group = "dubbo", version = "1.0.0")
@Component
public class ApiTestImpl2 implements ApiTest {
    @Override
    public void method(ClassA classA) {
        System.out.println(classA);
    }

    @Override
    public String say(String words) throws InterruptedException {
        return "halo:" + words;
    }

    @Override
    public String say2(String s) throws InterruptedException {
        return "say2:" + s;
    }
}
