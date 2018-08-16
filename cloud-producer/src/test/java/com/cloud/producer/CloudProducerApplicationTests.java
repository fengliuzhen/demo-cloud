package com.cloud.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudProducerApplicationTests {

    @Test
    public void contextLoads() {
        for(int i=0;i<101;i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /*if(CounterLimit.grant())
                    {
                        System.out.println("正常处理业务逻辑"+System.currentTimeMillis());
                    }
                    else
                    {
                        System.out.println("超过最大请求，限流"+System.currentTimeMillis());
                    }*/
                    if(RateLimit.resourceRateLimiter.get("order").tryAcquire(10,TimeUnit.MILLISECONDS))
                    {
                        System.out.println("正常处理业务逻辑"+System.currentTimeMillis());
                    }
                    else
                    {
                        System.out.println("超过最大请求，限流"+System.currentTimeMillis());
                    }
                }
            }).start();
        }
    }

}
