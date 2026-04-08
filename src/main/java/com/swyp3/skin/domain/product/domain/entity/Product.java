package com.swyp3.skin.domain.product.domain.entity;

import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

    @Column(length = 1000)
    private String description;

    private String imageUrl;
    private String purchaseUrl;

    @Column(nullable = false)
    private Boolean active;
}
