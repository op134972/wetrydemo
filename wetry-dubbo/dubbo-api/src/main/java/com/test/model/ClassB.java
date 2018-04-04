package com.test.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wch on 18-4-4.
 */
public class ClassB implements Serializable{

    private String name ;

    private String password;

    private int age;

    private Date birth;

    public ClassB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "ClassB{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
