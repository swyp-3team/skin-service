package com.swyp3.skin.recommendation.ux;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.List;
import java.util.Map;

public class SkinUxProfileRegistry {
    public SkinUxProfileRegistry() {
    }

    public static final Map<SkinUxKey, SkinUxProfile> PROFILES = Map.ofEntries(

            // 유형 01 - HYDRATION
            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.BARRIER,
                    "촉촉한 수분 결핍형",
                    "장벽까지 같이 약해진 상태예요",
                    "피부 속 수분이 만성적으로 부족한 상태예요. 세안 후 금방 당기고, 보습제를 발라도 금방 건조해지는 게 특징이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    "수분이 부족해지면 피부 장벽도 함께 약해져요. 보습제를 발라도 금방 건조해지는 이유가 바로 이 악순환 때문이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    List.of("속건조", "장벽 약화", "피부 당김"),
                    List.of(IngredientType.HYALURONIC_ACID, IngredientType.CERAMIDE, IngredientType.NIACINAMIDE)
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.SEBUM_CONTROL,
                    "촉촉한 수분 결핍형",
                    "속은 건조한데 겉은 번들거려요",
                    "피부 속 수분이 만성적으로 부족한 상태예요. 세안 후 금방 당기고, 보습제를 발라도 금방 건조해지는 게 특징이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    "속은 건조한데 겉은 기름진 상태는 유수분 불균형이 원인이에요. 피지를 억제하면 오히려 속건조가 심해져요. 오일프리 성분으로 수분만 채우면서 균형을 맞추는 게 핵심이에요.",
                    List.of("속건조","피지 과잉", "유수분 불균형"),
                    List.of(IngredientType.HYALURONIC_ACID, IngredientType.NIACINAMIDE, IngredientType.GLYCERIN)
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.ACNE,
                    "건조한데 트러블도 나는 복잡형",
                    "건조한데 트러블도 같이 나요",
                    "당기는데 트러블까지 나는 억울한 피부예요. 보습을 하면 트러블이 걱정되고, 트러블 케어를 하면 더 건조해지는 딜레마가 반복돼요. 수분 공급과 장벽 회복이 트러블 케어보다 먼저예요.",
                    "피부가 건조하면 장벽이 약해지고, 약해진 장벽으로 트러블이 쉽게 생겨요. 강한 트러블 케어 제품이 오히려 건조함을 악화시킬 수 있어요. 수분을 먼저 채우면 트러블도 자연스럽게 줄어들어요.",
                    List.of("속건조","트러블", "장벽 약화"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.PANTHENOL, IngredientType.HYALURONIC_ACID)
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.SOOTHING,
                    "촉촉한 수분 결핍형",
                    "건조하면서 예민하기까지 해요",
                    "피부 속 수분이 만성적으로 부족한 상태예요. 세안 후 금방 당기고, 보습제를 발라도 금방 건조해지는 게 특징이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    "수분이 부족하면 피부 방어력이 떨어져서 작은 자극에도 예민하게 반응해요. 지금 피부는 새로운 성분을 시도하기보다 자극을 최소화하면서 수분을 채우는 게 먼저예요.",
                    List.of("속건조","피부 예민", "붉어짐"),
                    List.of(IngredientType.PANTHENOL, IngredientType.HYALURONIC_ACID, IngredientType.BETA_GLUCAN)
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.BRIGHTENING,
                    "촉촉한 수분 결핍형",
                    "건조하면서 톤도 흐려지고 있어요",
                    "피부 속 수분이 만성적으로 부족한 상태예요. 세안 후 금방 당기고, 보습제를 발라도 금방 건조해지는 게 특징이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    "피부 수분이 부족하면 각질이 쌓이고 빛 반사가 줄어들어 톤이 칙칙해 보여요. 수분을 채우면서 동시에 톤을 밝혀주는 성분을 함께 쓰는 게 효율적이에요. 미백 성분을 쓰기 전에 충분한 수분 공급이 우선이에요.",
                    List.of("속건조","톤 불균일", "칙칙함"),
                    List.of(IngredientType.HYALURONIC_ACID, IngredientType.VITAMIN_C_STABLE, IngredientType.CERAMIDE)
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.TURNOVER,
                    "촉촉한 수분 결핍형",
                    "건조한데 각질까지 올라오고 있어요",
                    "피부 속 수분이 만성적으로 부족한 상태예요. 세안 후 금방 당기고, 보습제를 발라도 금방 건조해지는 게 특징이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    "수분이 부족하면 각질 탈락이 느려져 두꺼운 각질층이 쌓여요. 각질이 쌓이면 아무리 보습제를 발라도 흡수가 제대로 안 돼요. 각질을 부드럽게 제거한 다음 수분을 채우는 순서가 중요해요.",
                    List.of("속건조","각질 누적", "흡수 저하"),
                    List.of(IngredientType.AHA_LOW, IngredientType.HYALURONIC_ACID, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.ANTI_AGING,
                    "촉촉한 수분 결핍형",
                    "건조하면서 탄력도 신경 쓰여요",
                    "피부 속 수분이 만성적으로 부족한 상태예요. 세안 후 금방 당기고, 보습제를 발라도 금방 건조해지는 게 특징이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.",
                    "피부 수분이 부족하면 탄력 섬유도 함께 약해져 주름이 더 잘 생겨요. 촉촉한 피부가 탄력 성분의 흡수를 높여줘서, 수분 공급과 탄력 케어를 함께 하면 시너지가 나요.",
                    List.of("속건조","탄력 저하", "주름 걱정"),
                    List.of(IngredientType.HYALURONIC_ACID, IngredientType.PEPTIDE, IngredientType.CERAMIDE)
            ),

            // 유형 02 - BARRIER
            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.HYDRATION,
                    "예민한 장벽 위기형",
                    "장벽이 약해지면서 속도 건조해요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "피부 장벽이 무너지면 수분이 빠져나가서 속건조가 심해져요. 지금 가장 필요한 건 새 제품을 추가하기보다 장벽을 복구하면서 수분을 함께 채우는 것이에요.",
                    List.of("장벽 손상", "속건조", "피부 당김"),
                    List.of(IngredientType.CERAMIDE, IngredientType.HYALURONIC_ACID, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.SOOTHING,
                    "예민한 장벽 위기형",
                    "작은 자극에도 크게 반응해요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "피부 장벽이 약해지면 자극을 차단하는 능력이 떨어져서 작은 자극에도 빨개지고 따가워요. 지금은 새로운 성분 도입보다 성분 수를 줄이고 장벽을 살리는 데 집중해야 해요.",
                    List.of("장벽 손상","피부 예민", "홍조"),
                    List.of(IngredientType.MADECASSOSIDE, IngredientType.CERAMIDE, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.ACNE,
                    "예민한 장벽 위기형",
                    "장벽도 약한데 트러블도 나요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "장벽이 약해진 상태에서 강한 트러블 케어 성분을 쓰면 오히려 피부가 더 예민해져요. 장벽을 먼저 복구하면 트러블이 자연스럽게 줄어드는 경우가 많아요.",
                    List.of("장벽 손상","트러블", "피부 예민"),
                    List.of(IngredientType.PANTHENOL, IngredientType.CERAMIDE, IngredientType.CENTELLA)
            ),

            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.SEBUM_CONTROL,
                    "예민한 장벽 위기형",
                    "장벽은 약한데 유분은 많아요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "피지가 많다고 장벽이 튼튼한 건 아니에요. 오히려 장벽이 약해지면 피지 조절 능력도 떨어져서 번들거림이 심해질 수 있어요. 오일 없이 장벽을 복구하는 가벼운 제형이 필요해요.",
                    List.of("장벽 손상","피지 과잉", "번들 거림"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.CERAMIDE_LIGHT, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.BRIGHTENING,
                    "예민한 장벽 위기형",
                    "장벽이 약하면서 톤도 고르지 않아요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "장벽이 약한 상태에서 강한 미백 성분을 쓰면 오히려 자극이 생겨 색소가 더 짙어질 수 있어요. 장벽을 먼저 복구한 다음 자극 없는 미백 성분을 천천히 도입하는 순서가 중요해요.",
                    List.of("장벽 손상","톤 불균일", "색소 침착"),
                    List.of(IngredientType.ARBUTIN, IngredientType.NIACINAMIDE, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.TURNOVER,
                    "예민한 장벽 위기형",
                    "장벽이 약해서 각질 관리가 어려워요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "장벽이 약한 상태에서 AHA/BHA 같은 강한 각질 케어 성분을 쓰면 피부가 더 예민해져요. PHA가 지금 피부에 유일하게 안전한 각질 케어 성분이에요.",
                    List.of("장벽 손상","각질 누적", "피부 예민"),
                    List.of(IngredientType.PHA, IngredientType.CERAMIDE, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.BARRIER,
                    IngredientGroup.ANTI_AGING,
                    "예민한 장벽 위기형",
                    "장벽도 약한데 탄력도 걱정돼요",
                    "피부 보호막이 많이 약해진 상태예요. 새 제품을 쓸 때마다 따갑거나 빨개지고, 작은 자극에도 쉽게 반응해요. 새 성분을 추가하기보다 제품 수를 줄이고 장벽을 회복하는 게 먼저예요.",
                    "레티놀은 탄력에 효과적이지만 장벽이 약한 상태에서 쓰면 자극이 심해요. 지금은 장벽을 먼저 복구하면서 자극 없는 펩타이드로 탄력을 케어하는 게 안전한 순서예요.",
                    List.of("장벽 손상","탄력 저하", "피부 예민"),
                    List.of(IngredientType.PEPTIDE, IngredientType.CERAMIDE, IngredientType.PANTHENOL)
            ),

            // 유형 03 - ACNE
            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.HYDRATION,
                    "수분은 있지만 트러블 동반형",
                    "트러블이 나는데 속은 당기기도 해요",
                    "건조하지 않은데도 트러블이 자꾸 나는 피부예요. 모공 속 노폐물이나 자극 성분에 반응해 트러블이 생기는 경우가 많아요. 과한 보습보다 가볍게 수분을 유지하면서 트러블 케어에 집중해야 해요.",
                    "피부가 건조하면 피지를 더 많이 분비해서 트러블이 심해지는 악순환이 생겨요. 트러블 케어에만 집중하다 보면 속건조가 더 심해질 수 있어요. 수분 공급과 트러블 케어를 동시에 하는 게 이 피부의 핵심이에요.",
                    List.of("반복 트러블", "속건조", "유수분 불균형"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.CENTELLA, IngredientType.HYALURONIC_ACID)
            ),

            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.BARRIER,
                    "열정적인 피지 활동형",
                    "트러블 때문에 장벽도 약해졌어요",
                    "피지 분비가 활발해서 모공이 쉽게 막히고 염증성 트러블이 반복되는 피부예요. 피지를 억제하면서 동시에 염증을 가라앉히는 이중 케어가 필요해요. 강한 세정은 오히려 피지를 더 자극할 수 있어요.",
                    "트러블이 반복되면 피부 장벽이 함께 무너져요. 강한 트러블 제품을 쓰면 트러블은 일시적으로 좋아져도 장벽이 더 약해질 수 있어요. 장벽을 보호하면서 트러블을 케어하는 순한 성분이 필요해요.",
                    List.of("반복 트러블","장벽 손상", "피부 예민"),
                    List.of(IngredientType.PANTHENOL, IngredientType.SALICYLIC_ACID_LOW, IngredientType.CERAMIDE)
            ),

            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.SOOTHING,
                    "열정적인 피지 활동형",
                    "트러블도 있고 예민하기까지 해요",
                    "피지 분비가 활발해서 모공이 쉽게 막히고 염증성 트러블이 반복되는 피부예요. 피지를 억제하면서 동시에 염증을 가라앉히는 이중 케어가 필요해요. 강한 세정은 오히려 피지를 더 자극할 수 있어요.",
                    "트러블과 예민함이 함께 있을 때는 강한 트러블 성분이 오히려 예민함을 악화시켜요. 진정을 먼저 하면서 트러블을 케어하는 순서가 중요해요. 향료와 알코올은 지금 가장 먼저 끊어야 할 성분이에요.",
                    List.of("반복 트러블","피부 예민", "염증 반응"),
                    List.of(IngredientType.CENTELLA, IngredientType.SALICYLIC_ACID_LOW, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.SEBUM_CONTROL,
                    "열정적인 피지 활동형",
                    "피지가 트러블을 계속 만들어요",
                    "피지 분비가 활발해서 모공이 쉽게 막히고 염증성 트러블이 반복되는 피부예요. 피지를 억제하면서 동시에 염증을 가라앉히는 이중 케어가 필요해요. 강한 세정은 오히려 피지를 더 자극할 수 있어요.",
                    "피지가 모공을 막으면서 트러블이 반복되는 패턴이에요. 피지를 조절하는 것 자체가 트러블 예방이 돼요. 피지와 트러블을 동시에 케어하는 성분 조합이 이 피부의 핵심이에요.",
                    List.of("반복 트러블","피지 과잉", "모공 막힘"),
                    List.of(IngredientType.SALICYLIC_ACID, IngredientType.NIACINAMIDE, IngredientType.AZELAIC_ACID)
            ),

            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.BRIGHTENING,
                    "열정적인 피지 활동형",
                    "트러블 자국까지 남아서 더 신경 쓰여요",
                    "피지 분비가 활발해서 모공이 쉽게 막히고 염증성 트러블이 반복되는 피부예요. 피지를 억제하면서 동시에 염증을 가라앉히는 이중 케어가 필요해요. 강한 세정은 오히려 피지를 더 자극할 수 있어요.",
                    "트러블이 나는 것도 힘든데 자국까지 남으면 더 신경 쓰이죠. 트러블을 케어하면서 동시에 자국을 옅게 만드는 성분이 필요해요. 자국은 트러블이 완전히 가라앉은 다음에 케어하는 게 효과적이에요.",
                    List.of("반복 트러블","트러블 자국", "색소 침착"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.AZELAIC_ACID, IngredientType.SALICYLIC_ACID)
            ),

            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.TURNOVER,
                    "열정적인 피지 활동형",
                    "각질이 쌓여서 트러블이 더 심해요",
                    "피지 분비가 활발해서 모공이 쉽게 막히고 염증성 트러블이 반복되는 피부예요. 피지를 억제하면서 동시에 염증을 가라앉히는 이중 케어가 필요해요. 강한 세정은 오히려 피지를 더 자극할 수 있어요.",
                    "각질이 모공을 막으면 트러블이 더 심해지는 악순환이 생겨요. BHA가 모공 속까지 들어가서 각질과 트러블을 동시에 해결해줘요. 물리적 스크럽은 오히려 피부에 자극을 줄 수 있어요.",
                    List.of("반복 트러블","각질 누적", "모공 막힘"),
                    List.of(IngredientType.BHA_SALICYLIC_ACID, IngredientType.AZELAIC_ACID, IngredientType.NIACINAMIDE)
            ),

            entry(
                    IngredientGroup.ACNE,
                    IngredientGroup.ANTI_AGING,
                    "열정적인 피지 활동형",
                    "트러블 관리에 탄력 케어도 필요해요",
                    "피지 분비가 활발해서 모공이 쉽게 막히고 염증성 트러블이 반복되는 피부예요. 피지를 억제하면서 동시에 염증을 가라앉히는 이중 케어가 필요해요. 강한 세정은 오히려 피지를 더 자극할 수 있어요.",
                    "트러블과 탄력을 동시에 케어해야 하는 단계예요. 레티놀이 두 가지 모두에 효과적이지만 처음엔 자극이 될 수 있어요. 트러블이 어느 정도 안정된 다음 저농도 레티놀을 천천히 도입하는 게 안전해요.",
                    List.of("반복 트러블","탄력 저하","복합 케어"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.PEPTIDE, IngredientType.SALICYLIC_ACID_LOW)
            ),

            // 유형 04 - SEBUM_CONTROL
            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.HYDRATION,
                    "반반 섞인 이중 피부형",
                    "번들거리는데 속은 건조하기도 해요",
                    "T존은 기름지고 볼은 건조한 이중 피부예요. 한 가지 제품으로 전체를 커버하기 어렵고, 보습과 피지 케어 사이에서 딜레마가 반복돼요. 세럼은 전체에, 크림은 부위별로 다르게 쓰는 전략이 핵심이에요.",
                    "겉은 번들거려도 속은 건조한 경우가 많아요. 피지를 억제하는 데만 집중하면 속건조가 더 심해져서 피지를 더 많이 분비하는 악순환이 생겨요. 오일프리 수분 케어로 균형을 맞추는 게 핵심이에요.",
                    List.of("피지 과잉", "속건조", "유수분 불균형"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.HYALURONIC_ACID, IngredientType.GLYCERIN)
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.BARRIER,
                    "번들번들 피지 과잉형",
                    "피지가 많은데 장벽도 약해요",
                    "피지 분비가 왕성해서 오후만 되면 번들거리고 모공이 넓어 보이는 피부예요. 강한 세정을 반복하면 오히려 피지가 더 분비되는 악순환이 생겨요. 오일프리 수분 케어로 유수분 균형을 맞추는 게 핵심이에요.",
                    "피지가 많다고 장벽이 튼튼한 건 아니에요. 과한 세정이나 알코올 성분이 장벽을 약하게 만들었을 수 있어요. 피지를 조절하면서 동시에 가벼운 장벽 케어를 함께 해야 해요.",
                    List.of("피지 과잉","장벽 약화","복합 케어"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.CERAMIDE_LIGHT, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.SOOTHING,
                    "번들번들 피지 과잉형",
                    "번들거리면서 예민하기도 해요",
                    "피지 분비가 왕성해서 오후만 되면 번들거리고 모공이 넓어 보이는 피부예요. 강한 세정을 반복하면 오히려 피지가 더 분비되는 악순환이 생겨요. 오일프리 수분 케어로 유수분 균형을 맞추는 게 핵심이에요.",
                    "피지가 많으면서 예민한 피부는 강한 피지 케어 성분이 자극이 될 수 있어요. 무향·무알코올 성분으로 자극을 최소화하면서 피지를 조절하는 게 중요해요.",
                    List.of("피지 과잉","피부 예민", "제품 선택 어려움"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.CENTELLA, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.ACNE,
                    "번들번들 피지 과잉형",
                    "피지가 많아서 트러블도 잦아요",
                    "피지 분비가 왕성해서 오후만 되면 번들거리고 모공이 넓어 보이는 피부예요. 강한 세정을 반복하면 오히려 피지가 더 분비되는 악순환이 생겨요. 오일프리 수분 케어로 유수분 균형을 맞추는 게 핵심이에요.",
                    "피지가 많으면 모공이 막혀 트러블이 잦아져요. 피지 조절 자체가 트러블 예방이에요. 살리실산이 모공 속 피지를 직접 녹여주는 효과가 있어요.",
                    List.of("피지 과잉","반복 트러블", "모공 막힘"),
                    List.of(IngredientType.SALICYLIC_ACID, IngredientType.NIACINAMIDE, IngredientType.ZINC)
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.BRIGHTENING,
                    "번들번들 피지 과잉형",
                    "번들거리는데 톤도 아쉬워요",
                    "피지 분비가 왕성해서 오후만 되면 번들거리고 모공이 넓어 보이는 피부예요. 강한 세정을 반복하면 오히려 피지가 더 분비되는 악순환이 생겨요. 오일프리 수분 케어로 유수분 균형을 맞추는 게 핵심이에요.",
                    "피지가 많으면 모공이 넓어 보이고 톤이 칙칙하게 느껴져요. 나이아신아마이드가 피지 조절과 미백을 동시에 해결해주는 이 피부의 핵심 성분이에요.",
                    List.of("피지 과잉","톤 불균일", "칙칙함"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.VITAMIN_C, IngredientType.ZINC)
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.TURNOVER,
                    "번들번들 피지 과잉형",
                    "피지에 각질까지 겹쳐서 복잡해요",
                    "피지 분비가 왕성해서 오후만 되면 번들거리고 모공이 넓어 보이는 피부예요. 강한 세정을 반복하면 오히려 피지가 더 분비되는 악순환이 생겨요. 오일프리 수분 케어로 유수분 균형을 맞추는 게 핵심이에요.",
                    "피지와 각질이 함께 모공을 막으면 블랙헤드와 화이트헤드가 생기기 쉬워요. BHA가 모공 속까지 들어가 피지와 각질을 함께 제거해주는 게 가장 효과적이에요.",
                    List.of("피지 과잉","각질 누적", "모공 막힘"),
                    List.of(IngredientType.BHA_SALICYLIC_ACID, IngredientType.NIACINAMIDE, IngredientType.CLAY)
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.ANTI_AGING,
                    "번들번들 피지 과잉형",
                    "피지 조절하면서 탄력도 챙기고 싶어요",
                    "피지 분비가 왕성해서 오후만 되면 번들거리고 모공이 넓어 보이는 피부예요. 강한 세정을 반복하면 오히려 피지가 더 분비되는 악순환이 생겨요. 오일프리 수분 케어로 유수분 균형을 맞추는 게 핵심이에요.",
                    "피지 조절을 먼저 안정시킨 다음 탄력 케어를 더하는 순서가 효과적이에요. 나이아신아마이드가 피지를 조절하고, 펩타이드가 탄력을 케어해줘요.",
                    List.of("피지 과잉","탄력 저하","복합 케어"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.PEPTIDE, IngredientType.RETINOL_LOW)
            ),

            // 유형 05 - BRIGHTENING
            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.HYDRATION,
                    "칙칙한 색소 고민형",
                    "톤이 흐리면서 속도 건조해요",
                    "전체 피부톤이 고르지 않고 잡티·트러블 자국이 오래 남는 피부예요. 미백 성분과 꾸준한 선크림 사용이 이 피부 케어의 핵심이에요. 자외선 차단 없이는 어떤 미백 케어도 효과가 반감돼요.",
                    "피부가 건조하면 미백 성분의 흡수율이 크게 떨어져요. 수분을 먼저 채운 다음 미백 성분을 쓰면 효과가 훨씬 좋아요. 선크림은 미백 케어의 가장 중요한 마지막 단계예요.",
                    List.of("색소 침착", "속건조", "톤 불균일"),
                    List.of(IngredientType.HYALURONIC_ACID, IngredientType.VITAMIN_C_STABLE, IngredientType.CERAMIDE)
            ),

            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.BARRIER,
                    "칙칙한 색소 고민형",
                    "톤이 고르지 않으면서 예민하기도 해요",
                    "전체 피부톤이 고르지 않고 잡티·트러블 자국이 오래 남는 피부예요. 미백 성분과 꾸준한 선크림 사용이 이 피부 케어의 핵심이에요. 자외선 차단 없이는 어떤 미백 케어도 효과가 반감돼요.",
                    "예민한 피부에 강한 미백 성분을 쓰면 오히려 피부가 자극받아 색소가 더 짙어질 수 있어요. 자극 없는 순한 미백 성분부터 시작해서 천천히 농도를 높이는 게 안전한 방법이에요.",
                    List.of("색소 침착","피부 예민", "케어 조심스러움"),
                    List.of(IngredientType.ARBUTIN, IngredientType.NIACINAMIDE, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.ACNE,
                    "칙칙한 색소 고민형",
                    "트러블 자국이 남아서 톤이 고르지 않아요",
                    "전체 피부톤이 고르지 않고 잡티·트러블 자국이 오래 남는 피부예요. 미백 성분과 꾸준한 선크림 사용이 이 피부 케어의 핵심이에요. 자외선 차단 없이는 어떤 미백 케어도 효과가 반감돼요.",
                    "트러블 자국은 색소 침착의 한 종류예요. 트러블을 케어하면서 동시에 자국을 옅게 만드는 성분이 필요해요. 자국이 남기 전에 트러블을 빨리 가라앉히는 것도 중요해요.",
                    List.of("색소 침착","트러블 자국", "톤 불균일"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.ARBUTIN, IngredientType.SALICYLIC_ACID_LOW)
            ),

            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.SEBUM_CONTROL,
                    "칙칙한 색소 고민형",
                    "번들거리면서 톤도 칙칙해요",
                    "전체 피부톤이 고르지 않고 잡티·트러블 자국이 오래 남는 피부예요. 미백 성분과 꾸준한 선크림 사용이 이 피부 케어의 핵심이에요. 자외선 차단 없이는 어떤 미백 케어도 효과가 반감돼요.",
                    "피지가 많으면 모공이 넓어 보여서 톤이 더 칙칙하게 느껴져요. 나이아신아마이드가 피지 조절과 미백을 동시에 해결해주는 이 피부의 핵심 성분이에요.",
                    List.of("색소 침착","피지 과잉", "번들거림"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.VITAMIN_C, IngredientType.SALICYLIC_ACID_LOW)
            ),

            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.TURNOVER,
                    "칙칙한 색소 고민형",
                    "각질이 쌓여서 톤이 더 어두워 보여요",
                    "전체 피부톤이 고르지 않고 잡티·트러블 자국이 오래 남는 피부예요. 미백 성분과 꾸준한 선크림 사용이 이 피부 케어의 핵심이에요. 자외선 차단 없이는 어떤 미백 케어도 효과가 반감돼요.",
                    "각질이 두꺼워지면 빛 반사가 줄어서 피부가 칙칙하게 보여요. 각질을 제거하면 미백 성분 흡수율이 높아져서 효과가 바로 보여요. AHA와 비타민C를 함께 쓰면 시너지가 나요.",
                    List.of("색소 침착","각질 누적", "흡수 저하"),
                    List.of(IngredientType.AHA_GLYCOLIC_ACID, IngredientType.VITAMIN_C_STABLE, IngredientType.NIACINAMIDE)
            ),

            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.ANTI_AGING,
                    "환해지고 싶은 톤업 집중형",
                    "색소와 탄력을 동시에 챙겨야 해요",
                    "색소 침착과 탄력 저하가 동시에 진행 중인 피부예요. 두 고민 모두 세포 재생이 느려진 것과 연관이 있어서, 재생 성분 하나로 함께 개선할 수 있어요. 아침 비타민C, 저녁 레티놀 루틴이 핵심이에요.",
                    "색소와 탄력 저하는 모두 세포 재생 속도가 느려진 것과 관련이 있어요. 레티놀이 세포 재생을 촉진해 두 가지를 동시에 개선해줘요. 아침 비타민C, 저녁 레티놀로 나눠 쓰는 게 핵심이에요.",
                    List.of("색소 침착","탄력 저하", "재생 필요"),
                    List.of(IngredientType.VITAMIN_C_STABLE, IngredientType.RETINOL_LOW, IngredientType.NIACINAMIDE)
            ),

            entry(
                    IngredientGroup.BRIGHTENING,
                    IngredientGroup.SOOTHING,
                    "칙칙한 색소 고민형",
                    "예민해서 톤 케어가 더 어려워요",
                    "전체 피부톤이 고르지 않고 잡티·트러블 자국이 오래 남는 피부예요. 미백 성분과 꾸준한 선크림 사용이 이 피부 케어의 핵심이에요. 자외선 차단 없이는 어떤 미백 케어도 효과가 반감돼요.",
                    "예민한 피부에서 강한 미백 성분은 피부를 자극해 색소를 오히려 더 만들어요. 자극 없는 성분으로 천천히, 꾸준히 케어하는 것이 결국 더 빠른 방법이에요.",
                    List.of("색소 침착","피부 예민", "케어 조심스러움"),
                    List.of(IngredientType.ARBUTIN, IngredientType.PANTHENOL, IngredientType.NIACINAMIDE_LOW)
            ),

            // 유형 06 - ANTI_AGING
            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.HYDRATION,
                    "탱탱함이 그리운 탄력 저하형",
                    "탄력도 걱정되면서 속도 건조해요",
                    "눈가 주름이 표정을 풀어도 남아있고, 피부가 예전보다 처진 느낌이 드는 피부예요. 콜라겐과 탄력 섬유가 줄어든 상태로, 레티놀·펩타이드 같은 탄력 성분과 자외선 차단이 핵심이에요.",
                    "피부 수분이 부족하면 탄력 섬유도 함께 약해져 주름이 더 잘 생겨요. 촉촉한 피부가 탄력 성분의 흡수를 높여줘서, 수분 공급과 탄력 케어를 함께 하면 효과가 배가 돼요.",
                    List.of("탄력 저하", "속건조", "주름 걱정"),
                    List.of(IngredientType.PEPTIDE, IngredientType.HYALURONIC_ACID, IngredientType.CERAMIDE)
            ),

            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.BARRIER,
                    "탱탱함이 그리운 탄력 저하형",
                    "탄력이 걱정되는데 장벽도 약해요",
                    "눈가 주름이 표정을 풀어도 남아있고, 피부가 예전보다 처진 느낌이 드는 피부예요. 콜라겐과 탄력 섬유가 줄어든 상태로, 레티놀·펩타이드 같은 탄력 성분과 자외선 차단이 핵심이에요.",
                    "장벽이 약한 상태에서 레티놀을 쓰면 자극이 심해질 수 있어요. 장벽을 먼저 복구한 다음 레티놀을 도입하는 순서가 안전해요. 지금은 펩타이드로 탄력을 케어하면서 장벽을 살리는 게 우선이에요.",
                    List.of("탄력 저하","장벽 약화", "성분 선택 신중"),
                    List.of(IngredientType.PEPTIDE, IngredientType.CERAMIDE, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.SOOTHING,
                    "탱탱함이 그리운 탄력 저하형",
                    "탄력도 걱정되는데 피부도 예민해요",
                    "눈가 주름이 표정을 풀어도 남아있고, 피부가 예전보다 처진 느낌이 드는 피부예요. 콜라겐과 탄력 섬유가 줄어든 상태로, 레티놀·펩타이드 같은 탄력 성분과 자외선 차단이 핵심이에요.",
                    "레티놀은 탄력에 가장 효과적이지만 예민한 피부에는 자극이 심해요. 예민함이 가라앉은 다음 아주 저농도부터 레티놀을 시작하는 게 좋고, 지금은 펩타이드가 더 안전한 선택이에요.",
                    List.of("탄력 저하","피부 예민", "성분 선택 신중"),
                    List.of(IngredientType.PEPTIDE, IngredientType.PANTHENOL, IngredientType.HYALURONIC_ACID)
            ),

            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.ACNE,
                    "탱탱함이 그리운 탄력 저하형",
                    "탄력 걱정에 트러블까지 신경 쓰여요",
                    "눈가 주름이 표정을 풀어도 남아있고, 피부가 예전보다 처진 느낌이 드는 피부예요. 콜라겐과 탄력 섬유가 줄어든 상태로, 레티놀·펩타이드 같은 탄력 성분과 자외선 차단이 핵심이에요.",
                    "레티놀이 탄력과 트러블 두 가지에 모두 효과적이에요. 처음엔 아주 낮은 농도부터 시작해서 피부가 적응하면 천천히 올려가는 게 중요해요.",
                    List.of("탄력 저하","반복 트러블","복합 케어"),
                    List.of(IngredientType.RETINOL_LOW, IngredientType.NIACINAMIDE, IngredientType.PEPTIDE)
            ),

            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.SEBUM_CONTROL,
                    "탱탱함이 그리운 탄력 저하형",
                    "탄력이 걱정되는데 번들거리기도 해요",
                    "눈가 주름이 표정을 풀어도 남아있고, 피부가 예전보다 처진 느낌이 드는 피부예요. 콜라겐과 탄력 섬유가 줄어든 상태로, 레티놀·펩타이드 같은 탄력 성분과 자외선 차단이 핵심이에요.",
                    "탄력 크림이 오일리하면 피지가 더 심해질 수 있어요. 오일프리 제형의 탄력 성분을 선택하는 게 중요해요. 레티놀이 피지 조절과 탄력 모두에 도움이 돼요.",
                    List.of("탄력 저하","피지 과잉", "번들거림"),
                    List.of(IngredientType.RETINOL_LOW, IngredientType.NIACINAMIDE, IngredientType.PEPTIDE)
            ),

            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.BRIGHTENING,
                    "노화와 색소 이중 고민형",
                    "탄력도 걱정되면서 톤도 고르지 않아요",
                    "탄력 저하와 색소 침착이 함께 진행되는 피부예요. 두 고민 모두 세포 재생 속도가 느려진 것과 관련이 있어서, 재생 성분으로 동시에 개선할 수 있어요. 꾸준함이 가장 중요한 유형이에요.",
                    "탄력 저하와 색소 침착은 모두 세포 재생이 느려진 것과 연관이 있어요. 아침 비타민C로 색소를 케어하고, 저녁 레티놀로 탄력과 재생을 함께 케어하면 두 고민을 동시에 해결할 수 있어요.",
                    List.of("탄력 저하","색소 침착", "재생 필요"),
                    List.of(IngredientType.RETINOL_LOW, IngredientType.VITAMIN_C_STABLE, IngredientType.PEPTIDE)
            ),

            entry(
                    IngredientGroup.ANTI_AGING,
                    IngredientGroup.TURNOVER,
                    "탱탱함이 그리운 탄력 저하형",
                    "탄력도 신경 쓰이고 각질도 쌓여요",
                    "눈가 주름이 표정을 풀어도 남아있고, 피부가 예전보다 처진 느낌이 드는 피부예요. 콜라겐과 탄력 섬유가 줄어든 상태로, 레티놀·펩타이드 같은 탄력 성분과 자외선 차단이 핵심이에요.",
                    "각질 재생이 느려지면 탄력도 함께 떨어져요. 레티놀이 세포 재생을 촉진해서 각질 탈락을 돕고 탄력도 케어해줘요. AHA와 레티놀을 같은 날 함께 쓰면 자극이 강해질 수 있어요.",
                    List.of("탄력 저하","각질 누적", "재생 저하"),
                    List.of(IngredientType.RETINOL_LOW, IngredientType.AHA_LOW, IngredientType.PEPTIDE)
            ),

            // 유형 07 - SOOTHING
            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.HYDRATION,
                    "붉고 예민한 홍조 민감형",
                    "예민하면서 속도 건조해요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "수분이 부족하면 피부 방어력이 떨어져 예민함이 더 심해져요. 무향·무알코올 성분으로 자극 없이 수분과 진정을 동시에 챙기는 게 가장 중요해요.",
                    List.of("피부 예민", "속건조", "홍조"),
                    List.of(IngredientType.PANTHENOL, IngredientType.HYALURONIC_ACID, IngredientType.BETA_GLUCAN)
            ),

            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.BARRIER,
                    "붉고 예민한 홍조 민감형",
                    "예민한데 장벽도 무너진 상태예요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "예민함과 장벽 손상은 함께 오는 경우가 많아요. 지금 피부에 가장 필요한 건 새 성분을 추가하는 게 아니라 자극을 줄이고 장벽을 살리는 것이에요. 성분 수를 줄이는 것 자체가 케어예요.",
                    List.of("피부 예민","장벽 손상", "홍조"),
                    List.of(IngredientType.CENTELLA, IngredientType.CERAMIDE, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.ACNE,
                    "붉고 예민한 홍조 민감형",
                    "예민한데 트러블까지 나요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "예민한 피부에서 강한 트러블 케어 성분을 쓰면 오히려 예민함이 악화돼요. 진정을 먼저 하면서 자극 없는 순한 트러블 성분을 조심스럽게 도입하는 게 안전해요.",
                    List.of("피부 예민","트러블", "염증 반응"),
                    List.of(IngredientType.CENTELLA, IngredientType.NIACINAMIDE_LOW, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.SEBUM_CONTROL,
                    "붉고 예민한 홍조 민감형",
                    "예민한데 번들거리기도 해요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "예민하면서 피지가 많은 피부는 강한 피지 케어 성분이 자극이 될 수 있어요. 무향·오일프리 성분으로 자극 없이 피지를 케어하는 게 중요해요.",
                    List.of("피부 예민","피지 과잉","복합 케어"),
                    List.of(IngredientType.NIACINAMIDE, IngredientType.CENTELLA, IngredientType.PANTHENOL)
            ),

            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.BRIGHTENING,
                    "붉고 예민한 홍조 민감형",
                    "예민해서 톤 케어도 조심스러워요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "예민한 피부에서 강한 미백 성분은 피부를 자극해 오히려 색소를 더 만들어요. 자극 없는 순한 미백 성분만 사용하고, 선크림으로 색소 악화를 막는 게 지금 가장 중요해요.",
                    List.of("피부 예민","톤 불균일", "색소 침착"),
                    List.of(IngredientType.ARBUTIN, IngredientType.PANTHENOL, IngredientType.NIACINAMIDE_LOW)
            ),

            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.TURNOVER,
                    "붉고 예민한 홍조 민감형",
                    "예민해서 각질 관리가 조심스러워요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "예민한 피부에 AHA나 BHA를 쓰면 심한 자극이 올 수 있어요. PHA가 유일하게 안전한 선택이에요. 각질 케어 빈도도 주 1~2회로 줄이고, 케어 후 진정을 꼭 해야 해요.",
                    List.of("피부 예민","각질 누적", "케어 조심스러움"),
                    List.of(IngredientType.PHA, IngredientType.PANTHENOL, IngredientType.CENTELLA)
            ),

            entry(
                    IngredientGroup.SOOTHING,
                    IngredientGroup.ANTI_AGING,
                    "붉고 예민한 홍조 민감형",
                    "예민한데 탄력까지 신경 쓰여요",
                    "자극에 쉽게 달아오르는 피부예요. 세안 후, 온도 변화, 마스크 착용 후에 볼이 붉어지고 열감이 느껴지는 경험이 잦아요. 피부 자체가 얇고 혈관 반응이 민감한 편이라, 진정과 장벽 강화가 함께 이루어져야 해요. 향료·알코올·강한 산성 성분은 피하고, 피부를 최대한 자극 없이 관리하는 것이 핵심이에요. 무엇보다 성분 수를 줄이고 검증된 진정 성분에 집중하는 게 중요해요.",
                    "레티놀은 예민한 피부에 자극이 강해요. 예민함이 충분히 가라앉은 다음 아주 저농도부터 시작하거나, 펩타이드로 자극 없이 탄력을 케어하는 게 안전한 방법이에요.",
                    List.of("피부 예민","탄력 저하", "성분 선택 신중"),
                    List.of(IngredientType.PEPTIDE, IngredientType.PANTHENOL, IngredientType.HYALURONIC_ACID)
            )
    );
    private static Map.Entry<SkinUxKey, SkinUxProfile> entry(
            IngredientGroup top1,
            IngredientGroup top2,
            String typeName,
            String subtitle,
            String summary,
            String subSummary,
            List<String> concerns,
            List<IngredientType> ingredients
    ) {
        return Map.entry(
                SkinUxKey.of(top1, top2),
                new SkinUxProfile(
                        typeName,
                        subtitle,
                        summary,
                        subSummary,
                        concerns,
                        ingredients
                )
        );
    }

}
