package com.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.test.api.ApiTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by tangwc on 2018/4/5.
 * <p>
 * 测试客户端的异步调用
 */
public class TestConsumerAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //applicationConfig
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubboConsumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");

        ReferenceConfig<ApiTest> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(ApiTest.class);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("dubbo");

        //客户端设置超时时间
        referenceConfig.setTimeout(3000);
        //设置异步调用
        referenceConfig.setAsync(true);

        ApiTest apiTest = referenceConfig.get();

        long startTime = System.currentTimeMillis();
        //异步调用 返回的是null，继续执行之下的代码
        System.out.println(apiTest.say("hello lilyAn"));

        //拿到调用的futrue引用，结果返回时，被通知和设置到此futrue
        Future<Object> future = RpcContext.getContext().getFuture();


        //异步调用 返回的是null，继续执行之下的代码
        System.out.println(apiTest.say2("hello lilyAn"));

        //拿到调用的futrue引用，结果返回时，被通知和设置到此futrue
        Future<Object> future2 = RpcContext.getContext().getFuture();

        System.out.println(future.get());
        System.out.println(future2.get());

        long endTime = System.currentTimeMillis();
        System.out.print("cost: " + (endTime - startTime) / 1000);
    }
}
