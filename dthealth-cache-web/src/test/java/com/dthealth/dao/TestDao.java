package com.dthealth.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {
//    @Autowired
//    RedisService redisService;

    @Test
    public void testRedis(){
        System.out.println("Starting");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            try {
//                redisService.storeBodyIndex(i+"","ssssssssssssssssss",2L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
