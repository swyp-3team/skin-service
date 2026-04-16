package com.swyp3.skin.api.v1.product.dto.response;

import com.swyp3.skin.domain.product.domain.entity.Product;

import java.util.List;

public record ProductSearchResult(
        List<Product> products,
        boolean hasNext
) {}