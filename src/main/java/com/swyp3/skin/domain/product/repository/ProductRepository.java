package com.swyp3.skin.domain.product.repository;

import com.swyp3.skin.domain.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
