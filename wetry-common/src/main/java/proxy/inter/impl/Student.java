package proxy.inter.impl;

import proxy.inter.Speaker;

/**
 * Created by tangwc on 2018/4/6.
 */
public class Student implements Speaker {
    @Override
    public void speak(String words) {
        System.out.print("hello" + words);
    }


    public static void main(String[] args) {
        Student student = new Student();
        student.speak("hi");
    }
}
