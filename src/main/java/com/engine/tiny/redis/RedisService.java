package com.engine.tiny.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public Long nextId() {
        return redisTemplate.opsForValue().increment("ID");
    }
}
