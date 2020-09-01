package jvm;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-10 10:27
 */
public class InternTest {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = ("hello").intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
