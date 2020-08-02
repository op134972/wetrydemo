package jdk;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-28 14:35
 */
public class InheritableThreadLocalTest {

    private static InheritableThreadLocal<Person> tl1 = new InheritableThreadLocal<>();
    private static ThreadLocal<Person> tl2 = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {

        Person person = new Person("jack");

        tl1.set(person);
        tl2.set(person);
        printTl();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                printTl();
            }
        });
        t1.start();

        Thread.sleep(1000);

        printTl();
    }


    private static void printTl(){
        System.out.println("当前线程: " + Thread.currentThread() + ", tl1: " + tl1.get() + ", tl2: " + tl2.get());
    }


    static class Person{
        String name ;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
