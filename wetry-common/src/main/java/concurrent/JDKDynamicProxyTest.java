package concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-30 23:05
 * jdk自带的动态代理的方式
 *
 * 字节码增强还有：
 * javassist
 * cglib
 * asm
 * bcel
 */
public class JDKDynamicProxyTest {
    public static void main(String[] args) {
        Object target = new BeProxyClass();
        InvocationHandler logHandler = new LogHandler(target);
        BeProxyInterface bp = (BeProxyInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), logHandler);
        bp.fun();
    }
}

class BeProxyClass implements BeProxyInterface{

    @Override
    public void fun(){
        System.out.println("do something...");
    }
}

class LogHandler implements InvocationHandler {

    Object obj;
    public LogHandler(Object target) {
        this.obj = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        Object invoke = method.invoke(obj, args);
        System.out.println("invoke after");
        return invoke;
    }
}
interface BeProxyInterface{
    public void fun();
}
