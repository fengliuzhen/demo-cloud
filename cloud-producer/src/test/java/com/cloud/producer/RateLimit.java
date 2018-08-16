package com.cloud.producer;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimit {
    public static ConcurrentHashMap<String,RateLimiter> resourceRateLimiter=new ConcurrentHashMap<>();

    static {
        createResourceLimiter("order",50);
    }

    public static void createResourceLimiter(String resource,double qps)
    {
        if(resourceRateLimiter.contains(resource))
        {
            resourceRateLimiter.get(resource).setRate(qps);
        }
        else
        {
            RateLimiter rateLimiter=RateLimiter.create(qps);
            resourceRateLimiter.putIfAbsent(resource,rateLimiter);
        }
    }
}
