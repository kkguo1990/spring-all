package com.kk.eruka.client.consumer;

import com.kk.eruka.common.api.SchedualServiceHi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErukaClientConsumerApplicationTests {
    @Autowired
    MyClient schedualServiceHi;

    @Test
    public void contextLoads() {
        String hello = schedualServiceHi.sayHiFromClientOne("consumer say hi");
        System.out.println(hello);
    }

}
