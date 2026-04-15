package com.swyp3.skin.recommendation.product.policy;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.recommendation.product.dto.ProductSupply;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductFilterPolicy {

    public List<ProductSupply> filter(
            List<ProductSupply> supplies,
            Map<IngredientGroup, Double> need){

        Set<IngredientGroup> topGroups = need.entrySet().stream()
                .sorted(Map.Entry.<IngredientGroup, Double>comparingByValue().reversed())
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        //커팅단계 일단 아무거라도 들어가있다면
        return supplies.stream()
                .filter(supply ->
                        supply.getSupply().keySet().stream()
                                .anyMatch(topGroups::contains)
                )
                .collect(Collectors.toList());
    }
}
