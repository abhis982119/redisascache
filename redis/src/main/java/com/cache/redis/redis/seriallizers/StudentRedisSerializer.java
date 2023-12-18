package com.cache.redis.redis.seriallizers;

import com.cache.redis.model.Student;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class StudentRedisSerializer implements RedisSerializer<Student> {

    private final ObjectMapper objectMapper;

    public StudentRedisSerializer() {
        this.objectMapper = new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
    }


    @Override
    public byte[] serialize(Student student) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(student);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }

    @Override
    public Student deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null) {
            return null;
        }
        try {
            return objectMapper.readValue(bytes, Student.class);
        } catch (Exception e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }
}



