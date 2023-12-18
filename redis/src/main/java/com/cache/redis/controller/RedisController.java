package com.cache.redis.controller;

import com.cache.redis.service.RedisService;
import com.cache.redis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/save")
    public String saveToCache(@RequestParam String key ,@RequestParam String name , @RequestParam String rollNumber){
        Student student = Student.builder().name(name).rollNumber(rollNumber).build();
        redisService.saveData(key , student);
        return "data saved successfully in redis";
    }


    @GetMapping("/fetch")
    public Student fetchFromCache(@RequestParam String key){
        return  redisService.fetch(key);
    }
}
