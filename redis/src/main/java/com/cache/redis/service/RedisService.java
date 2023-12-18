package com.cache.redis.service;

import com.cache.redis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {


    private final RedisTemplate<String, Student> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, Student> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveData(String key, Student student){
        redisTemplate.opsForValue().set(key, student,1, TimeUnit.HOURS);
    }

    public Student fetch(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
