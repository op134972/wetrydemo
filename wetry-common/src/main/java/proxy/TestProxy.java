package proxy;

import proxy.inter.Speaker;
import proxy.inter.impl.Student;

/**
 * Created by tangwc on 2018/4/6.
 */
public class TestProxy {

    public static void main(String[] args) {
        Speaker speaker = new Student();

        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(speaker);

        Speaker proxtInstance = (Speaker) jdkProxyFactory.getProxtInstance();

        System.out.println(proxtInstance.getClass());

        proxtInstance.speak("好");
    }

}
