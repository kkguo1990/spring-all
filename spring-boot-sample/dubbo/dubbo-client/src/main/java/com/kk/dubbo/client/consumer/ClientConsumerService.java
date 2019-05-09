package com.kk.dubbo.client.consumer;

import com.kk.dubbo.api.IHelloService;
import org.apache.dubbo.config.annotation.Reference;

public class ClientConsumerService {

    @Reference
    IHelloService service;

    public void consumer(){
        service.sayHello();

        //todo 可以看测试类
    }
}
