package com.scu.freight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 8:17
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory factory;

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        //设置key的序列化方式
        redisTemplate.setKeySerializer(RedisSerializer.string());
        //设置普通的value的序列化方式
        redisTemplate.setValueSerializer(RedisSerializer.json());
        //设置hash的key的序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        //设置hash的value的序列化方式
        redisTemplate.setHashValueSerializer(RedisSerializer.json());

        return redisTemplate;
    }
}
