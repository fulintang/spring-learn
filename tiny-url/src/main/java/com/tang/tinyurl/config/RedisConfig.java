package com.tang.tinyurl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tang.tinyurl.model.UrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    private final ObjectMapper objectMapper;

    private final RedisConnectionFactory redisConnectionFactory;

    /**
     * 将以下代码添加到配置类。默认情况下，Spring Boot是自动配置的，可与字符串基础键/值对Redis模板一起使用。
     * 但是，在本教程中，我们将密钥存储为字符串，并将值存储为JSON对象。
     *
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<String, UrlDto> redisTemplate() {
        final Jackson2JsonRedisSerializer<UrlDto> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(UrlDto.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        final RedisTemplate<String, UrlDto> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

}