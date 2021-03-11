package guavatest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-14 10:09
 */
public class Demo3 {

    public static void main(String[] args) {
        Set<Integer> singleton = Collections.singleton(1);
        Set<Integer> newSet = new HashSet<>();
        newSet.add(2);
        Set<Integer> newSet2 = new HashSet<>(singleton);
        newSet2.addAll(newSet);

        System.out.println(newSet2.toString());


        System.out.println(24 & 0);
    }
}
