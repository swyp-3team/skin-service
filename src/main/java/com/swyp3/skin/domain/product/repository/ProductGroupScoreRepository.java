package com.swyp3.skin.domain.product.repository;

import com.swyp3.skin.domain.product.domain.entity.ProductGroupScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductGroupScoreRepository extends JpaRepository<ProductGroupScore,Long> {
    void deleteByProductId(Long productId);

    List<ProductGroupScore> findByProductIdIn(List<Long> productIds);
}
