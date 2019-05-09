package com.kk.redis;

import com.kk.redis.lock.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableScheduling
public class MyService {

    @Synchronized(namespace = "redis:test",expireSecond = 2000)
    @Scheduled(fixedDelay = 1000,initialDelay = 1000)
    public void sech(){

        log.info("start=============");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
