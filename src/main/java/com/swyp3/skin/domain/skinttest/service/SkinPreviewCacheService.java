package com.swyp3.skin.domain.skinttest.service;

import com.swyp3.skin.domain.skinttest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skinttest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skinttest.exception.SkinTestException;
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

    public SkinPreviewCacheValue get(String previewToken) {
        Cache.ValueWrapper wrapper = getCache().get(previewToken);
        return wrapper == null ? null : (SkinPreviewCacheValue) wrapper.get();
    }

    public void evict(String previewToken) {
        getCache().evict(previewToken);
    }
}
