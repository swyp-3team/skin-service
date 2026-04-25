package com.swyp3.skin.domain.routine.service;

import com.swyp3.skin.domain.routine.dto.RoutinePreviewCacheValue;
import com.swyp3.skin.domain.routine.exception.RoutineErrorCode;
import com.swyp3.skin.domain.routine.exception.RoutineException;
import com.swyp3.skin.global.config.CacheConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoutinePreviewCacheService {

    private final CacheManager cacheManager;

    public String put(RoutinePreviewCacheValue value) {
        String token = UUID.randomUUID().toString();
        Cache cache = getCache();
        cache.put(token, value);
        return token;
    }

    private Cache getCache() {
        Cache cache = cacheManager.getCache(CacheConfig.LAYERD_PREVIEW_CACHE);
        if (cache == null) {
            throw new RoutineException(RoutineErrorCode.PREVIEW_CACHE_NOT_FOUND);
        }
        return cache;
    }

    public RoutinePreviewCacheValue consume(String previewToken) {
        Cache findCache = getCache();
        Object nativeCache = findCache.getNativeCache();

        if (!(nativeCache instanceof com.github.benmanes.caffeine.cache.Cache<?, ?> caffeineCache)) {
            throw new RoutineException(RoutineErrorCode.PREVIEW_CACHE_TYPE_MISMATCH);
        }

        @SuppressWarnings("unchecked")
        com.github.benmanes.caffeine.cache.Cache<Object, Object> cache =
                (com.github.benmanes.caffeine.cache.Cache<Object, Object>) caffeineCache;

        Object removed = cache.asMap().remove(previewToken);
        return toRoutinePreviewCacheValue(removed);
    }

    public RoutinePreviewCacheValue get(String previewToken) {
        Cache.ValueWrapper wrapper = getCache().get(previewToken);
        return wrapper == null ? null : toRoutinePreviewCacheValue(wrapper.get());
    }

    private RoutinePreviewCacheValue toRoutinePreviewCacheValue(Object cachedValue) {
        if (cachedValue == null) {
            return null;
        }
        if (!(cachedValue instanceof RoutinePreviewCacheValue routinePreviewCacheValue)) {
            throw new RoutineException(RoutineErrorCode.PREVIEW_CACHE_TYPE_MISMATCH);
        }
        return routinePreviewCacheValue;
    }
}
