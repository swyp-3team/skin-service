package com.swyp3.skin.domain.product.service;

import com.swyp3.skin.domain.product.domain.entity.ProductGroupScore;
import com.swyp3.skin.domain.product.repository.ProductGroupScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductGroupScoreService {

    private final ProductGroupScoreRepository productGroupScoreRepository;

    public Map<Long, List<ProductGroupScore>> getGroupScoreMap(List<Long> productIds) {

        List<ProductGroupScore> scores =
                productGroupScoreRepository.findByProductIdIn(productIds);

        return scores.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getProduct().getId()
                ));
    }
}
