package com.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * Created by wch on 18-3-30.
 */
public class Provider {

    /**
     * 使用非Spring配置的方式配置dubbo
     *
     * service
     * ApplicationConfig
     * RegistryConfig
     * ProtocolConfig
     * ServiceConfig<T>
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        //服务实现
        Speaker speaker = new SpeakerImpl();

        //当前应用的配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubboProvider");

        //注册配置信息
        RegistryConfig registryConfig = new RegistryConfig();
        ////host 和 端口配置在 zookeeper/conf/zoo.cfg文件中
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");

        //服务提供者 协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");//使用dubbo协议
        protocolConfig.setPort(20880);

        //ServiceConfig，重对象，内部封装了与注册中心的连接，以及开启服务端口。
        // 加载之前的配置到服务配置中，提供暴露服务配置。
        ServiceConfig<Speaker> service = new ServiceConfig<>();
        service.setApplication(application);
        service.setRegistry(registryConfig);
        service.setProtocol(protocolConfig);
        service.setInterface(Speaker.class);
        service.setRef(speaker);
        service.setVersion("1.0.0");
        service.setGroup("dubbo");

        //暴露出去
        service.export();

        System.out.println("provider started...");
        //挂起当前线程，一直暴露
        Thread.currentThread().join();
    }
}
