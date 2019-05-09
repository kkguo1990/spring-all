package com.kk.redis;

import com.kk.redis.lock.Synchronized;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("hello","my hello",1,TimeUnit.MINUTES);
    }

    /**
     * namespace 设置命名空间
     */
    @Test
    @Scheduled(fixedDelay = 1000)
    @Synchronized(namespace = "redis-util:syncmethod", expireSecond = 60)
    public void  sync(){
        System.out.println(1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
