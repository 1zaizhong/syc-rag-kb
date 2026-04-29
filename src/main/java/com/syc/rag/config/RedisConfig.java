package com.syc.rag.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/29 下午1:57
 * @description Redis 序列化配置
 **/
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        ObjectMapper mapper = new ObjectMapper();
        //启动类信息,反序列化时候能正确还原DTO 类型,避免 ClassCastException
        mapper.activateDefaultTyping(
                BasicPolymorphicTypeValidator.builder()
                        .allowIfBaseType(Object.class)
                        .build()
        );
        GenericJackson2JsonRedisSerializer valueSerializer
                = new GenericJackson2JsonRedisSerializer(mapper);
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer( new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(valueSerializer);
        template.setHashValueSerializer(valueSerializer);
         return  template;
    }
}
