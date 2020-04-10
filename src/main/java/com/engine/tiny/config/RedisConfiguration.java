package com.engine.tiny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(RedisProperties redisProperties) {
        final RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(redisProperties.getRedisHost(), redisProperties.getRedisPort());
        return new JedisConnectionFactory(standaloneConfig);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisProperties redisProperties) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory(redisProperties));
        return template;
    }
}
