package com.test.api;

import com.test.model.ClassA;

/**
 * Created by wch on 18-4-4.
 */
public interface ApiTest {

    public void method(ClassA classA);

    public String say(String words) throws InterruptedException;

    public String say2(String s) throws InterruptedException;
}
