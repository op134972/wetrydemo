package javaapi;

public class SplitTest {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,,,,";
        System.out.println(str.split(",").length);
    }
}
