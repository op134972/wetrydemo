package singleton;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 00:27
 * 延迟初始化模式，无锁+懒汉
 *
 *
 */
public class SingleOfHolderClassDelay {

    private SingleOfHolderClassDelay() {
        System.out.println("Delay Init call");
    }

    private static class InnerClass{
        static {
            System.out.println("InnerClass static block");
        }
        private static SingleOfHolderClassDelay instance = new SingleOfHolderClassDelay();
    }

    public static SingleOfHolderClassDelay getInstance(){
        System.out.println("getInstance Call");
        return InnerClass.instance;
    }

}
