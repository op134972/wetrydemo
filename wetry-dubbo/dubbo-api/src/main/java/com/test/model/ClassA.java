package com.test.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wch on 18-4-4.
 */
public class ClassA implements Serializable{

    private String name;

    private String password;

    private int age;

    private Date birthDay;

    private List<String> experience;

    private ClassB classB;

    public ClassA() {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", experience=" + experience +
                ", classB=" + classB +
                '}';
    }
}
