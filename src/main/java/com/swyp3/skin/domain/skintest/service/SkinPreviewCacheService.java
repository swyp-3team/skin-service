package com.swyp3.skin.domain.skintest.service;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.swyp3.skin.domain.skintest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skintest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skintest.exception.SkinTestException;
import com.swyp3.skin.global.config.CacheConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SkinPreviewCacheService {

    public final CacheManager cacheManager;

    public String put(SkinPreviewCacheValue value) {
        String token = UUID.randomUUID().toString();
        Cache cache = getCache();
        cache.put(token, value);
        return token;
    }

    private Cache getCache() {
        Cache cache = cacheManager.getCache(CacheConfig.LAYERD_PREVIEW_CACHE);
        if (cache == null) throw new SkinTestException(SkinTestErrorCode.PREVIEW_TOKEN_EXPIRED);
        return cache;
    }

    public SkinPreviewCacheValue consume(String previewToken) {
        Cache findCache = getCache();
        Object nativeCache = findCache.getNativeCache();

        if (!(nativeCache instanceof com.github.benmanes.caffeine.cache.Cache<?, ?> caffeineCache)) {
            throw new SkinTestException(SkinTestErrorCode.PREVIEW_CACHE_TYPE_MISMATCH);
        }

        @SuppressWarnings("unchecked")
        com.github.benmanes.caffeine.cache.Cache<Object, Object> cache
                = (com.github.benmanes.caffeine.cache.Cache<Object, Object>) caffeineCache;

        Object removed = cache.asMap().remove(previewToken);
        return removed == null ? null : (SkinPreviewCacheValue) removed;
    }

    public SkinPreviewCacheValue get(String previewToken) {
        Cache.ValueWrapper wrapper = getCache().get(previewToken);
        return wrapper == null ? null : (SkinPreviewCacheValue) wrapper.get();
    }

}
