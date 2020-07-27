package jdk;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-22 17:31
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("123");

        String s2 = "123";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
