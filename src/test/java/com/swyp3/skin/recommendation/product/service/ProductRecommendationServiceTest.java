//package com.swyp3.skin.recommendation.product.service;
//
//
//import com.swyp3.skin.domain.common.enums.IngredientGroup;
//import com.swyp3.skin.domain.product.domain.entity.Product;
//import com.swyp3.skin.domain.product.domain.entity.ProductGroupScore;
//import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
//import com.swyp3.skin.domain.product.repository.ProductGroupScoreRepository;
//import com.swyp3.skin.domain.product.repository.ProductRepository;
//import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
//import com.swyp3.skin.domain.skinresult.domain.entity.SkinResultGroupScore;
//import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
//import com.swyp3.skin.domain.skinresult.repository.SkinResultGroupScoreRepository;
//import com.swyp3.skin.recommendation.product.calculator.ProductScoreCalculator;
//import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
//import com.swyp3.skin.recommendation.product.mapper.ProductVectorMapper;
//import com.swyp3.skin.recommendation.product.policy.ProductFilterPolicy;
//import org.junit.jupiter.api.Test;
//
//import java.lang.reflect.Field;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//class ProductRecommendationServiceTest {
//
//    private void setId(Object entity, Long id) {
//        try {
//            Field field = entity.getClass().getDeclaredField("id");
//            field.setAccessible(true);
//            field.set(entity, id);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    void 추천_정상흐름() {
//
//        //mock세팅
//        ProductRepository productRepository = mock(ProductRepository.class);
//        ProductGroupScoreRepository groupScoreRepository = mock(ProductGroupScoreRepository.class);
//        SkinResultGroupScoreRepository skinRepository = mock(SkinResultGroupScoreRepository.class);
//
//        // 스킨 리절트 세팅
//        SkinResult skinResult = SkinResult.create(
//                null,
//                SkinType.OILY,
//                "test",
//                LocalDateTime.now()
//        );
//
//        // 그룹 스코어 세팅
//        SkinResultGroupScore s1 = SkinResultGroupScore.create(
//                skinResult,
//                IngredientGroup.ACNE,
//                0.9,
//                1,
//                "acne"
//        );
//
//        SkinResultGroupScore s2 = SkinResultGroupScore.create(
//                skinResult,
//                IngredientGroup.SOOTHING,
//                0.8,
//                2,
//                "soothing"
//        );
//
//        // 스터빙
//        when(skinRepository.findBySkinResultId(any()))
//                .thenReturn(List.of(s1, s2));
//
//        // 상품세팅
//        Product p1 = Product.create(
//                "A",
//                "brand",
//                ProductCategory.TONER,
//                1000,
//                "desc",
//                "img",
//                "url",
//                true
//        );
//
//        Product p2 = Product.create(
//                "B",
//                "brand",
//                ProductCategory.TONER,
//                1000,
//                "desc",
//                "img",
//                "url",
//                true
//        );
//
//        // JPA 동작을 흉내내기 위해 id 세팅
//        setId(p1, 1L);
//        setId(p2, 2L);
//
//        // 스터빙
//        when(productRepository.findAll())
//                .thenReturn(List.of(p1, p2));
//
//        // 그룹 스코어 세팅
//        ProductGroupScore g1 = ProductGroupScore.create(
//                p1,
//                IngredientGroup.ACNE,
//                0.6,
//                1
//        );
//
//        ProductGroupScore g2 = ProductGroupScore.create(
//                p1,
//                IngredientGroup.SOOTHING,
//                0.4,
//                2
//        );
//
//        ProductGroupScore g3 = ProductGroupScore.create(
//                p2,
//                IngredientGroup.HYDRATION,
//                1.0,
//                1
//        );
//
//        // 스터빙
//        when(groupScoreRepository.findByProductIdIn(any()))
//                .thenReturn(List.of(g1, g2, g3));
//
//        // 서비스 생성
//        ProductRecommendationService service =
//                new ProductRecommendationService(
//                        productRepository,
//                        groupScoreRepository,
//                        skinRepository,
//                        new ProductVectorMapper(groupScoreRepository),
//                        new ProductFilterPolicy(),
//                        new ProductScoreCalculator()
//                );
//
//        // 실행
//        List<RecommendedProduct> result = service.recommend(1L);
//
//        // 필터링 : p2는 HYDRATION만 공급하는데 필요는 ACNE, SOOTHING이므로 제거됨
//        assertThat(result).hasSize(1);
//
//        // p1만 남음
//        assertThat(result.get(0).getProduct()).isEqualTo(p1);
//
//        // 점수존재여부
//        assertThat(result.get(0).getScore()).isGreaterThan(0.0);
//    }
//}