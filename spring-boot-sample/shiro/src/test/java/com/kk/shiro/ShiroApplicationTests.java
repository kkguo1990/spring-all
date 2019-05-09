package com.kk.shiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Test
    public void contextLoads() {
    }

    @Test
    public  void test(){
        redisTemplate.opsForValue().set("key","hello",1,TimeUnit.MINUTES);
        String key = (String) redisTemplate.opsForValue().get("key");
        System.out.println(key);
    }

}
