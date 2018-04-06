package proxy;

import proxy.inter.Speaker;
import proxy.inter.impl.Student;

/**
 * Created by tangwc on 2018/4/6.
 */
public class TestProxy {

    public static void main(String[] args) {
        Speaker speaker = new Student();

        ProxyFactory proxyFactory = new ProxyFactory(speaker);

        Speaker proxtInstance = (Speaker) proxyFactory.getProxtInstance();

        System.out.println(proxtInstance.getClass());

        proxtInstance.speak("好");
    }

}
