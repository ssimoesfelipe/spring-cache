package com.example.springcache.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {

  @Bean
  RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
    return (builder) -> {
      Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
      configurationMap.put("hello", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(5)));
      configurationMap.put("person", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(2)));
      builder.withInitialCacheConfigurations(configurationMap);
    };
  }
}
