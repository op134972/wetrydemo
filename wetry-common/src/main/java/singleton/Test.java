package singleton;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 00:24
 */
public class Test {

    public static void main(String[] args) {


        System.out.println("start ...");
        SingleOfHolderClassDelay instance = SingleOfHolderClassDelay.getInstance();
        System.out.println("end ...");
    }
}
