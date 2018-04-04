package com.test.impl;


import com.test.api.ApiTest;
import com.test.model.ClassA;
import com.test.model.ClassB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wch on 18-4-4.
 */
@Service("apiTest")
public class ApiTestImpl implements ApiTest {
    @Override
    public void method(ClassA classA) {
        System.out.println("set beginning..");

        classA.setAge(1);
        //classA.setBirthDay(new Date());
        classA.setName("文川");
        classA.setPassword("123");
        List<String> list = new ArrayList<String>();
        list.add("list1");
        ClassB cb = new ClassB();
        cb.setAge(2);
        cb.setName("小川");
        cb.setPassword("123");
       // cb.setBirth(new Date());
        classA.setClassB(cb);
        classA.setExperience(list);

        System.out.println(classA);

        System.out.println("set done..");
    }
}
