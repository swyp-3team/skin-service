package com.swyp3.skin.global.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {


    public static final String LAYERD_PREVIEW_CACHE = "LayerdPreviewCache";

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager(LAYERD_PREVIEW_CACHE);
        manager.setCaffeine(
                Caffeine.newBuilder()
                        .maximumSize(3_000)
                        .expireAfterWrite(Duration.ofMinutes(20))
        );
        return manager;
    }
}
