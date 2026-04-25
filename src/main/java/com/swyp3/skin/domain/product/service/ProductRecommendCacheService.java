package com.swyp3.skin.domain.product.service;

import com.swyp3.skin.global.config.CacheConfig;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import com.swyp3.skin.recommendation.product.service.ProductRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRecommendCacheService {

    private final ProductRecommendationService productRecommendationService;

    @Cacheable(cacheNames = CacheConfig.PRODUCT_RECOMMEND_CACHE, key = "#skinResultId")
    public List<RecommendedProduct> getOrCalculate(Long skinResultId) {
        return productRecommendationService.recommend(skinResultId);
    }

    @CacheEvict(cacheNames = CacheConfig.PRODUCT_RECOMMEND_CACHE, key = "#skinResultId")
    public void evict(Long skinResultId) {
    }

    @CacheEvict(cacheNames = CacheConfig.PRODUCT_RECOMMEND_CACHE, allEntries = true)
    public void evictAll() {
    }
}
