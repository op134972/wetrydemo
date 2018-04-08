package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tangwc on 2018/4/6.
 *
 * 需要实现methodInterceptor接口
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        // 1、工具类
        Enhancer enhancer = new Enhancer();

        // 2、设置父类
        enhancer.setSuperclass(target.getClass());

        // 3、设置回调函数
        enhancer.setCallback(this);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before invoke");

        Object invoke = method.invoke(target, objects);

        System.out.println("after invoke");

        return invoke;
    }
}
