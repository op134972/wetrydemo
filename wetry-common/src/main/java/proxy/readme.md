
## 代理
简而言之，代理就是一个enhancer，增强原方法

### 静态代理：
写代码里，自己实现
### 动态代理：
JDK代理，要求目标类实现

主要的类是Proxy类
方法是newProxyInstance
```java

public class JdkProxyFactory {
	// target类需要实现接口
    private Object target;

    JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxtInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(target, args);
                    }
                });
    }
}

```

### Cglib代理：
子类代理，引入jar包，spring中已经有

主要的类是Enhancer类
```java
package proxy;
/
public class CglibProxyFactory implements MethodInterceptor {
	// target不需要实现接口
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

```

