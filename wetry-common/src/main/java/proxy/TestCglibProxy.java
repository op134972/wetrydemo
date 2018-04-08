package proxy;

import proxy.inter.impl.Teacher;

/**
 * Created by tangwc on 2018/4/6.
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(teacher);

        Teacher teacher1 = (Teacher) cglibProxyFactory.getProxyInstance();

        System.out.println(teacher1.getClass());

        teacher1.say("hello");
    }
}
