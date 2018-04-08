package javaapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextDouble());
        List<String> list = new ArrayList<>();
        list.stream();
    }
}
