package com.kk.dubbo.server.impl;

import com.kk.dubbo.api.IHelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello() {
        return "hello world !!!";
    }
}
