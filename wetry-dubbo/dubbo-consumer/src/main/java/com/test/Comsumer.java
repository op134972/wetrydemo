package com.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.test.api.Speaker;

/**
 * Created by wch on 18-3-30.
 */
public class Comsumer {

    /**
     *使用非Spring xml配置方式使用dubbo
     *
     * ApplicationConfig
     * RegistryConfig
     * ReferenceConfig
     * Api.XXX
     * @param args
     */
    public static void main(String[] args) {
        //应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubboConsumer");

        //连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");

        //ReferenceConfig 为重对象，内部封装了与注册中心的链接，以及与服务提供方的连接
        //引用远程服务
        ReferenceConfig<Speaker> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);// 多个注册中心 使用setRegistries
        referenceConfig.setInterface(Speaker.class);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("dubbo");

        //和本地bean一样使用服务
        Speaker speaker = referenceConfig.get();
        System.out.println(speaker.speak("hello dubbo"));
    }
}
