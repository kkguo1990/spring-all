package com.kk.dubbo.client;

import com.kk.dubbo.api.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboClientApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Reference
    IHelloService service;

    @Test
    public void sendConsumer(){
        System.out.println(service.sayHello());
    }
}
